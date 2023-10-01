package com.example.leetcodeproblems.solution

import org.junit.Assert.assertEquals
import org.junit.Test

class Solution13Test {

    @Test
    fun case1() {
        val testData = "III"
        val solution = Solution13(testData)
        val result = solution.execute()
        assertEquals(3, result)
    }

    @Test
    fun case2() {
        val testData = "LVIII"
        val solution = Solution13(testData)
        val result = solution.execute()
        assertEquals(58, result)
    }
}