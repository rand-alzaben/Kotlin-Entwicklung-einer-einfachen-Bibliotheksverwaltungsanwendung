fun main() {
    val manager = LibraryManager()
    var running = true

    while (running) {
        println("\n1. Add Book")
        println("2. View Book")
        println("3. Update Book")
        println("4. Delete Book")
        println("5. List Books")
        println("6. Exit")
        print("Choice: ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("ID: ")
                val id = readLine()?.toIntOrNull()
                if (id == null) {
                    println("Invalid ID")
                    continue
                }

                print("Title: ")
                val title = readLine() ?: ""

                print("Author: ")
                val author = readLine() ?: ""

                print("Year: ")
                val year = readLine()?.toIntOrNull()
                if (year == null) {
                    println("Invalid year")
                    continue
                }

                print("Status (available/borrowed): ")
                val status = readLine() ?: ""

                manager.addBook(Book(id, title, author, year, status))
            }

            2 -> {
                print("Enter Book ID to view: ")
                val id = readLine()?.toIntOrNull()
                if (id == null) {
                    println("Invalid ID")
                    continue
                }

                val book = manager.getBookById(id)
                if (book != null) {
                    println(book)
                } else {
                    println("Book not found.")
                }
            }

            3 -> {
                print("Enter Book ID to update: ")
                val id = readLine()?.toIntOrNull()
                if (id == null) {
                    println("Invalid ID")
                    continue
                }

                val book = manager.getBookById(id)
                if (book == null) {
                    println("Book not found.")
                    continue
                }

                print("New Title (leave empty to keep current): ")
                val newTitle = readLine()
                if (!newTitle.isNullOrBlank()) book.title = newTitle

                print("New Author (leave empty to keep current): ")
                val newAuthor = readLine()
                if (!newAuthor.isNullOrBlank()) book.author = newAuthor

                print("New Year (leave empty to keep current): ")
                val newYear = readLine()
                val parsedYear = newYear?.toIntOrNull()
                if (parsedYear != null) book.year = parsedYear

                print("New Status (leave empty to keep current): ")
                val newStatus = readLine()
                if (!newStatus.isNullOrBlank()) book.status = newStatus

                manager.updateBook(book)
            }

            4 -> {
                print("Enter Book ID to delete: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    manager.deleteBook(id)
                } else {
                    println("Invalid ID")
                }
            }

            5 -> {
                val books = manager.listBooks()
                if (books.isEmpty()) {
                    println("No books available.")
                } else {
                    books.forEach { println(it) }
                }
            }

            6 -> {
                println("Exiting...")
                running = false
            }

            else -> {
                println("Invalid choice.")
            }
        }
    }
}