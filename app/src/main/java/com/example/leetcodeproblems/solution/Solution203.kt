package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.data.ListNode


class Solution203(private val head: ListNode?, private val `val`: Int) : Solution<ListNode?> {
    override fun execute(): ListNode? {
        if (head == null) return null
        val dummy = ListNode(-1)
        dummy.next = head
        var prev = dummy
        var curr = head
        while (curr != null) {
            if (curr.`val` == `val`) prev.next = curr.next else prev = curr
            curr = curr.next
        }
        return dummy.next
    }
}
