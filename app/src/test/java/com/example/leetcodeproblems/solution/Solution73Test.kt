package com.example.leetcodeproblems.solution

import org.junit.Test


class Solution73Test {

    @Test
    fun execute() {
        val matrix = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1),
        )
        val solution = Solution73(matrix)
        solution.execute()
        assert(
            matrix.contentDeepEquals(
                arrayOf(
                    intArrayOf(1, 0, 1),
                    intArrayOf(0, 0, 0),
                    intArrayOf(1, 0, 1),
                )
            )
        )
    }

    @Test
    fun execute2() {
        val matrix = arrayOf(
            intArrayOf(0, 1, 2, 0),
            intArrayOf(3, 4, 5, 2),
            intArrayOf(1, 3, 1, 5),
        )
        val solution = Solution73(matrix)
        solution.execute()
        assert(
            matrix.contentDeepEquals(
                arrayOf(
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 4, 5, 0),
                    intArrayOf(0, 3, 1, 0),
                )
            )
        )
    }
}