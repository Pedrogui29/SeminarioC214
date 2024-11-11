import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.shouldBe

class LibraryTest : StringSpec({
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

    "should return a borrowed book" {
        val library = Library()
        val book = Book("Test Book", "Test Author")
        library.addBook(book)
        library.borrowBook(book)

        library.returnBook(book)

        book.isAvailable shouldBe true
    }

    "should list only available books" {
        val library = Library()
        val book1 = Book("The Catcher in the Rye", "J.D. Salinger", isAvailable = true)
        val book2 = Book("Brave New World", "Aldous Huxley", isAvailable = false)

        library.addBook(book1)
        library.addBook(book2)

        library.listAvailableBooks() shouldContain book1
        library.listAvailableBooks() shouldNotContain book2
    }
})
