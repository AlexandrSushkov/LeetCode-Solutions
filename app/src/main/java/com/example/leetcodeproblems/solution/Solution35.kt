package com.example.leetcodeproblems.solution

/**
 * Search Insert Position
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 */
class Solution35 {
    fun execute(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return 0
        val firstItemInArray = nums[0]
        if (target <= firstItemInArray) return 0
        if (nums.size == 1 && target > firstItemInArray) return 1
        if (nums.size == 2) {
            return if (target > nums[1]) {
                2
            } else if (target > firstItemInArray) {
                1
            } else {
                0
            }
        }
        var startRangePointer = 0
        var endRangePointer = nums.size - 1
        var result = -1
        // todo: shrink search range to 3 elements
        while (endRangePointer - startRangePointer > 2) {
            val rangeSize = endRangePointer - startRangePointer + 1
            val midRangePointer = startRangePointer + rangeSize / 2

            if (nums[midRangePointer] == target) {
                result = midRangePointer
                break
            }
            if (nums[midRangePointer] < target) {
                // update range, take right
                startRangePointer = midRangePointer + 1
            }
            if (nums[midRangePointer] > target) {
                // update range, take left
                endRangePointer = midRangePointer - 1
            }
        }
        if (result == -1) {
            // search pointers in range of 2 o 3 elements
            if (endRangePointer - startRangePointer == 2) {
                //3 elements
                val first = nums[startRangePointer]
                val second = nums[startRangePointer + 1]
                val third = nums[endRangePointer]
                result = if (target > third) {
                    endRangePointer + 1
                } else if (target == third) {
                    endRangePointer
                } else if (target > second) {
                    endRangePointer
                } else if (target == second) {
                    endRangePointer - 1
                } else if (target > first) {
                    startRangePointer + 1
                } else {
                    startRangePointer
                }
            } else {
                // 2 elements
                val first = nums[startRangePointer]
                val second = nums[endRangePointer]
                if (target > second) {
                    result = endRangePointer + 1
                } else if (target == second) {
                    result = endRangePointer
                } else if (target > first) {
                    result = startRangePointer + 1
                } else {
                    result = startRangePointer
                }
            }
        }

        return result
    }
}