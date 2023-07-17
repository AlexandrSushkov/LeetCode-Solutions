package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.solution.utils.toListNode
import junit.framework.TestCase.assertTrue
import org.junit.Test

class Solution234Test {

    @Test
    fun execute1() {
        val solution = Solution234(listOf(1,2,2,1).toListNode())
        val result = solution.execute()
        assertTrue(result)
    }
}