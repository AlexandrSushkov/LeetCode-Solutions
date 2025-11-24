package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.data.ListNode

class Solution160(private val headA:ListNode?, private val headB:ListNode?) : Solution<ListNode?> {

    var hA = headA
    var hB = headB
    var tailA: ListNode? = null
    var listASize = 0
    var tailB: ListNode? = null
    var listBSize = 0

    override fun execute(): ListNode? {
        while (hA != null) {
            tailA = hA
            hA = hA!!.next
            listASize++
        }
        while (hB != null) {
            tailB = hB
            hB = hB!!.next
            listBSize++
        }
        if (listASize == 0 && listBSize == 0) return null
        hA = headA
        hB = headB
        if (listASize < listBSize){
            // skip b to size of a
            var skipsB = listBSize - listASize
            while (skipsB > 0) {
                hB = hB!!.next
                skipsB--
            }
        }else if (listASize > listBSize){
            // skip a to size of b
            var skipsA = listASize - listBSize
            while (skipsA > 0) {
                hA = hA!!.next
                skipsA--
            }
        }
        // lists has same size
        // iterate both lists and compare nodes
        while (hA != null && hB != null) {
            if (hA == hB) return hA
            if (hA!!.next == hB!!.next) return hA!!.next
            hA = hA!!.next
            hB = hB!!.next
        }
        return null
    }
}
