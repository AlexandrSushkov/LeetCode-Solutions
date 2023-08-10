package com.example.leetcodeproblems.solution

class Solution119(private val rowIndex: Int): Solution<List<Int>> {
    override fun execute(): List<Int> {
        if (rowIndex == 0) return listOf(1)
        val row = List(rowIndex + 1) { 1 }.toMutableList()
        for (i in 0 until rowIndex) {
            for (j in i downTo 1) {
                row[j] = row[j] + row[j - 1]
            }
        }
        return row
    }
}
