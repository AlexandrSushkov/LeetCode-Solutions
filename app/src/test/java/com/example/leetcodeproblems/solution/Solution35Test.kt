package com.example.leetcodeproblems.solution

import org.junit.Test
import org.junit.Assert.assertEquals

class Solution35Test {

    private val solution = Solution35()

    @Test
    fun `WHEN array is empty THEN return 0`() {
        val result = solution.execute(intArrayOf(), 1)
        assertEquals(0, result)
    }
}
