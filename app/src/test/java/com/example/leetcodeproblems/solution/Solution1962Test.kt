package com.example.leetcodeproblems.solution

import junit.framework.TestCase.assertEquals
import org.junit.Test

class Solution1962Test {

    @Test
    fun case1() {
        val data = intArrayOf(5, 4, 9)
        val result = Solution1962(data, 2).execute()
        assertEquals(12, result)
    }

    @Test
    fun case2() {
        val data = intArrayOf(4,3,6,7)
        val result = Solution1962(data, 3).execute()
        assertEquals(12, result)
    }
}