package onmsr.scalacop.chapter12

import org.specs2.mutable.Specification

class IntQueueSpec extends Specification {
  "IntQueueSpec" should {
    "basic queue test" in {
      val q = new BasicIntQueue
      q.put(10)
      q.get must_== 10
    }
    "basic queue with doubling test" in {
      val q = new BasicIntQueue with Doubling
      q.put(10)
      q.get must_== 20
    }
    "basic queue with incrementing and filtering test" in {
      val q = new BasicIntQueue with Incrementing with Filtering
      q.put(-1)
      q.put(0)
      q.put(1)
      q.get must_== 1
      q.get must_== 2
      // q.get must_== 0 // error
    }
    "proxy test" in {
      // val a = new ProxyImpl with CacheProxy
      val a = new CacheProxyWithTransfer
      a.getResult must_== 1
      a.getResult must_== 1
      a.getResult must_== 1
    }
  }
}
