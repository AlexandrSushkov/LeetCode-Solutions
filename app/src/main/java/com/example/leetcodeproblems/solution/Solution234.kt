package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.solution.utils.ListNode


class Solution234(private val head: ListNode?):Solution<Boolean> {

    private var h = head
    private var frontPointer: ListNode? = null
    private val list = mutableListOf<Int>()
    private var headPointer = 0
    private var tailPointer = 0

    override fun execute(): Boolean {
//        frontPointer = head
//        return recursivelyCheck(head)

        while (h != null) {
            list.add(h!!.`val`)
            h = h!!.next
        }
        tailPointer = list.size
        while (headPointer < tailPointer) {
            if (list[headPointer] != list[tailPointer - 1]) {
                return false
            }
            headPointer++
            tailPointer--
        }
        return true
    }

    // cheated from https://leetcode.com/problems/palindrome-linked-list/solution/
    private fun recursivelyCheck(currentNode: ListNode?): Boolean {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) return false
            if (currentNode.`val` != frontPointer?.`val`) return false
            frontPointer = frontPointer?.next
        }
        return true
    }
}
