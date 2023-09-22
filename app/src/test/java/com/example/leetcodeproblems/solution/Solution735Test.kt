package com.example.leetcodeproblems.solution

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class Solution735Test {

    @Test
    fun case1() {
        val testData = intArrayOf(5, 10, -5)
        val expectedResult = intArrayOf(5, 10)
        val solution = Solution735(testData)
        val actualResult = solution.execute()
        assertTrue(expectedResult.contentEquals(actualResult))
    }

    @Test
    fun case2() {
        val testData = intArrayOf(8, -8)
        val expectedResult = intArrayOf()
        val solution = Solution735(testData)
        val actualResult = solution.execute()
        assertTrue(expectedResult.contentEquals(actualResult))
    }

    @Test
    fun case3() {
        val testData = intArrayOf(10,2,-5)
        val expectedResult = intArrayOf(10)
        val solution = Solution735(testData)
        val actualResult = solution.execute()
        assertTrue(expectedResult.contentEquals(actualResult))
    }

    @Test
    fun case4() {
        val testData = intArrayOf(-2,-1,1,2)
        val expectedResult = intArrayOf()
        val solution = Solution735(testData)
        val actualResult = solution.execute()
        assertTrue(expectedResult.contentEquals(actualResult))
    }

}