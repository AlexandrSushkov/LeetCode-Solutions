package com.example.leetcodeproblems.solution

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */
class Solution169(private val nums: IntArray) : Solution<Int> {

    override fun execute(): Int {
        return majorityElement(nums)
    }

    private fun majorityElement(nums: IntArray): Int {
        if (nums.size == 1) return nums.first()
        // <int, count>
        val storage = mutableMapOf<Int, Int>()
        nums.forEach {
            if (storage.containsKey(it)) {
                storage[it] = storage[it]!! + 1
            } else {
                storage[it] = 1
            }
        }

        return storage.entries.maxBy { it.value }.key
    }
}