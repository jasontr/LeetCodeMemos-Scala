package No134_GasStation

object GasStation {
  def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
    var station = 0
    var tank = 0
    val l = gas.length
    var p = new Array[Int](l)
    for (i <- 0 until l) {
      val res = gas(i) - cost(i)
      p(i) = res
      tank += res
      while (tank < 0) {
        tank -= p(station)
        station += 1
      }
    }
    if (p.sum < 0) -1 else station
  }
}
