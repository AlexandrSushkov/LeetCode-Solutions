package com.example.leetcodeproblems.solution

import junit.framework.TestCase.assertEquals
import org.junit.Test

class Solution322Test {

    @Test
    fun case1() {
        val solution = Solution322(intArrayOf(186, 419, 83, 408), 6249)
        val result = solution.execute()
        assertEquals(20, result)
    }

    @Test
    fun case2() {
        val solution = Solution322(intArrayOf(1, 2, 5, 25), 1000)
        val result = solution.execute()
        assertEquals(40, result)
    }
}