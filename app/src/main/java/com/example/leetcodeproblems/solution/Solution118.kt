package com.example.leetcodeproblems.solution

class Solution118(private val numRows: Int) : Solution<List<List<Int>>> {
    override fun execute(): List<List<Int>> {
        if (numRows == 0) return emptyList()
        if (numRows == 1) return listOf(listOf(1))
        val result = mutableListOf<List<Int>>()
        for (i in 1..numRows) {
            val row = if (i == 1){
                listOf(1)
            } else{
                createRow(result[i - 2])
            }
            result.add(row)
        }
        return result
    }

    private fun createRow(previousRow: List<Int>): List<Int> {
        val rowSize = previousRow.size + 1
        return List(rowSize) { index ->
            val isIndexMiddle = index > 0 && index < rowSize - 1
            if (isIndexMiddle) {
                previousRow[index - 1] + previousRow[index]
            } else {
                1
            }
        }
    }
}
