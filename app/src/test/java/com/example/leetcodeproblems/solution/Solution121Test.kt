package com.example.leetcodeproblems.solution

import junit.framework.TestCase.assertEquals
import org.junit.Test

class Solution121Test {

    @Test
    fun `WHEN array is empty THEN return 0`() {
        val solution = Solution121(intArrayOf())
        val result = solution.execute()
        assertEquals(0, result)
    }

    @Test
    fun `WHEN lowest item before highest THEN return profit`() {
        val solution = Solution121(intArrayOf(7, 1, 5, 3, 6, 4))
        val result = solution.execute()
        assertEquals(5, result)
    }

    @Test
    fun `WHEN no highest item after lowest item THEN return 0`() {
        val solution = Solution121(intArrayOf(7, 6, 4, 3, 1))
        val result = solution.execute()
        assertEquals(0, result)
    }
}