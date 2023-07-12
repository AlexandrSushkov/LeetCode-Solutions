package com.example.leetcodeproblems.solution

import org.junit.Test
import org.junit.Assert.assertEquals

class Solution35Test {

    private val solution = Solution35(intArrayOf(), 1)

    @Test
    fun `WHEN array is empty THEN return 0`() {
        val result = solution.execute()
        assertEquals(0, result)
    }
}
