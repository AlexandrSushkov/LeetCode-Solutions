package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.data.ListNode

class Solution876(private val head: ListNode?) : Solution<ListNode?> {
    override fun execute(): ListNode? {
        var slow: ListNode? = ListNode(-1).apply { this.next = head }
        var fast: ListNode? = slow
        while (fast != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }
}
