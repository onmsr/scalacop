package onmsr.scalacop.chapter12

import scala.language.implicitConversions

trait Philosophical {
  def philosophize() = {
    println("hogehoge")
  }
}

class Frog extends AnyRef with Philosophical {
  override def toString = "green"
}

// 抽象メソッドと具象メソッド分離
trait OnlyInterface {
  def getInt(): Int
}
trait ImplByOnlyInterface extends OnlyInterface {
  def getInt2() = getInt + 10
}

// Orderedトレイト使い方
case class Version(major: Int, middle: Int, minor: Int) extends Ordered[Version] {
  // 1引数関数(Ordered)から2引数関数(Ordering)へマッピング。implicitではなく、継承で実現。
  def compare(that: Version): Int = Version.ordering.compare(this, that)
}
object Version {
  // Ordering作成。case classの構成要素で比較可能+3タプル(Int)の比較はすでにある -> Versionからタプルに変換すればいい
  val ordering: Ordering[Version] = Ordering.by(unapply)
}

/** 12章まとめ trait
 * traitのパターン
 * - メソッドなし (マーカー。ドメインの概念を表すために定義)
 * - 抽象メソッド (インターフェース定義的)
 * - 具象メソッド (実装定義)
 * - 抽象メソッド + 具象メソッド (抽象インターフェースでプログラミングする場合。テンプレートパターン)
 *
 * trait特徴
 * - クラスパラメーターは持てない。abstract classは持てる。 // 20.5節
 * - super呼び出しが動的に束縛される。クラスは静的。
 *
 * abstract classとtraitの使い分け基準
 * - abstract class: ふるまいが再利用されない場合。newできない。
 * - trait: 複数の無関係なクラスで再利用される可能性がある場合。クラス階層の異なる部分にミックスインできるから。
 */
