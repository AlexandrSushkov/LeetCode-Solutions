package com.example.leetcodeproblems.solution

class Solution334(private val s: CharArray) : Solution<Unit> {
    override fun execute() {
        var temp: Char = ' '
        val middle = s.size / 2
        var p1 = 0
        var p2 = s.size - 1
        while (p1 < middle) {
            temp = s[p1]
            s[p1] = s[p2]
            s[p2] = temp
            p1++
            p2--
        }
    }
}
