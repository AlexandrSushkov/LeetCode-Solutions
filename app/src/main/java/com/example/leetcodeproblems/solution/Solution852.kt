package com.example.leetcodeproblems.solution

class Solution852(private val arr: IntArray) : Solution<Int> {
    override fun execute(): Int {
        var l = 0
        var r = arr.size - 1
        while (l < r) {
            val mid = (r + l) / 2
            if (arr[mid] < arr[mid + 1])
                l = mid + 1
            else
                r = mid
        }
        return l
    }

}