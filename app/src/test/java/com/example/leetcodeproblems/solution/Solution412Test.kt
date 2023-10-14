package com.example.leetcodeproblems.solution

import org.junit.Assert.assertNotEquals
import org.junit.Test

class Solution412Test {

    @Test
    fun case1() {
        val data = 15
        val result = Solution412(data).execute()
        assertNotEquals(emptyList<String>(), result)
    }
}