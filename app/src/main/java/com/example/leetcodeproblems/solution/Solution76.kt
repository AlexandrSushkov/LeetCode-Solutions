package com.example.leetcodeproblems.solution

import com.example.leetcodeproblems.utils.Constants

/**
 * [Problem 76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)
 *
 * Given two strings `s` and `t` of lengths `m` and `n` respectively, return the minimum window substring of `s`
 * such that every character in `t` (including duplicates) is included in the window. If there is no such substring,
 * return the empty string `""`.
 *
 * The testcases will be generated such that the answer is unique.
 *
 * ### Example 1:
 * ```
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * ```
 *
 * ### Example 2:
 * ```
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * ```
 *
 * ### Example 3:
 * ```
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * ```
 *
 * ### Constraints:
 * * `m == s.length`
 * * `n == t.length`
 * * `1 <= m, n <= 10^5`
 * * `s` and `t` consist of uppercase and lowercase English letters.
 *
 * @param s The string to search in.
 * @param t The string containing the characters to find.
 */
class Solution76(private val s: String, private val t: String) : Solution<String> {

    /**
     * Finds the minimum window substring of `s` that contains all the characters of `t`.
     *
     * @return The minimum window substring, or an empty string if no such window is found.
     */
    override fun execute(): String {
        if (s.isEmpty() || t.isEmpty()) return Constants.EMPTY_STRING
        if (t.length > s.length) return Constants.EMPTY_STRING

        val need = mutableMapOf<Char, Int>()

        for (char in t) {
            need[char] = (need[char] ?: 0) + 1
        }

        val required = need.size

        // Sliding window state
        val window = mutableMapOf<Char, Int>()
        var formed = 0

        var left = 0
        var right = 0

        var bestLen = Int.MAX_VALUE
        var bestL = 0
        var bestR = 0

        while (right < s.length) {
            val c = s[right]
            window[c] = (window[c] ?: 0) + 1

            // If this char completes a requirement
            if (need.containsKey(c) && window[c] == need[c]) {
                formed++
            }

            // Try to shrink while window is valid
            while (left <= right && formed == required) {
                val windowLen = right - left + 1
                if (windowLen < bestLen) {
                    bestLen = windowLen
                    bestL = left
                    bestR = right
                }

                val d = s[left]
                window[d] = window[d]!! - 1

                if (need.containsKey(d) && window[d]!! < need[d]!!) {
                    formed--
                }
                left++
            }

            right++
        }

        return if (bestLen == Int.MAX_VALUE) "" else s.substring(bestL, bestR + 1)

    }

    // The best solution by speed
    private fun variant1(): String {
        if (s.isEmpty() || t.isEmpty() || s.length < t.length) {
            return ""
        }

        val map = IntArray(128)
        var count = t.length
        var start = 0
        var end = 0
        var minLen = Int.MAX_VALUE
        var startIndex = 0

        for (c in t.toCharArray()) {
            map[c.code]++

        }

        val chS = s.toCharArray()
        while (end < chS.size) {
            if (map[chS[end].code]-- > 0) {
                count--
            }
            end++

            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start
                    minLen = end - start
                }
                if (map[chS[start].code]++ == 0) {
                    count++
                }
                start++
            }
        }

        return if (minLen == Int.MAX_VALUE) "" else s.substring(startIndex, startIndex + minLen)
    }
}
