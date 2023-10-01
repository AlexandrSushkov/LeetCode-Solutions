package com.example.leetcodeproblems.solution

class Solution13(private val s: String) : Solution<Int> {

    override fun execute(): Int {
        return romanToInt(s)
    }

    private fun romanToInt(s: String): Int {
        var result = 0
        val newS = s.reversed()
        newS.mapIndexed { index, c ->
            if (index < newS.length) {
                val d = romanToInt(c)
                val isPreviousRomanBigger = if (index == 0) {
                    false
                } else {
                    isPreviousRomanBigger(c, newS[index - 1])
                }
                if (isPreviousRomanBigger) {
                    result -= d
                } else {
                    result += d
                }
            }
        }
        return result
    }

    private fun isPreviousRomanBigger(current: Char, previous: Char): Boolean {
        return when (current) {
            'I' -> previous == 'V' || previous == 'X'
            'X' -> previous == 'L' || previous == 'C'
            'C' -> previous == 'D' || previous == 'M'
            else -> false
        }
    }

    private fun romanToInt(char: Char): Int {
        return when (char) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }
    }

}
