package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.solution.utils.TreeNode

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 *
 * Solution: call recursively the function helper(node, level), which takes the current node and its level as the arguments.
 * This function is responsible for adding the current node value to the list of values for its level.
 */
class Solution102(private val root: TreeNode?) : Solution<List<List<Int>>> {
    private val levels = mutableListOf<MutableList<Int>>()

    override fun execute(): List<List<Int>> {
        if (root == null) return levels
        helper(root, 0)
        return levels
    }

    /**
     * add new level if needed.
     * add node value to the list of values for its level if needed.
     */
    private fun helper(node: TreeNode, level: Int) {
        // add new level if we step deeper down to the tree
        if (levels.size == level) {
            levels.add(mutableListOf())
        }
        levels[level].add(node.`val`)
        node.left?.let { helper(it, level + 1) }
        node.right?.let { helper(it, level + 1) }
    }
}