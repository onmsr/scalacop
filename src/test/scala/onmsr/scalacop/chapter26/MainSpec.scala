package onmsr.scalacop.chapter26

import org.specs2.mutable.Specification

class MainSpec extends Specification {
  "MainSpec" should {
    

    "extracotr test" in {
      val actual = "scala@example.com" match { case EMail(user, domain) => (user, domain) }
      val expected = ("scala", "example.com")
      actual must_== expected
    }

    "regex extracotr test" in {
      val Decimal = """(-)?(\d+)(\.\d*)?""".r
      val Decimal(sign, integerpart, decimalpart) = "-1.23"
      val expected = ("-", "1", ".23")
      (sign, integerpart, decimalpart) must_== expected
    }
  }
}
