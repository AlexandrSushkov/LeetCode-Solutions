package com.example.leetcodeproblems.solution

class Solution242(private val s: String, private val t: String) : Solution<Boolean> {

    override fun execute(): Boolean {
        return isAnagram(s, t)
    }

    private fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val tList = t.toList().toMutableList()
        s.forEach {
            if (!tList.remove(it)) {
                return false
            }
        }
        return true
    }
}