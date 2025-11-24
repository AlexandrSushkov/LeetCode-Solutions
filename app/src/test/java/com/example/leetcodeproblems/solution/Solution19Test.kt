package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.utils.toListNode
import org.junit.Assert.assertEquals
import org.junit.Test

class Solution19Test {

    @Test
    fun execute() {
        val solution = Solution19(listOf(1,2,).toListNode(), 1)
        val result = solution.execute()
        assertEquals(listOf(1).toListNode(), result)
    }
}
