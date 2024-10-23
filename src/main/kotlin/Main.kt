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

    // Emprestando o primeiro livro
    println("\nEmprestando '1984'...")
    if (library.borrowBook(book1)) {
        println("'1984' foi emprestado com sucesso!")
    } else {
        println("'1984' não está disponível para empréstimo.")
    }

    // Tentando emprestar o mesmo livro novamente
    println("\nTentando emprestar '1984' novamente...")
    if (library.borrowBook(book1)) {
        println("'1984' foi emprestado com sucesso!")
    } else {
        println("'1984' não está disponível para empréstimo.")
    }

    // Listando livros disponíveis após o empréstimo
    println("\nLivros disponíveis após o empréstimo:")
    library.listAvailableBooks().forEach { println(it.title) }

    // Devolvendo o livro emprestado
    println("\nDevolvendo '1984'...")
    library.returnBook(book1)
    println("'1984' foi devolvido.")

    // Listando livros disponíveis após a devolução
    println("\nLivros disponíveis após a devolução:")
    library.listAvailableBooks().forEach { println(it.title) }
}