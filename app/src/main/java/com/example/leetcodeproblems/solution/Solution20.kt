package com.example.leetcodeproblems.solution

import java.util.Stack

class Solution20(private val s: String) : Solution<Boolean> {
    override fun execute(): Boolean {
        val stack = Stack<Char>()

        if (s.isEmpty()) return true
        s.forEach { c ->
            if (c.isOpenBracket()) {
                stack.push(c)
            } else {
                // close bracket
                if (stack.size == 0) return false
                val top = stack.pop()
                if (!top.isPairFor(c)) return false
            }
        }
        return stack.size == 0
    }

    private fun Char.isPairFor(c: Char): Boolean {
        return when (this) {
            '(' -> c == ')'
            '[' -> c == ']'
            '{' -> c == '}'
            else -> false
        }
    }

    private fun Char.isOpenBracket(): Boolean {
        return this == '(' || this == '[' || this == '{'
    }

    private fun Char.isCloseBracket(): Boolean {
        return this == ')' || this == ']' || this == '}'
    }
}