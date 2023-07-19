package com.example.leetcodeproblems.solution

import java.util.Stack

class Solution283(private val nums: IntArray): Solution<Unit> {
    override fun execute() {
        val stackOfZeroIndexes = Stack<Int>()
        nums.forEachIndexed { index, num ->
            if (num == 0) {
                stackOfZeroIndexes.push(index)
            }
        }
        val zerosInArrayCount = stackOfZeroIndexes.size
        while (stackOfZeroIndexes.isNotEmpty()){
            val zeroIndex = stackOfZeroIndexes.pop()
            for (i in zeroIndex until nums.size - 1) {
                nums[i] = nums[i + 1]
            }
        }
        for (i in nums.size - zerosInArrayCount until nums.size) {
            nums[i] = 0
        }
    }
}