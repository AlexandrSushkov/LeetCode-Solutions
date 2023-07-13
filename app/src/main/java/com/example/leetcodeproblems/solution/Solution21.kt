package com.example.leetcodeproblems.solution

class Solution21(private val list1: ListNode?, private val list2: ListNode?) : Solution<ListNode?> {

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
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}