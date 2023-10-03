package com.example.leetcodeproblems.solution

import org.junit.Assert.assertEquals
import org.junit.Test


class Solution67Test {

    @Test
    fun case1() {
        val a = "11"
        val b = "1"
        val expectedResult = "100"

        val actualResult = Solution67(a, b).execute()

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun case2() {
        val a = "1111"
        val b = "1111"
        val expectedResult = "11110"

        val actualResult = Solution67(a, b).execute()

        assertEquals(expectedResult, actualResult)
    }

}