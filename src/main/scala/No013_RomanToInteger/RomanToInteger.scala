package No013_RomanToInteger

object RomanToInteger {
  def romanToInt(s: String): Int = {
    def dict(char: Char): Int = char match {
      case 'I' => 1
      case 'V' => 5
      case 'X' => 10
      case 'L' => 50
      case 'C' => 100
      case 'D' => 500
      case 'M' => 1000
      case _ => 0
    }
    @scala.annotation.tailrec
    def find(level: Char)(charseq: List[Char], total: Int): Int = {
      charseq match {
        case Nil => total
        case char :: others =>
          val islowerThanLevel = dict(char) < dict(level)
          val newLevel = if (dict(char) > dict(level)) char else level
          val newTotal = if (islowerThanLevel) total - dict(char) else total + dict(char)
          find(newLevel)(others, newTotal)
      }
    }

    val chars = s.toList.reverse

    find('I')(chars, 0)
  }
}
