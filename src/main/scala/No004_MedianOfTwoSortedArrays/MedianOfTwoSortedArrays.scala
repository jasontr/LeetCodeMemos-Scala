package No004_MedianOfTwoSortedArrays

object MedianOfTwoSortedArrays {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    val totalSize: Int = nums1.length + nums2.length
    val isEven: Boolean = totalSize % 2 == 0
    @scala.annotation.tailrec
    def find(ns1: Array[Int], ns2: Array[Int])(remains: Int): Double = {
      if (remains != 0) {
        (ns1, ns2) match {
          case (n1, Array()) => find(n1.tail, Array[Int]())(remains - 1)
          case (Array(), n2) => find(Array[Int](), n2.tail)(remains - 1)
          case (n1, n2) => if (n1.head > n2.head) find(n1, n2.tail)(remains - 1) else find(n1.tail, n2)(remains - 1)
        }
      } else {
        def compare(smaller: Array[Int], larger: Array[Int]): (Int, Int) = {
          if (smaller.tail.isEmpty) {
            (smaller.head, larger.head)
          } else {
            val b = if (smaller.tail.head > larger.head) larger.head else smaller.tail.head
            (smaller.head, b)
          }
        }
        val (a, b) = (ns1, ns2) match {
          case (n1, Array()) => (n1.head, n1.tail.head)
          case (Array(), n2) => (n2.head, n2.tail.head)
          case (n1, n2) => if (n1.head > n2.head) compare(n2, n1) else compare(n1, n2)
        }

        if (isEven) (a + b).toDouble / 2 else a.toDouble
      }
    }

    val remain: Int = if (isEven) totalSize / 2 - 1 else (totalSize - 1) / 2
    totalSize match {
      case 0 => 0.toDouble
      case 1 => (nums1 ++ nums2).head.toDouble
      case 2 => (nums1 ++ nums2).sum.toDouble / 2
      case _ => find(nums1, nums2)(remain)
    }
  }
}
