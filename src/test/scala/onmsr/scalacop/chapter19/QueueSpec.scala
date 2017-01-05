package onmsr.scalacop.chapter19

import org.specs2.mutable.Specification

class QueueSpec extends Specification {
  "QueueSpec" should {
    "test" in {
      true must_== false
    }
    "Queueに追加して、先頭要素を取り出せる" in {
      val q = Queue((1 to 10): _*)
      q.head must_== 1
    }
    "HybridQueueに追加して、先頭要素を取り出せる" in {
      val q = HybridQueue((1 to 10): _*)
      q.head must_== 1
    }
  }
}
