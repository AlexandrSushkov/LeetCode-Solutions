package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.data.ListNode

/**
 * [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * ### Example 1:
 * ```
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * ```
 *
 * ### Example 2:
 * ```
 * Input: list1 = [], list2 = []
 * Output: []
 * ```
 *
 * ### Example 3:
 * ```
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * ```
 *
 * ### Constraints:
 * * The number of nodes in both lists is in the range `[0, 50]`.
 * * `-100 <= Node.val <= 100`
 * * Both `list1` and `list2` are sorted in non-decreasing order.
 */
class Solution21(private val list1: ListNode?, private val list2: ListNode?) : Solution<ListNode?> {

    /**
     * Merges two sorted linked lists into a single sorted linked list.
     *
     * @return The head of the merged linked list.
     */
    override fun execute(): ListNode? {
        if (list1 == null && list2 == null) return null
        if (list1 == null) return list2
        if (list2 == null) return list1

        var head1: ListNode? = list1
        var head2: ListNode? = list2
        var resultHead: ListNode? = null
        var resultTail: ListNode? = null

        while (head1 != null && head2 != null) {
            if (head1.`val` < head2.`val`) {
                // 1 < 2
                if (resultTail == null) {
                    resultTail = ListNode(head1.`val`)
                    if (resultHead == null) resultHead = resultTail
                } else {
                    resultTail.next = ListNode(head1.`val`)
                    resultTail = resultTail.next
                }
                head1 = head1.next
                continue
            } else if (head1.`val` > head2.`val`) {
                // 1 > 2
                if (resultTail == null) {
                    resultTail = ListNode(head2.`val`)
                    if (resultHead == null) resultHead = resultTail
                } else {
                    resultTail.next = ListNode(head2.`val`)
                    resultTail = resultTail.next
                }
                head2 = head2.next
                continue
            } else {
                // equal
                if (resultTail == null) {
                    resultTail = ListNode(head1.`val`)
                    if (resultHead == null) resultHead = resultTail
                } else {
                    resultTail.next = ListNode(head1.`val`)
                    resultTail = resultTail.next
                }
                resultTail?.next = ListNode(head2.`val`)
                resultTail = resultTail?.next
                head1 = head1.next
                head2 = head2.next
            }
        }
        if (head1 != null) resultTail?.next = head1
        if (head2 != null) resultTail?.next = head2

        return resultHead
    }

    private fun v2(): ListNode?{
        var l1 = list1
        var l2 = list2
        val head = ListNode(-1)
        var tail = head

        while (l1 != null && l2 != null) {
            if (l1.`val` < l2.`val`) {
                tail.next = l1
                l1 = l1.next
            } else {
                tail.next = l2
                l2 = l2.next
            }
            tail = tail.next!!
        }

        tail.next = l1 ?: l2
        return head.next

    }
}
