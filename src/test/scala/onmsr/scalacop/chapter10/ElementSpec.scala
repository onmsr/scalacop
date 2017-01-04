package onmsr.scalacop.chapter10

import org.specs2.mutable.Specification

class ElementSpec extends Specification {
  "ElementSpec" should {
    "test" in {
      val ae = Element.elem(Array("a", "b"))
      ae.height must_== 2
    }
  }
}






