package onmsr.scalacop.chapter33

import scala.util.parsing.combinator._

/**
  * expr ::= term { "+" term | "-" term }
  * term ::= factor { "+" factor | "-" factor }
  * factor ::= floatingPointNumber | "(" expr ")"
  */

trait Arith extends JavaTokenParsers {
  def expr: Parser[Any] = term ~ rep("+"~term | "-"~term)
  def term: Parser[Any] = factor~rep("*"~factor | "/"~factor)
  def factor: Parser[Any] = floatingPointNumber | "(" ~ expr ~ ")"
}

object ExprParser extends Arith {
  def parseExpr(exprStr: String) = parse(expr, exprStr)
}

object Main {
  def main(args: Array[String]) = {

  }
}

/**33章まとめ
 *
 *
 *
 *
 *
 */
