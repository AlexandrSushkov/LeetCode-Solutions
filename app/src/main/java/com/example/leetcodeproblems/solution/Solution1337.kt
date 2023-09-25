package com.example.leetcodeproblems.solution

class Solution1337(private val mat: Array<IntArray>, private val k: Int) : Solution<IntArray> {

    // key  - soldiers, value - row id
    // sort by soldiers, if soldiers are the same sort by row id
    private val result = mutableListOf<Pair<Int, Int>>()

    override fun execute(): IntArray {
        mat.forEachIndexed { index, row ->
            val soldiersInRow = row.takeWhile { it > 0 }.count()
            result.add(soldiersInRow to index)
        }

        result.sortBy { it.first }

        return result.map { it.second }
            .take(k)
            .toIntArray()
    }

}
