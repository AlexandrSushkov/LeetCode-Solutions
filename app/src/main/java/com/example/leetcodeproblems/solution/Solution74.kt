package com.example.leetcodeproblems.solution

class Solution74(private val matrix: Array<IntArray>, private val target: Int) : Solution<Boolean> {


    override fun execute(): Boolean {
        val m = matrix.size
        if (m == 0) return false
        val n = matrix.first().size
        if (n == 0) return false

        var left = 0
        var right = m * n - 1
        while (left <= right) {
            val pivotIdx = (left + right) / 2
            val midElement = matrix[pivotIdx / n][pivotIdx % n]
            if (midElement == target){
                return true
            } else if (midElement < target){
                left = pivotIdx + 1
            } else{
                right = pivotIdx - 1
            }
        }
        return false
    }
}