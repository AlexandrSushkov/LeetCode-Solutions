package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.data.ListNode

class Solution2(private val l1: ListNode?, private val l2: ListNode?) : Solution<ListNode?> {

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
