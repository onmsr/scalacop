package onmsr.scalacop

object Main {
  def main(args: Array[String]) = {
    println("Hello")
  }
  // def kuku(n: Int): String = (for {i <- 1 to n; j <- 1 to n } yield i*j).grouped(n).map(_.mkString("\t")).mkString("\n")
  def kuku(n: Int): String = List.tabulate(n+1, n+1)(_*_).map(_.mkString("\t")).mkString("\n")
}


