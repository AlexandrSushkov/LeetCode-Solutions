package com.example.leetcodeproblems.utils

import com.example.leetcodeproblems.data.ListNode

fun List<Int>.toListNode(): ListNode? {
    var head: ListNode? = null
    var tail: ListNode? = null
    this.forEach {
        if (head == null) {
            head = ListNode(it)
            tail = head
        } else {
            tail?.next = ListNode(it)
            tail = tail?.next
        }
    }
    return head
}

fun ListNode?.toList(): List<Int> {
    val result = mutableListOf<Int>()
    var head = this
    while (head != null) {
        result.add(head.`val`)
        head = head.next
    }
    return result
}
