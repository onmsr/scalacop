package onmsr.scalacop.chapter24

import org.specs2.mutable.Specification

class MainSpec extends Specification {
  "MainSpec" should {
    "fib test" in {
      // https://ja.wikipedia.org/wiki/%E3%83%95%E3%82%A3%E3%83%9C%E3%83%8A%E3%83%83%E3%83%81%E6%95%B0
      val F11 = Main.fib(11)
      F11 must_== 89
    }
  }
}

