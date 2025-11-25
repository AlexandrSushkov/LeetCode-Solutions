package com.example.leetcodeproblems.solution

/**
 * [1. Two Sum](https://leetcode.com/problems/two-sum/)
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * ### Example 1:
 * ```
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * ```
 *
 * ### Example 2:
 * ```
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * ```
 *
 * ### Example 3:
 * ```
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * ```
 *
 * ### Constraints:
 * * `2 <= nums.length <= 104`
 * * `-109 <= nums[i] <= 109`
 * * `-109 <= target <= 109`
 * * Only one valid answer exists.
 */
class Solution1(private val nums: IntArray, private val target: Int) : Solution<IntArray> {

    /**
     * Finds two numbers in the input array that add up to the target value.
     *
     * @return An array containing the indices of the two numbers, or an empty array if no solution is found.
     */
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
