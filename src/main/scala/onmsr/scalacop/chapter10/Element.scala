package onmsr.scalacop.chapter10

import Element.elem

abstract class Element {
  def contents: Array[String] // defの実装はvalでも良い
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length
  def above(that: Element): Element = elem(this.contents ++ that.contents)
  def beside(that: Element): Element = elem(
    for {
      (line1, line2) <- this.contents zip that.contents
    } yield line1 + line2
  )
  override def toString = contents.mkString("\n")
}

object Element {
  // Elementにファクトリーメソッドを追加してElementのみ公開する
  def elem(contents: Array[String]): Element = new ArrayElement(contents)
  def elem(chr: Char, width: Int, height: Int): Element = new UniformElement(chr, width, height)
  def elem(line: String): Element = new LineElement(line)

  // 内部実装を公開しない。アクセスもファクトリーメソッドから行うことによりElement型しか見えないようにする。内部実装を簡単に変更できる
  // 外からみたときにElementしか見えないのはわかりにくくないのか？
  private class ArrayElement(val contents: Array[String]) extends Element {}

  private class LineElement(s: String) extends Element {
    val contents = Array(s)
  }

  private class UniformElement(
    ch: Char,
    override val width: Int,
    override val height: Int
  ) extends Element {
    private val line = ch.toString * width
    def contents = Array.fill(height)(line)
  }
}


/** 10章まとめ
 * - abstract class
 * - 連続パラメーター
 * - パラメーターフィールド
 */
