package com.example.leetcodeproblems.solution

class Solution88(
    private val nums1: IntArray,
    private val m: Int,
    private val nums2: IntArray,
    private val n: Int
) : Solution<Unit> {

    override fun execute() {
        var read1Index = m - 1
        var read2Index = n - 1
        for (writeIndex in nums1.lastIndex downTo 0) {
            if (read2Index < 0) break
            if (read1Index >= 0 && nums1[read1Index] > nums2[read2Index]) {
                nums1[writeIndex] = nums1[read1Index--]
            } else {
                nums1[writeIndex] = nums2[read2Index--]
            }
        }
    }
}