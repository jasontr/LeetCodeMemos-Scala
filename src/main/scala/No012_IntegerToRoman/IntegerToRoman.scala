package No012_IntegerToRoman

object IntegerToRoman {
  def intToRoman(num: Int): String = {
    def dict(int: Int): String = int match {
      case 1 => "I"
      case 5 => "V"
      case 10 => "X"
      case 50 => "L"
      case 100 => "C"
      case 500 => "D"
      case 1000 => "M"
      case _ => "?"
    }

    @scala.annotation.tailrec
    def encode(level: Int)(str: String, remains: Int): String = {
      remains match {
        case 0 => str
        case x if x >= level => encode(level)(str + dict(level), remains - level)
        case x if x >= (0.9 * level) => encode(level/10)(str + dict(level/10) + dict(level), remains - (0.9 * level).toInt)
        case x if x >= (level / 2) => encode(level/10)(str + dict(level / 2), remains - level / 2)
        case x if x >= (0.4 * level) => encode(level/10)(str + dict(level/10) + dict(level/2), remains - (0.4 * level).toInt)
        case _ => encode(level/10)(str, remains)
      }
    }

    encode(1000)("", num)
  }
}
