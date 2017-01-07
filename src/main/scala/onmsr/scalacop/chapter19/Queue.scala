package onmsr.scalacop.chapter19

trait Queue[+T] {
  def head: T
  def tail: Queue[T]
  def enqueue[U >: T](x: U): Queue[U]
}

object Queue {
  def apply[T](xs: T*): Queue[T] = new QueueImpl[T](xs.toList, Nil)

  private class QueueImpl[+T] (
    private val leading: List[T],
    private val trailing: List[T]
  ) extends Queue[T] {
    private def mirror = if (leading.isEmpty) new QueueImpl(trailing.reverse, Nil) else this
    def head = mirror.leading.head
    def tail = {
      val q = mirror
      new QueueImpl(q.leading.tail, q.trailing)
    }
    def enqueue[U >: T](x: U) = new QueueImpl(leading, x :: trailing)
  }

  // 改良版(適切に副作用を用いている)
  // privateだとコンパイル通らなくなる
  // [error] Queue.scala:25: covariant type T occurs in contravariant
  //                position in type List[T] of value leading_=
  private class ImprovedQueueImpl[+T] (
    private[this] var leading: List[T],
    private[this] var trailing: List[T]
  ) extends Queue[T] {
    private def mirror() = {
      if (leading.isEmpty) {
        while (!trailing.isEmpty) {
          leading = trailing.head :: leading
          trailing = trailing.tail
        }
      }
    }
    def head = {
      mirror()
      leading.head
    }
    def tail = {
      mirror()
      new QueueImpl(leading.tail, trailing)
    }
    def enqueue[U >: T](x: U) = new QueueImpl(leading, x :: trailing)
  }
}
