package com.example.leetcodeproblems.solution

class Solution268(private val nums: IntArray) : Solution<Int> {
    override fun execute(): Int {
        val expectedSum = nums.size*(nums.size+1)/2
        val actualSum = nums.sum()
        return expectedSum - actualSum
    }
}