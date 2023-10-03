package com.example.leetcodeproblems.solution

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 *
 * A word is a maximal
 * substring
 *  consisting of non-space characters only.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 *
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * Example 3:
 *
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 */
class Solution58(private val s: String) : Solution<Int> {

    override fun execute(): Int {
        return lengthOfLastWord(s)
    }

    private fun lengthOfLastWord(s: String): Int {
        // start from the end of the string
        // start count when 1st non space character appears
        // end count when 1st space appears after the word
        var lastWordLength = 0
        for (i in (s.length - 1) downTo 0) {
            if (s[i].isWhitespace() && lastWordLength == 0) {
                // space in the end of the string
                continue
            }
            if (!s[i].isWhitespace()) {
                // char
                lastWordLength++
                continue
            }
            if (s[i].isWhitespace()) {
                // first space after the word
                return lastWordLength
            }
        }
        return lastWordLength
    }

    private fun lengthOfLastWord2(s: String): Int {
        val sTrimmed = s.trim()
        return (sTrimmed.length - 1) - sTrimmed.lastIndexOf(' ')
    }
}
