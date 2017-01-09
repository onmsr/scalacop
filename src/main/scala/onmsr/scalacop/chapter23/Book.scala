package onmsr.scalacop.chapter23

case class Book(title: String, authers: String*)

trait BookRepository {
  def findAll(): List[Book]
  def findByAuthor(query: String): List[Book]
}

trait UsesBookRepository {
  val bookRepository: BookRepository
}

trait MixinBookRepository {
  val bookRepository: BookRepository = BookRepository
}

object BookRepository extends BookRepository {
  def findAll(): List[Book] = List(
    Book("aaa", "111", "222"),
    Book("bbb", "111"),
    Book("ccc", "333")
  )
  def findByAuthor(query: String): List[Book] = {
    for {
      b <- findAll()
      a <- b.authers
      if a.startsWith(query)
    } yield b
  }
}
