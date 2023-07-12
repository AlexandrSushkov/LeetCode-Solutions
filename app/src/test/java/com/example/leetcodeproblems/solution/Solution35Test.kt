package com.example.leetcodeproblems.solution

import org.junit.Test
import org.junit.Assert.assertEquals

class Solution35Test {

    private val solution = Solution35(intArrayOf(), 1)

    @Test
    fun test1() {
        val result = solution.execute()
        assertEquals(0, result)
    }
}
