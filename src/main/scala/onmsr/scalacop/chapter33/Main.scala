package onmsr.scalacop.chapter33

import scala.util.parsing.combinator._

/**
 * expr ::= term { "+" term | "-" term }
 * term ::= factor { "+" factor | "-" factor }
 * factor ::= floatingPointNumber | "(" expr ")"
 */

trait Arith extends JavaTokenParsers {
  def expr: Parser[Any] = term ~ rep("+" ~ term | "-" ~ term)
  def term: Parser[Any] = factor ~ rep("*" ~ factor | "/" ~ factor)
  def factor: Parser[Any] = floatingPointNumber | "(" ~ expr ~ ")"
}

object ExprParser extends Arith {
  def parseExpr(exprStr: String) = parseAll(expr, exprStr)
}

object MyParsers extends RegexParsers {
  val ident: Parser[String] = """[a-zA-Z_]\w*""".r
}

object Main {
  def main(args: Array[String]) = {
    val lll = 1
    val ddd = 9 + lll
  }
}

/**
 * 33章まとめ
 *
 *
 *
 *
 *
 */
