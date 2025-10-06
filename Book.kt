data class Book(
    val id: Int,
    var title: String,
    var author: String,
    var year: Int,
    var status: String // "available" oder "borrowed"
)