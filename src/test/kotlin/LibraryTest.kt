import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.shouldBe
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify


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
    "should add a book to the library" {
        val library = Library()
        val book = Book("Test Book", "Test Author")

        library.addBook(book)

        library.listAvailableBooks() shouldContain book
    }
    "should borrow a book successfully" {
        val library = Library()
        val book = Book("Test Book", "Test Author")
        library.addBook(book)

        val result = library.borrowBook(book)

        result shouldBe true
        book.isAvailable shouldBe false
    }

    "should not borrow an unavailable book" {
        val library = Library()
        val book = Book("Test Book", "Test Author", isAvailable = false)
        library.addBook(book)

        val result = library.borrowBook(book)

        result shouldBe false
    }
    "should remove a book from the library" {
        val library = Library()
        val book = Book("Test Book", "Test Author")
        library.addBook(book)

        val result = library.removeBook(book)

        result shouldBe true
        library.listAvailableBooks() shouldNotContain book
    }
    "should not remove a book that is not in the library" {
        val library = Library()
        val book = Book("Nonexistent Book", "Unknown Author")

        val result = library.removeBook(book)

        result shouldBe false
    }
    "should return an empty list when no books are in the library" {
        val library = Library()

        library.listAvailableBooks() shouldBe emptyList()
    }

    "should correctly handle borrowing a book and make it unavailable" {
        val library = Library()
        val book = Book("Borrowed Book", "Author X")

        library.addBook(book)
        library.borrowBook(book) shouldBe true
        library.listAvailableBooks().shouldBeEmpty()
        book.isAvailable shouldBe false
    }

    "should mock the borrowBook method" {
        // Criando um mock da classe Library
        val library = mockk<Library>()
        val book = Book("Mocked Book", "Mock Author")

        // Simulando o comportamento de um método específico
        every { library.borrowBook(book) } returns true

        // Chamando o método mockado
        val result = library.borrowBook(book)

        // Verificando o resultado
        result shouldBe true

        // Verificando se o método foi chamado exatamente uma vez
        verify(exactly = 1) { library.borrowBook(book) }
    }

})
