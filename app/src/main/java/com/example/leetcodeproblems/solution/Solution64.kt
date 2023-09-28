package com.example.leetcodeproblems.solution

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */
class Solution64(private val grid: Array<IntArray>) : Solution<Int> {

    override fun execute(): Int {
        if (grid.isEmpty()) return 0
        if (grid.first().isEmpty()) return 0

        val height = grid.size
        val width = grid.first().size

        val dp = Array(height) { IntArray(width) }
        for (rowIndex in height - 1 downTo 0) {
            for (cellIndex in width - 1 downTo 0) {
                val currentCellNumber = grid[rowIndex][cellIndex]
                dp[rowIndex][cellIndex] = if (rowIndex + 1 == height && cellIndex + 1 == width) {
                    // the lats row and the last cell in the row. just copy
                    currentCellNumber
                } else if (rowIndex + 1 == height && cellIndex + 1 < width) {
                    // the last row but now the las cell in the row.
                    currentCellNumber + dp[rowIndex][cellIndex + 1]
                } else if (rowIndex < height && cellIndex + 1 == width) {
                    // not the last row but last cell in the row.
                    currentCellNumber + dp[rowIndex + 1][cellIndex]
                } else {
                    // not the last row and not the last cell in the row
                    minOf(
                        currentCellNumber + dp[rowIndex][cellIndex + 1],
                        currentCellNumber + dp[rowIndex + 1][cellIndex]
                    )
                }
            }
        }

        return dp.first().first()
    }
}