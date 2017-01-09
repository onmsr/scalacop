package onmsr.scalacop.chapter25

import org.specs2.mutable.Specification

class MainSpec extends Specification {
  "MainSpec" should {
    "test" in {
      val xs = List(A, G, T, A)
      val rna1 = RNA1.fromSeq(xs)
      rna1 must_== RNA1(A, G, T, A)
    }
  }
}
