package onmsr.scalacop

object Main {
  def main(args: Array[String]) = {
    println("Hello, fpscala")
  }
  
  def test(name: String) = {
    s"${name}!"
  }

  def kuku(n: Int): String = (for {i <- 1 to n; j <- 1 to n } yield i*j).grouped(n).map(_.mkString("\t")).mkString("\n")
}

