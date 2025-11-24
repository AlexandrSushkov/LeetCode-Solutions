package com.example.leetcodeproblems.solution

/**
 * A peak element is an element that is strictly greater than its neighbors.
 *
 * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 *
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
 *
 * You must write an algorithm that runs in O(log n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 */

class Solution162(private val nums: IntArray) : Solution<Int> {

    override fun execute(): Int {
        // edge case #1
        if (nums.size == 1) return 0

        // edge case #2. peak is first
        if (nums[0] > nums[1]) return 0

        // edge case #3. peak is last
        if (nums[nums.size - 2] < nums[nums.size - 1]) {
            return nums.size - 1
        }

        // edge case #4. peak is in the middle
        var leftIndex = 0
        var rightIndex = nums.size - 1
        var midIndex = (leftIndex + rightIndex) / 2
        var isMidPeak = false

        while (!isMidPeak) {
            midIndex = (leftIndex + rightIndex) / 2

            // if min neighbours is less then min -> mid is peak
            if (nums[midIndex - 1] < nums[midIndex] && nums[midIndex] > nums[midIndex + 1]) {
                isMidPeak = true
                continue
            }

            // if left min's neighbour is more then mid -> peak is to the left
            if (nums[midIndex] < nums[midIndex - 1]) {
                rightIndex = midIndex
                continue
            }

            // if left min's neighbour is less then min -> peak is to the right
            if (nums[midIndex] > nums[midIndex - 1]) {
                leftIndex = midIndex
                continue
            }
        }

        return midIndex
    }
}
