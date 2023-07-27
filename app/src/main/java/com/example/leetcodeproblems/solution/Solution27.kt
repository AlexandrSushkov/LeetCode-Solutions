package com.example.leetcodeproblems.solution

class Solution27(private val nums: IntArray, private val `val`: Int): Solution<Int> {

    override fun execute(): Int {
        if (nums.isEmpty()) return 0
        var insertIndex = 0
        for (i in nums.indices) {
            if (nums[i] != `val`) {
                nums[insertIndex] = nums[i]
                insertIndex++
            }
        }
        return insertIndex
    }
}