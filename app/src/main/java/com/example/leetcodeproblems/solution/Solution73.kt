package com.example.leetcodeproblems.solution

class Solution73(private val matrix: Array<IntArray>) : Solution<Unit> {

    private val rowsToReplace = mutableSetOf<Int>()
    private val columnsToReplace = mutableSetOf<Int>()

    override fun execute() {
        matrix.forEachIndexed { rowIndex, _ -> validateRow(matrix, rowIndex) }

        matrix.forEachIndexed { rowIndex, _ ->
            if (rowsToReplace.contains(rowIndex)){
                replaceRowWithZero(matrix, rowIndex)
                return@forEachIndexed
            }
            columnsToReplace.forEach { columnIndex ->
                matrix[rowIndex][columnIndex] = 0
            }
        }
    }

    private fun validateRow(matrix: Array<IntArray>, rowIndex: Int) {
        matrix[rowIndex].forEachIndexed { columnIndex, value ->
            if (value == 0) {
                columnsToReplace.add(columnIndex)
                rowsToReplace.add(rowIndex)
            }
        }
    }

    private fun replaceRowWithZero(matrix: Array<IntArray>, rowIndex: Int) {
        matrix[rowIndex].forEachIndexed { columnIndex, _ -> matrix[rowIndex][columnIndex] = 0 }
    }
}
