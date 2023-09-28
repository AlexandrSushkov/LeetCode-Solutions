package com.example.leetcodeproblems.solution

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 *
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 */
class Solution62(private val m: Int, private val n: Int) : Solution<Int> {
    private val memo = mutableMapOf<Pair<Int, Int>, Int>()

    override fun execute(): Int {
        return uniquePath(m, n)
    }

    private fun uniquePath(m: Int, n: Int): Int {
        val key = m to n
        if (key in memo) return memo[key]!!
        if (m == 0 || n == 0) return 0
        if (m == 1 && n == 1) return 1

        memo[key] = uniquePath(m - 1, n) + uniquePath(m , n -1)
        return memo[key]!!
    }
}