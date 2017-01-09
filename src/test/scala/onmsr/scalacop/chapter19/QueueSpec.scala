package onmsr.scalacop.chapter19

import org.specs2.mutable.Specification

class QueueSpec extends Specification {
  "QueueSpec" should {
    "Queueに追加して、先頭要素を取り出せる" in {
      val q = Queue((1 to 10): _*)
      q.head must_== 1
    }
    "HybridQueueに追加して、先頭要素を取り出せる" in {
      val q = HybridQueue((1 to 10): _*)
      q.head must_== 1
    }
    "変位指定のテスト" in {
      // val q: HihenQueue[Cat] = new HihenQueue[Cat](Nil)
      // val q: HihenQueue[Animal] = new HihenQueue[Cat](Nil)
      val q = new LowerBoundsQueue[Orange](Nil)
      // val q2: LowerBoundsQueue[AnyRef] = q.enqueue(new Animal)
      // val q4: LowerBoundsQueue[Orange] = q.enqueue(new Orange)
      val q3: LowerBoundsQueue[Fruit] = q.enqueue(new Apple)
      true
    }
  }
}
