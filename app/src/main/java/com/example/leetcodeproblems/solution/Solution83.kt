package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.data.ListNode

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 */
class Solution83(private val head: ListNode?): Solution<ListNode?> {

    override fun execute(): ListNode? {
        return deleteDuplicates(head)
    }

    private fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) return null
        var h = head
        while (h!!.next != null){
            if (h.next!!.`val` == h.`val`){
                h.next = h.next!!.next
            }else{
                h = h.next
            }
        }
        return head
    }
}
