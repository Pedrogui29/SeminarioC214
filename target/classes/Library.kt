class Library {
    private val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun removeBook(book: Book): Boolean {
        return books.remove(book)
    }

    fun borrowBook(book: Book): Boolean {
        return if (book.isAvailable) {
            book.isAvailable = false
            true
        } else {
            false
        }
    }

    fun returnBook(book: Book) {
        book.isAvailable = true
    }

    fun listAvailableBooks(): List<Book> {
        return books.filter { it.isAvailable }
    }
}