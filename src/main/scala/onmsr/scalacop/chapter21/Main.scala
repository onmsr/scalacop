package onmsr.scalacop.chapter21

import scala.language.implicitConversions

trait Okane
object Dollar
case class Dollar(v: Int) extends Okane
case class Euro(v: Int) extends Okane
case class En(v: Int) extends Okane

object Main {
  implicit def euroToEn(e: Euro): En = En(e.v)
  implicit def dollarToEuro(d: Dollar): Euro = Euro(d.v)
  implicit val dollarToEn: Dollar => En = dollarToEuro _ andThen euroToEn _
  // implicit val dollarToEn: Dollar => En = d => euroToEn(dollarToEuro(d))
  def test() = {
    val f = (v: Euro) => { println(v) }
    f(Dollar(1))
  }

  def test2()(implicit a: Dollar, b: Euro, c: En) = {
    // println(s"${a}, ${b}, ${c}")
    (a, b, c)
  }
}

case class Rectangle(width: Int, height: Int) {
  def menseki = width*height
}

object Rectangle {
  // 暗黙のクラスは、ケースクラスになれず、パラメータもひとつのみ。
  implicit class RectangleMaker(width: Int) {
    def x(height: Int) = Rectangle(width, height)
  }
}

object Executor { self =>
  // 2項演算(staticメソッドのように単体で完全なもの)
  def execute[A, B](x: A, y: B): Unit = ???
  class ExecutorOperation[A](x: A) {
    // 使い方1: 1項演算
    def execute[B](y: B): Unit = self.execute(x, y)
  }
  // 使い方2: 処理の追加。処理を行うときだけ一時的にExecutorOperation2に変換して処理を追加する。
  // リッチラッパーパターン
  class ExecutorOperation2[A](x: A) {
    def execute[B](y: B): A = { /* 実装 */ ??? }
  }
  implicit def any2ExecutorOperation[A](x: A): ExecutorOperation[A] = new ExecutorOperation(x)
}


/** 21章まとめ
 * 暗黙の型変換の適用場所
 * 1.要求された型への変換
 * 2.レシーバーの変換
 * 3. 暗黙のパラメーター
 *
 * [要求された型への変換]
 *   例: val i: Int = 3.5
 *   推奨: 制限の強い型から一般的な型への変換(例 Int -> Double)
 *   推奨しない: 目に見えない形で情報の精度が落ちるような変換(例 Double -> Int)
 *
 * [レシーバーの変換]
 *   例: val obj: A = new A; obj.do() // objはdoメソッドをもっていない
 * よく使われる状況
 * - 既存のクラス階層に新しいクラスを円滑に組み込むこと
 * - scala言語の枠内でDSLを書くためのサポート
 *
 * よく使われるとき
 * - 2項演算(staticメソッドのように単体で完全なもの)から1項演算に。
 * - 処理を行うときだけ一時的に変換して処理の追加する。(リッチラッパーパターン)
 *
 * [暗黙のパラメーター]
 * 例: someCall(v) // 本当はsomeCall(v)(a, b, c)
 * カリー化された最後のパラメーターリスト全体
 *
 * [メモ]
 * - implicitly
 * - コンテキスト境界よくわかんない // TODO: コンテキスト境界復習
 *
 */

/** 22章まとめ
  * [メモ]
  * - 見かけ上では純粋関数型、内部では命令形実装がscala実装の基本戦略となっている。
  *   内部では純粋性を逸脱して処理効率を重視、その部分を注意深く隠蔽して外に提供する。
  *
  */
