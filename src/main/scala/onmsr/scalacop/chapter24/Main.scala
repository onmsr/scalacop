package onmsr.scalacop.chapter24

object Main {
  def fib(n: Int): Int = {
    def fibFrom(a: Int, b: Int): Stream[Int] = a #:: fibFrom(b, a+b)
    fibFrom(0, 1).drop(n).head
  }
}

// TODO: 各データ構造調べる(24.8, 24.9)

/**24章まとめ
 *
 */

