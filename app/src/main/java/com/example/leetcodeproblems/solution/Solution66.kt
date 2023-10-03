package com.example.leetcodeproblems.solution

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * Example 3:
 *
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 */
class Solution66(private val digits: IntArray) : Solution<IntArray> {

    override fun execute(): IntArray {
        return plusOne(digits)
    }

    private fun plusOne(digits: IntArray): IntArray {
        var storage = 1
        for (i in digits.size - 1 downTo 0) {
            val incremented = digits[i] + storage
            storage = 0
            digits[i] = if (incremented < 10) {
                incremented
            } else {
                storage++
                0
            }
        }

        return if (storage == 0) {
            digits
        } else {
            IntArray(digits.size + 1).apply {
                this[0] = 1
                digits.forEachIndexed { index, i -> this[index + 1] = i }
            }
        }
    }

    /**
     * The only case array can grow is when all digits in original array are 9.
     * In this case result will be 10... so no need to copy the original array.
     * Just create an array with first digit as 1. The rest of the array will be 0.
     *
     * Also, no need to iterate thought entire array.
     * If last digit in not 9 than increment it and return the array.
     *
     * This is the most efficient way to solve this problem.
     */
    private fun plusOne2(digits: IntArray): IntArray {
        for (i in digits.size - 1 downTo 0) {
            digits[i] = digits[i] + 1
            if (digits[i] <= 9) return digits
            digits[i] = 0
        }
        val arr = IntArray(digits.size + 1)
        arr[0] = 1
        return arr
    }
}