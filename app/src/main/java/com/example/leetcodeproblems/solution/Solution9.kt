package com.example.leetcodeproblems.solution

import kotlin.io.path.fileVisitor

/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 *
 */
class Solution9(private val x: Int) : Solution<Boolean> {

    override fun execute(): Boolean {
        return isPalindrome(x)
    }

    private fun isPalindrome(x: Int): Boolean {
        val s = x.toString()
        var start = 0
        var end = s.length - 1
        while (start < end) {
            if (s[start] != s[end]) return false
            start++
            end--
        }
        return true
    }

    private fun isPalindrome2(x: Int): Boolean {
        if (x < 0 || (x % 10 == 0 && x != 0 )) return false

        var temp = x
        var revertNumber = 0
        while (temp > revertNumber){
            revertNumber = revertNumber * 10 + x % 10
            temp /= 10
        }

        return temp == revertNumber || temp == revertNumber / 10
    }

}