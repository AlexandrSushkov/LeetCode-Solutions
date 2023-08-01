package com.example.leetcodeproblems.solution

class Solution70(private val n: Int):Solution<Int> {
    private val memo = mutableMapOf<Int, Int>()

    override fun execute(): Int {
        return climbStairs(0, n)
    }

    private fun climbStairs(i:Int, n: Int): Int {
        if (i > n) return 0
        if (i == n) return 1
        if (memo.containsKey(i) && memo[i]!! > 0) return memo[i]!!
        if (memo.containsKey(n)) return memo[n]!!
        memo[i] = climbStairs(i + 1, n) + climbStairs(i + 2, n)
        return memo[i]!!
    }
}