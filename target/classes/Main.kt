fun main() {
    val library = Library()

    // Adicionando alguns livros ao sistema
    val book1 = Book("1984", "George Orwell")
    val book2 = Book("Brave New World", "Aldous Huxley")
    val book3 = Book("Fahrenheit 451", "Ray Bradbury")

    library.addBook(book1)
    library.addBook(book2)
    library.addBook(book3)

    println("Livros disponíveis na biblioteca:")
    library.listAvailableBooks().forEach { println(it.title) }

    // Emprestando um livro com base na escolha do usuário
    val bookToBorrow = book3 // Pode ser qualquer livro disponível
    println("\nEmprestando '${bookToBorrow.title}'...")
    if (library.borrowBook(bookToBorrow)) {
        println("'${bookToBorrow.title}' foi emprestado com sucesso!")
    } else {
        println("'${bookToBorrow.title}' não está disponível para empréstimo.")
    }

    // Listando livros disponíveis após o empréstimo
    println("\nLivros disponíveis após o empréstimo:")
    library.listAvailableBooks().forEach { println(it.title) }

    // Devolvendo o livro emprestado
    println("\nDevolvendo '${bookToBorrow.title}'...")
    library.returnBook(bookToBorrow)
    println("'${bookToBorrow.title}' foi devolvido.")

    // Listando livros disponíveis após a devolução
    println("\nLivros disponíveis após a devolução:")
    library.listAvailableBooks().forEach { println(it.title) }
}