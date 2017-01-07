package onmsr.scalacop.chapter19

class SlowAppendQueue[T](elems: List[T]) {
  def head = elems.head
  def tail = new SlowAppendQueue(elems.tail)
  def enqueue(x: T) = new SlowAppendQueue(elems ::: List(x)) // 処理時間がO(N)
}

// リスト逆転版
class SlowHeadQueue[T](elems: List[T]) {
  def head = elems.last // 処理時間がO(N)
  def tail = new SlowAppendQueue(elems.init) // 処理時間がO(N)
  def enqueue(x: T) = new SlowAppendQueue(x :: elems)
}

// ハイブリッド版
// 1 2 3 4 5 6 -> (1 2 3) (6 5 4)
// 後半部分を逆転してもっておく
class HybridQueue[T] private (
  private val leading: List[T] = Nil,
  private val trailing: List[T] = Nil
) {
  /**
   * キューを返す。先頭部分が空のときに後半部分を前半部分に移し替える。
   * 先頭部分が空のときに処理時間がO(N)だが、待ち行列が長くなれば呼び出し回数は少ない。
   */
  private def mirror = if (leading.isEmpty) new HybridQueue(trailing.reverse, Nil) else this
  def head = mirror.leading.head
  def tail = {
    val q = mirror
    new HybridQueue(q.leading.tail, q.trailing)
  }
  def enqueue(x: T) = new HybridQueue(leading, x :: trailing)
}

object HybridQueue {
  def apply[T](xs: T*): HybridQueue[T] = new HybridQueue[T](xs.toList, Nil)
}


/** 19章まとめ
 * クラス実装方法
 * - 非公開コンストラクター+非公開メンバー: クラスの初期化と表現を隠蔽
 * - クラス自体を隠す+トレイトを公開
 *
 */

