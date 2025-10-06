class LibraryManager {
    private val books = mutableMapOf<Int, Book>()

    fun addBook(book: Book) {
        if (books.containsKey(book.id)) {
            println("Book with ID ${book.id} already exists.")
        } else {
            books[book.id] = book
            println("Book added successfully.")
        }
    }

    fun getBookById(id: Int): Book? {
        return books[id]
    }

    fun updateBook(book: Book) {
        if (books.containsKey(book.id)) {
            books[book.id] = book
            println("Book updated successfully.")
        } else {
            println("Book with ID ${book.id} not found.")
        }
    }

    fun deleteBook(id: Int) {
        if (books.remove(id) != null) {
            println("Book deleted successfully.")
        } else {
            println("Book with ID $id not found.")
        }
    }

    fun listBooks(): List<Book> {
        return books.values.toList()
    }
}