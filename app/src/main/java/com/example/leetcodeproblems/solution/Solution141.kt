package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.solution.utils.ListNode

class Solution141(private val head: ListNode?) : Solution<Boolean> {

    override fun execute(): Boolean {
        var h: ListNode? = head
        val hashSet = hashSetOf<ListNode>()
        while (h != null) {
            if (hashSet.contains(h)) return true
            hashSet.add(h)
            h = h.next
        }
        return false
    }
}
