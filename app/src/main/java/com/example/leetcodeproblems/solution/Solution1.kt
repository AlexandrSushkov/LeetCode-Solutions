package com.example.leetcodeproblems.solution

class Solution1(private val nums: IntArray, private val target: Int) : Solution<IntArray> {

    override fun execute(): IntArray {
        var firstItemIndex = 0
        var secondItemIndex = 0
        for ((index, item) in nums.withIndex()) {
            firstItemIndex = index
            for (i in (index + 1) until nums.size) {
                println("index: $index, item: $item, i: $i, nums[i]: ${nums[i]}")
                if (item + nums[i] == target) {
                    secondItemIndex = i
                    return intArrayOf(firstItemIndex, secondItemIndex)
                }
            }
        }
        return intArrayOf(firstItemIndex, secondItemIndex)
    }
}
