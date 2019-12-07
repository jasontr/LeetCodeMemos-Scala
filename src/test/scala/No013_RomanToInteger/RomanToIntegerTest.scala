package No013_RomanToInteger

import org.scalatest.FunSuite

class RomanToIntegerTest extends FunSuite {

  test("testRomanToInt") {
    val testCases = List("III", "IV", "IX", "LVIII", "MCMXCIV")
    val actuals = testCases.map(RomanToInteger.romanToInt)
    val expects = List(3, 4, 9, 58, 1994)
    (expects zip actuals).foreach(pair => assertResult(pair._1)(pair._2))
  }

}
