package amyc.test

import amyc.parsing._
import org.junit.Test

class LexerTests extends TestSuite {
  val pipeline = AmyLexer.andThen(DisplayTokens)

  val baseDir = "lexer"

  val outputExt = "txt"

  @Test def testKeywords = shouldOutput("Keywords")

  // Passing tests
  @Test def testOperators = shouldOutput("Operators")
  @Test def testIdentifiers = shouldOutput("Identifiers")
  @Test def testLiterals = shouldOutput("Literals")
  @Test def testDelimiters = shouldOutput("Delimiters")
  @Test def testComments = shouldOutput("Comments")
  @Test def testWhitespace = shouldOutput("Whitespace")

  // Failing tests
  @Test def testUnclosedComment = shouldFail("UnclosedComment")
  @Test def testUnclosedString = shouldFail("UnclosedString")
  @Test def testInvalidToken = shouldFail("InvalidToken")
  @Test def testIntegerOverflow = shouldFail("IntegerOverflow")

}
