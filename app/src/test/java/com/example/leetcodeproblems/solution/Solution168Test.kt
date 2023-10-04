package com.example.leetcodeproblems.solution

import org.junit.Assert.assertEquals
import org.junit.Test

class Solution168Test{

    @Test
    fun case1(){
        val testData = 701
        val expectedResult = "ZY"

        val actualResult = Solution168(testData).execute()

        assertEquals(actualResult, expectedResult)
    }
}