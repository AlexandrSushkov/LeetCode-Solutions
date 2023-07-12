package com.example.leetcodeproblems.solution

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
class Solution121(private val prices: IntArray) : Solution<Int> {

    override fun execute(): Int {
        if (prices.isEmpty() || prices.size == 1) return 0

        var l = 0
        var r = 1

        var res = 0
        while (r < prices.size) {
            val cur = prices[r] - prices[l]
            res = Math.max(res, cur)
            if (cur < 0) {
                l = r
            }
            r++
        }

        return res
    }

    companion object {
        private const val DEFAULT_RESULT = 0
    }
}