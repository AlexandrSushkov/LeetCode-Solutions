package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.solution.utils.Node

class Solution138(private val node: Node?) : Solution<Node?> {
    private val originalListHashSet = mutableSetOf<Node>()
    private val copyListHashSet = mutableSetOf<Node>()

    override fun execute(): Node? {
        var originalListHead: Node? = node
        if (originalListHead == null) return null
        var copyListHead: Node? = copyNodes(originalListHead)
        var copyListTempHead: Node? = copyListHead
        while (originalListHead != null) {
            val indexOfRandom = originalListHashSet.indexOf(originalListHead.random)
            copyListTempHead?.random = if (indexOfRandom != -1) copyListHashSet.elementAt(indexOfRandom) else null
            originalListHead = originalListHead.next
            copyListTempHead = copyListTempHead?.next
        }
        return copyListHead
    }

    private fun copyNodes(node: Node): Node {
        return Node(node.`val`).apply {
            next = node.next?.let { copyNodes(it) }
        }.also {
            originalListHashSet.add(node)
            copyListHashSet.add(it)
        }
    }
}
