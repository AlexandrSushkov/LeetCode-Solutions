package com.example.leetcodeproblems.solution

class Solution26(private val nums: IntArray): Solution<Int> {
    override fun execute(): Int {
        if (nums.isEmpty()) return 0
        var insertIndex = 0
        for (i in nums.indices) {
            if (nums[i] != nums[insertIndex]) {
                insertIndex++
                nums[insertIndex] = nums[i]
            }
        }
        return insertIndex + 1
    }
}