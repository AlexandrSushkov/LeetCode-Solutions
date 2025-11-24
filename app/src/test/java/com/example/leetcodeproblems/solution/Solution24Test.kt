package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.utils.toListNode
import org.junit.Assert.assertEquals
import org.junit.Test

class Solution24Test{

    @Test
    fun execute() {
        val solution = Solution24(listOf(1,2,3,4).toListNode())
        val result = solution.execute()
        assertEquals(listOf(2,1,4,3).toListNode(), result)
    }
}
