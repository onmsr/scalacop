package onmsr.scalacop.chapter19

import org.specs2.mutable.Specification

class QueueSpec extends Specification {
  "QueueSpec" should {
    "test" in {
      val q = (new Queue[Int] /: (1 to 10)) { _.enqueue(_) }
      q.head must_== 1
      // true must_== false
    }
    "キューに追加して、先頭要素を取り出せる" in {
      val q = (new Queue[Int] /: (1 to 10)) { _.enqueue(_) }
      q.head must_== 1
    }
  }
}
