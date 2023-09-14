package com.example.leetcodeproblems.solution

import java.util.LinkedList

class Solution39(
    private val candidates: IntArray,
    private val target: Int
) : Solution<List<List<Int>>> {

    override fun execute(): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val combination = LinkedList<Int>()
        backtrack(target, combination, 0, candidates, result)
        return result
    }


    private fun backtrack(
        remain: Int,
        combination: LinkedList<Int>,
        start: Int,
        candidates: IntArray,
        result: MutableList<List<Int>>
    ) {
        if (remain == 0) {
            result.add(combination.toList())
            return
        } else if (remain < 0) {
            return
        }

        for (i in start until candidates.size) {
            combination.add(candidates[i])
            backtrack(remain - candidates[i], combination, i, candidates, result)
            combination.removeLast()
        }
    }
}
