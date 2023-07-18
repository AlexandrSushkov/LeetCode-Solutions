package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.solution.utils.ListNode

class Solution24(private val head: ListNode?) : Solution<ListNode?> {

    override fun execute(): ListNode? {
        return swapPairs(head)
    }

    private fun swapPairs(head: ListNode?): ListNode? {
        if (head == null) return null
        if (head.next == null) return head
        var h1 = head
        var h2 = head.next
        h1.next = swapPairs(h2?.next)
        h2?.next = h1
        return h2
    }
}
