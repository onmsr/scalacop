package onmsr.scalacop.chapter33

import org.specs2.mutable.Specification

class MainSpec extends Specification {
  "MainSpec" should {
    "test" in {
      val a = ExprParser.parseExpr("3 * (1 + 4)")
      true
    }
  }
}
