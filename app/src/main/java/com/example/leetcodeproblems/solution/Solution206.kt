package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.solution.utils.ListNode

class Solution206(private val head: ListNode?) : Solution<ListNode?> {

    override fun execute(): ListNode? {
        if (head == null) return null
        if (head.next == null) return head
        val h1= head
        val hn= head.next
        head.next = null
        return swapAndReturnNewHead(h1, hn!!)
    }

    fun swapAndReturnNewHead(currentNode: ListNode, nextNode: ListNode): ListNode {
        return if (nextNode.next != null) {
            val newNext = nextNode.next
            nextNode.next = currentNode
            swapAndReturnNewHead(nextNode, newNext!!)
        } else  {
            // the last two nodes. reverse
            nextNode.next = currentNode
            nextNode
        }

    }
}