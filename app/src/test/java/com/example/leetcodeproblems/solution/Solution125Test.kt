package com.example.leetcodeproblems.solution

import junit.framework.TestCase.assertTrue
import org.junit.Test

class Solution125Test{

    @Test
    fun case1(){
        val testData = "A man, a plan, a canal: Panama"
        val result = Solution125(testData).execute()
        assertTrue(result)
    }
}