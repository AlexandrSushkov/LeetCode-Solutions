package com.example.leetcodeproblems.solution

/**
 * [Problem 14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string `""`.
 *
 * ### Example 1:
 * ```
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * ```
 *
 * ### Example 2:
 * ```
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * ```
 *
 * ### Constraints:
 * * `1 <= strs.length <= 200`
 * * `0 <= strs[i].length <= 200`
 * * `strs[i]` consists of only lower-case English letters.
 */
class Solution14(private val strs: Array<String>) : Solution<String> {

    /**
     * Finds the longest common prefix string amongst an array of strings.
     *
     * @return The longest common prefix, or an empty string if there is no common prefix.
     */
    override fun execute(): String {
        return longestCommonPrefix(strs)
    }

    private fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        val firstWord = strs.first()

        firstWord.forEachIndexed { index, c ->
            strs.forEach { word ->
                if (word.length - 1 < index || word[index] != c) {
                    return firstWord.substring(0, index)
                }
            }
        }
        return firstWord
    }
}
