package com.example.leetcodeproblems.solution

import android.icu.text.RelativeDateTimeFormatter.RelativeUnit
import kotlin.math.max

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
class Solution198(private val nums: IntArray) : Solution<Int> {

    override fun execute(): Int {
        return rob(nums)
    }

    private fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        val N: Int = nums.size

        val maxRobAmount = IntArray(nums.size + 1)

        // Base case initializations.
        maxRobAmount[N] = 0
        maxRobAmount[N - 1] = nums[N - 1]

        for (i in N - 2 downTo 0) {

            // Same as the recursive solution.
            maxRobAmount[i] = max(maxRobAmount[i + 1], maxRobAmount[i + 2] + nums[i])
        }

        return maxRobAmount.first()
    }

}