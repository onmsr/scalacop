package onmsr.scalacop.chapter12

import org.specs2.mutable.Specification

class MainSpec extends Specification {
  "MainSpec" should {
    "test" in {
      (Version(1, 0, 0) > Version(0, 9, 0)) must_== true
      // true must_== false
    }
  }
  "Ordered and Ordering test" should {
    "compare version" in {
      (Version(1, 0, 0) > Version(0, 9, 0)) must_== true
    }
  }
}
