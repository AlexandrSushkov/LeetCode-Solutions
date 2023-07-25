package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.solution.utils.ListNode

class Solution142(private val head: ListNode?) : Solution<ListNode?> {

    override fun execute(): ListNode? {
        var h: ListNode? = head
        val hashSet = hashSetOf<ListNode>()
        while (h != null) {
            if (hashSet.contains(h)) return h
            hashSet.add(h)
            h = h.next
        }
        return null
    }
}
