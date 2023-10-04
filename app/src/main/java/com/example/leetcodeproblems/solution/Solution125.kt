package com.example.leetcodeproblems.solution

class Solution125(private val s: String) : Solution<Boolean> {

    override fun execute(): Boolean {
        return isPalindrome(s)
    }

    private fun isPalindrome(s: String): Boolean {
        val pattern = "[^A-Za-z0-9]".toRegex()
        val chrString = s.replace(pattern, "").lowercase()
        if (chrString.isEmpty() || chrString.length == 1) return true
        val lastIndex = chrString.length - 1
        for (i in 0..lastIndex / 2) {
            if (chrString[i] != chrString[lastIndex - i]) {
                return false
            }
        }
        return true
    }
}