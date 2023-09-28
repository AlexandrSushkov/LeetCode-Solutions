package com.example.leetcodeproblems.solution

class Solution389(private val s: String, private val t: String) : Solution<Char> {
    override fun execute(): Char {
        val sumOfFirst = s.sumOf { it.code }
        val sumOfSecond = t.sumOf { it.code }
        val result = sumOfSecond - sumOfFirst

        return result.toChar()

    }
}