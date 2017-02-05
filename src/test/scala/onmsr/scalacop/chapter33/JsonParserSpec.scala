package onmsr.scalacop.chapter33

import org.specs2.mutable.Specification

class JsonParserSpec extends Specification {
  "JsonParserSpec" should {
    "test" in {
      // val result = JsonParser.parseJson(" { \"address\" : \"aaa\" , \"age\" : 20, \"name\" : \"testman\" }")
      // result.get must_== Map("address" -> "aaa", "age" -> 20.0, "name" -> "testman")
      true
    }
    "parse null" in {
      val result = JsonParser.parseJson("null")
      result.successful must_== true
    }
  }
}
