package com.example.leetcodeproblems.solution

class Solution217(private val nums: IntArray): Solution<Boolean>  {
    override fun execute(): Boolean {
        val setOfNums = nums.toSet()
        return setOfNums.size != nums.size
    }
}