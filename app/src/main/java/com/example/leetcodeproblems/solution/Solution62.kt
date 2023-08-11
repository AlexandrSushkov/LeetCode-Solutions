package com.example.leetcodeproblems.solution

class Solution62(private val m: Int, private val n: Int) : Solution<Int> {
    private val memo = mutableMapOf<Pair<Int, Int>, Int>()

    override fun execute(): Int {
        return uniquePath(m, n)
    }

    private fun uniquePath(m: Int, n: Int): Int {
        val key = m to n
        if (memo.containsKey(key)) {
            return memo[key]!!
        }
        if (m == 0 || n == 0) return 0
        if (m == 1 && n == 1) return 1

        memo[key] = uniquePath(m - 1, n) + uniquePath(m , n -1)
        return memo[key]!!
    }
}