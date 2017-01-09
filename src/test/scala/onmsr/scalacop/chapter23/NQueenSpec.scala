package onmsr.scalacop.chapter23

import org.specs2.mutable.Specification

class NqueenSpec extends Specification {
  "NqueenSpec" should {
    "test" in {
      val ans = NQueen.queens(4)
      // println(ans)
      ans must_== List(
        List((4,3), (3,1), (2,4), (1,2)),
        List((4,2), (3,4), (2,1), (1,3)))
    }
  }
}
