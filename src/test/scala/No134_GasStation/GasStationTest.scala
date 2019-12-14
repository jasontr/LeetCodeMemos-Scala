package No134_GasStation

import org.scalatest.FunSuite

class GasStationTest extends FunSuite {

  test("testCanCompleteCircuit") {
    val testCases = Array((Array(1,2,3,4,5), Array(3,4,5,1,2)), (Array(2,3,4), Array(3,4,3)))
    val expects = Array(3, -1)
    val actuals = testCases.map(set => GasStation.canCompleteCircuit(set._1, set._2))
    (expects zip actuals).foreach(set => assertResult(set._1)(set._2))
  }

}
