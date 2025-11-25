package com.example.leetcodeproblems.solution

import java.util.Stack

/**
 * [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * * Open brackets must be closed by the same type of brackets.
 * * Open brackets must be closed in the correct order.
 * * Every close bracket has a corresponding open bracket of the same type.
 *
 * ### Example 1:
 * ```
 * Input: s = "()"
 * Output: true
 * ```
 *
 * ### Example 2:
 * ```
 * Input: s = "()[]{}"
 * Output: true
 * ```
 *
 * ### Example 3:
 * ```
 * Input: s = "(]"
 * Output: false
 * ```
 *
 * ### Constraints:
 * * `1 <= s.length <= 104`
 * * `s` consists of parentheses only `()[]{}`.
 */
class Solution20(private val s: String) : Solution<Boolean> {

    /**
     * Determines if the input string has valid parentheses.
     *
     * @return `true` if the string is valid, `false` otherwise.
     */
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