package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.utils.toList
import com.example.leetcodeproblems.utils.toListNode
import org.junit.Test
import org.junit.Assert.assertEquals

class Solution21Test {

    @Test
    fun execute() {
        val list1 = listOf(2)
        val list2 = listOf(1)
        val expectedResult = listOf(1, 2)
        val solution = Solution21(list1.toListNode(), list2.toListNode())

        val result = solution.execute()

        assertEquals(expectedResult, result.toList())
    }
}
