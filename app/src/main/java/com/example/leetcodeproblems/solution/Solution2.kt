package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.data.ListNode

/**
 * [Problem 2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * ### Example 1:
 * ```
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * ```
 *
 * ### Example 2:
 * ```
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * ```
 *
 * ### Example 3:
 * ```
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * ```
 *
 * ### Constraints:
 * * The number of nodes in each linked list is in the range `[1, 100]`.
 * * `0 <= Node.val <= 9`
 * * It is guaranteed that the list represents a number that does not have leading zeros.
 */
class Solution2(private val l1: ListNode?, private val l2: ListNode?) : Solution<ListNode?> {

    /**
     * Adds two numbers represented by linked lists.
     *
     * @return A linked list representing the sum of the two input numbers.
     */
    override fun execute(): ListNode? {
        var h1 = l1
        var h2 = l2
        var h1Size = 0
        var h2Size = 0

        var accumulator = 0

        // find longest list
        while (h1 != null) {
            h1Size++
            h1 = h1.next
        }
        while (h2 != null) {
            h2Size++
            h2 = h2.next
        }

        var result: ListNode? = null
        var longerLH: ListNode? = if (h1Size >= h2Size) l1 else l2
        var shorterLH: ListNode? = if (h1Size >= h2Size) l2 else l1


        result = longerLH

        while (longerLH?.next != null) {
            val sum = longerLH?.`val`?.plus(shorterLH?.`val` ?: 0)?.plus(accumulator)
            sum?.let {
                if (sum > 9) {
                    accumulator = 1
                    longerLH?.`val` = sum - 10
                } else {
                    accumulator = 0
                    longerLH?.`val` = sum
                }
            }
            longerLH = longerLH?.next
            shorterLH = shorterLH?.next
        }
        val finalSum = longerLH?.`val`?.plus(shorterLH?.`val` ?: 0)?.plus(accumulator)
        finalSum?.let {
            if (finalSum > 9) {
                accumulator = 1
                longerLH?.`val` = finalSum - 10
            } else {
                accumulator = 0
                longerLH?.`val` = finalSum
            }
        }
        if (accumulator == 1) longerLH?.next = ListNode(1)

        return result
    }
}
