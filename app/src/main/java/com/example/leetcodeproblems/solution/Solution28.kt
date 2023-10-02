package com.example.leetcodeproblems.solution

/**
 * iven two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 *
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 */
class Solution28(private val haystack: String, private val needle: String) : Solution<Int> {

    override fun execute(): Int {
        return strStr(haystack, needle)
    }

    /**
     * sliding window approach
     */
    private fun strStr(haystack: String, needle: String): Int {
        if (needle.length > haystack.length || haystack.isEmpty() || needle.isEmpty()) return -1
        haystack.forEachIndexed { index, c ->
            if (c == needle.first()) {
                for (k in 0..needle.length) {
                    if (needle[k] != haystack.getOrNull(index + k)) {
                        break
                    }
                    if (k == needle.length - 1) {
                        return index
                    }
                }
            }
        }

        return -1
    }
}
