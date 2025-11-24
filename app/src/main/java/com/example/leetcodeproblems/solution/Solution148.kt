package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.data.ListNode


class Solution148(private val head: ListNode?) : Solution<ListNode?> {
    override fun execute(): ListNode? {
        return sortList(head)
    }

    private fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val mid: ListNode? = findMiddle(head)
        val left = sortList(head)
        val right = sortList(mid)
        return mergeLists(left, right)
    }

    private fun mergeLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var l1 = list1
        var l2 = list2
        val dummyHead = ListNode(-1)
        var tail: ListNode? = dummyHead
        while (l1 != null && l2 != null) {
            if (l1.`val` < l2.`val`) {
                tail!!.next = l1
                l1 = l1.next
                tail = tail.next
            } else {
                tail!!.next = l2
                l2 = l2.next
                tail = tail.next
            }
        }
        tail!!.next = l1 ?: l2
        return dummyHead.next
    }

    private fun findMiddle(head: ListNode?): ListNode? {
        var h = head
        var midPrev: ListNode? = null
        while (h?.next != null) {
            midPrev = if (midPrev == null) h else midPrev.next
            h = h.next!!.next
        }
        val mid = midPrev!!.next
        midPrev.next = null
        return mid
    }

}
