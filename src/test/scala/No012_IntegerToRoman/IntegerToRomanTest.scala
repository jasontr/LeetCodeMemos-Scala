package No012_IntegerToRoman

import org.scalatest.FunSuite

class IntegerToRomanTest extends FunSuite {

  test("testIntToRoman") {
    val testCases = List(3, 4, 9, 58, 1994)
    val expects = List("III", "IV", "IX", "LVIII", "MCMXCIV")
    val actuals = testCases.map(IntegerToRoman.intToRoman)
    (expects zip actuals).foreach(pair => assertResult(pair._1)(pair._2))
  }

}
