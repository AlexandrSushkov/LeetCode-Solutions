package com.example.leetcodeproblems.solution

/**
 * Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abab"
 * Output: true
 * Explanation: It is the substring "ab" twice.
 * Example 2:
 *
 * Input: s = "aba"
 * Output: false
 * Example 3:
 *
 * Input: s = "abcabcabcabc"
 * Output: true
 * Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 */
class Solution456(val s: String) : Solution<Boolean> {

    override fun execute(): Boolean {
        val n = s.length
        // substring must be at least length 1 and less than n
        for (len in 1..n / 2) {
            if (n % len != 0) continue  // candidate length must divide n

            val pattern = s.substring(0, len)
            val times = n / len

            val built = buildString {
                repeat(times) { append(pattern) }
            }

            if (built == s) return true
        }
        return false

    }
}
