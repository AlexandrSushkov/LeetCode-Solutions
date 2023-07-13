package com.example.leetcodeproblems.solution

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

    private fun List<Int>.toListNode(): ListNode? {
        var head: ListNode? = null
        var tail: ListNode? = null
        this.forEach {
            if (head == null) {
                head = ListNode(it)
                tail = head
            } else {
                tail?.next = ListNode(it)
                tail = tail?.next
            }
        }
        return head
    }
}

private fun ListNode?.toList(): Any {
    val result = mutableListOf<Int>()
    var head = this
    while (head != null) {
        result.add(head.`val`)
        head = head.next
    }
    return result
}
