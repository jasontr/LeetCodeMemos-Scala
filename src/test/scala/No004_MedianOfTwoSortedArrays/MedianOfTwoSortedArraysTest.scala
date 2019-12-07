package No004_MedianOfTwoSortedArrays

import org.scalatest.FunSuite

class MedianOfTwoSortedArraysTest extends FunSuite {

  test("testFindMedianSortedArrays") {
    val nums1 = Array[Int](1, 3)
    val nums2 = Array[Int](2)
    val result = MedianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2)
    assert(result == 2.0)
  }

  test("testFindMedianSortedArrays - case2") {
    val nums1 = Array[Int](1, 2)
    val nums2 = Array[Int](3, 4)
    val result = MedianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2)
    assert(result == 2.5)
  }

}
