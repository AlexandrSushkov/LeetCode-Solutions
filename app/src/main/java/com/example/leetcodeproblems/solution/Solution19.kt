package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.data.ListNode

/**
 * [Problem 19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * ### Example 1:
 * ```
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * ```
 *
 * ### Example 2:
 * ```
 * Input: head = [1], n = 1
 * Output: []
 * ```
 *
 * ### Example 3:
 * ```
 * Input: head = [1,2], n = 1
 * Output: [1]
 * ```
 *
 * ### Constraints:
 * * The number of nodes in the list is sz.
 * * `1 <= sz <= 30`
 * * `0 <= Node.val <= 100`
 * * `1 <= n <= sz`
 *
 */
class Solution19(private val head: ListNode?, private val n: Int) : Solution<ListNode?> {

    /**
     * Removes the nth node from the end of the linked list.
     *
     * @return The head of the modified linked list.
     */
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
        if(nodeToRemoveIndex == 0) return h1?.next
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
