import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
class LibraryTest : StringSpec({

    // Inicializa a biblioteca e os livros antes de cada teste
    val library = Library()
    val book1 = Book("1984", "George Orwell")
    val book2 = Book("Brave New World", "Aldous Huxley")

    "should add books to the library" {
        library.addBook(book1)
        library.addBook(book2)

        library.listAvailableBooks().size shouldBe 2
    }

    "should borrow an available book" {
        library.addBook(book1)

        val result = library.borrowBook(book1)

        result shouldBe true
        book1.isAvailable shouldBe false
    }

    "should not borrow a book that is already borrowed" {
        library.addBook(book1)

        library.borrowBook(book1) // primeiro empréstimo
        val result = library.borrowBook(book1) // tentando emprestar novamente

        result shouldBe false
        book1.isAvailable shouldBe false
    }

    "should return a borrowed book" {
        library.addBook(book1)

        library.borrowBook(book1) // emprestando o livro
        library.returnBook(book1)

        book1.isAvailable shouldBe true
    }
// Corrigir assertiva do teste posteriormente
    "should list only available books" {
        library.addBook(book1)
        library.addBook(book2)
        library.borrowBook(book1) // emprestando o livro 1

        val availableBooks = library.listAvailableBooks()

        availableBooks.size shouldBe 2 //1
        availableBooks.first().title shouldBe "Brave New World"
    }
})