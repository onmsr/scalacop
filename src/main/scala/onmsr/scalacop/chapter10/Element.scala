package onmsr.scalacop.chapter10

abstract class Element {
  def contents: Array[String] // defの実装はvalでも良い
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length
  def above(that: Element): Element = new ArrayElement(this.contents ++ that.contents)
  def beside(that: Element): Element = new ArrayElement(
    for {
      (line1, line2) <- this.contents zip that.contents
    } yield line1 + line2
  )
  override def toString = contents.mkString("\n")
}

class ArrayElement(val contents: Array[String]) extends Element {}

class LineElement(s: String) extends Element {
  val contents = Array(s)
}

class UniformElement(
  ch: Char,
  override val width: Int,
  override val height: Int
) extends Element {
  private val line = ch.toString * width
  def contents = Array.fill(height)(line)
}

object Element {
  def elem(contents: Array[String]): Element = new ArrayElement(contents)
  def elem(chr: Char, width: Int, height: Int): Element = new UniformElement(chr, width, height)
  def elem(line: String): Element = new LineElement(line)
}
