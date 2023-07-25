package com.example.leetcodeproblems.solution


class LRUCache(private val capacity: Int) {

    private val map: MutableMap<Int, DListNode> = mutableMapOf()
    private val head = DListNode()
    private val tail = DListNode()

    init {
        head.next = tail
        tail.prev = head
    }

    class DListNode(
        var key: Int? = null,
        var value: Int? = null,
        var prev: DListNode? = null,
        var next: DListNode? = null
    )

    fun get(key: Int): Int {
        if (!map.contains(key)) return -1
        val node = map[key]!!
        deleteNode(node)
        addToHead(node)
        return node.value!!
    }

    fun put(key: Int, value: Int) {
        if (map.contains(key)) {
            val node = map[key]
            node!!.value = value
            deleteNode(node)
            addToHead(node)
        } else {
            val newNode = DListNode().apply {
                this.key = key
                this.value = value
            }
            map[key] = newNode
            addToHead(newNode)
            if (map.size > capacity) {
                map.remove(tail.prev?.key)
                deleteNode(tail.prev!!)
            }
        }
    }

    private fun deleteNode(node: DListNode) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    private fun addToHead(node: DListNode) {
        node.next = head.next
        node.next?.prev = node
        head.next = node
        node.prev = head
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
