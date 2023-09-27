package com.example.leetcodeproblems.solution

import kotlin.math.min

/**
 * https://leetcode.com/problems/coin-change/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 */
class Solution322(private val coins: IntArray, private val amount: Int) : Solution<Int> {

    /**
     * Int - targetSum
     * Int - amount of coins to make target sum
     */
    private val memo = mutableMapOf<Int, Int>()

    override fun execute(): Int {
        return bestSum(coins, amount)
    }

    private fun bestSum(coins: IntArray, targetSum: Int): Int {
        if (targetSum < 0) return -1
        if (targetSum in memo) return memo[targetSum]!!
        if (targetSum == 0) return 0

        var shortestCombinationCount = Int.MAX_VALUE

        coins.forEach { coin ->
            val remainder = targetSum - coin
            val remainderCombinationSize = bestSum(coins, remainder)
            if (remainderCombinationSize != -1) {
                shortestCombinationCount = min(shortestCombinationCount, remainderCombinationSize + 1)
            }
        }

        if (shortestCombinationCount == Int.MAX_VALUE) {
            shortestCombinationCount = -1
        }

        memo[targetSum] = shortestCombinationCount
        return shortestCombinationCount
    }
}