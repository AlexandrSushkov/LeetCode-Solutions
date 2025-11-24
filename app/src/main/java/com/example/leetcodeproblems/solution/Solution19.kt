package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.data.ListNode

class Solution19(private val head: ListNode?, private val n: Int) : Solution<ListNode?> {

    override fun execute(): ListNode? {
        return v1(head, n)
    }

    private fun v1(head: ListNode?, n: Int): ListNode? {
        var h1 = head
        var listSize = 0
        while (h1 != null) {
            h1 = h1.next
            listSize++
        }
        h1 = head
        val nodeToRemoveIndex = listSize - n
        if(nodeToRemoveIndex == 1) return h1?.next
        var count = 1
        while (count < nodeToRemoveIndex) {
            h1 = h1?.next
            count++
        }
        h1?.next = h1?.next?.next
        return head
    }

//    private fun v2(): ListNode? {
//        var slowH = head
//        var fastH = head
//        val nodeToRemoveIndex = -1
//        val fastStep = n
//    }


}
