package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.data.ListNode

/**
 * [24. Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 * ### Example 1:
 * ```
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * ```
 *
 * ### Example 2:
 * ```
 * Input: head = []
 * Output: []
 * ```
 *
 * ### Example 3:
 * ```
 * Input: head = [1]
 * Output: [1]
 * ```
 *
 * ### Constraints:
 * * The number of nodes in the list is in the range `[0, 100]`.
 * * `0 <= Node.val <= 100`
 */
class Solution24(private val head: ListNode?) : Solution<ListNode?> {

    /**
     * Swaps every two adjacent nodes in a linked list.
     *
     * @return The head of the modified linked list.
     */
    override fun execute(): ListNode? {
        return swapPairs(head)
    }

    private fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val h2 = head.next
        head.next = swapPairs(h2?.next)
        h2?.next = head
        return h2
    }
}
