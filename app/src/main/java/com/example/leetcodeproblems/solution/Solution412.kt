package com.example.leetcodeproblems.solution

class Solution412(private val n: Int) : Solution<List<String>> {

    override fun execute(): List<String> {
        return fizzBuzz(n)
    }

    private fun fizzBuzz(n: Int): List<String> {
        if (n == 0) return emptyList()
        val result = mutableListOf<String>()
        for (i in 1..n) {
            val s = when {
                i % 3 == 0 && i % 5 == 0 -> "FizzBuzz"
                i % 3 == 0 -> "Fizz"
                i % 5 == 0 -> "Buzz"
                else -> i.toString()
            }
            result.add(s)
        }
        return result
    }
}
