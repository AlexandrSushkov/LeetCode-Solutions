package com.example.leetcodeproblems.solution

import org.junit.Test
import org.junit.Assert.assertEquals

class Solution64Test {

    @Test
    fun case1() {
        val testData =
            arrayOf(
                intArrayOf(1, 3, 1),
                intArrayOf(1, 5, 1),
                intArrayOf(4, 2, 1),
            )
        val solution = Solution64(testData)
        val result = solution.execute()
        assertEquals(7, result)
    }
}