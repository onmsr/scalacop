package onmsr.scalacop.chapter33

import scala.util.parsing.combinator._

/** JSONの構文定義
  *
  * value ::= obj | arr | stringLiteral | floatingPointNumber | "null" | "true" | "false"
  * obj ::= "{" [members] "}"
  * arr ::= "[" [values] "]"
  * members ::= member { "," member }
  * member ::= stringLiteral ":" value
  * values ::= value { "," value }
  */

trait JSONParser1 extends JavaTokenParsers {
  def value: Parser[Any] = obj | arr | stringLiteral | floatingPointNumber | "null" | "true" | "false"
  def obj: Parser[Any] = "{" ~ members ~ "}"
  def arr: Parser[Any] = "[" ~ values ~ "]"
  def members: Parser[Any] = repsep(member, ",")
  def member: Parser[Any] = stringLiteral ~ ":" ~ value
  def values: Parser[Any] = repsep(value, ",")
}

trait JSONParser2 extends JavaTokenParsers {
  def value: Parser[Any] = (
      obj
    | arr
    | stringLiteral
    | floatingPointNumber ^^ (_.toDouble)
    | "null" ^^ (_ => null)
    | "true" ^^ (_ => true)
    | "false" ^^ (_ => false)
  )
  def obj: Parser[Map[String, Any]] = "{" ~> repsep(member, ",") <~ "}" ^^ (Map() ++ _)
  def arr: Parser[List[Any]] = "[" ~> repsep(value, ",") <~ "]"
  def member: Parser[(String, Any)] = stringLiteral ~ ":" ~ value ^^ { case name ~ ":" ~ value => (name, value) }
}

object JsonParser extends JSONParser2 {
  def parseJson(jsonStr: String) = parseAll(value, jsonStr)
}

// type Parser[A, B] = ParseInput[A] => ParseResult[B]
// type Parser[T] = Input => ParseResult[T]
