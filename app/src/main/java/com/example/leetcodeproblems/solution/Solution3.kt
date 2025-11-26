package com.example.leetcodeproblems.solution

/**
 * [Problem 3: Longest Substring Without Repeating Characters.](https://arc.net/l/quote/mowncoku)
 *
 * Given a string `s`, find the length of the longest substring without duplicate characters.
 *
 *
 * ## Example 1:
 * ```
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * ```
 *
 * ## Example 2:
 * ```
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * ```
 *
 * ## Example 3:
 * ```
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * ```
 *
 * ## Constraints:
 * * `0 <= s.length <= 5 * 10^4`
 * * `s` consists of English letters, digits, symbols and spaces.
 *
 * @param s The input string.
 */
class Solution3(private val s: String) : Solution<Int> {

    /**
     * Calculates the length of the longest substring without repeating characters.
     *
     * We maintain a window [left, right] over the string such that:
     * Invariant: All characters inside the window are unique.
     * We move right step by step, and use a Set or Map to track characters currently in the window.
     *
     * Let’s track:

     *
     * ## Step by step:
     * ### Pre-Condition
     * ```
     * - s = "abcabcbb"
     * - left = 0
     * - seen = {} (characters in the current window)
     * - maxLen = 0
     * ```
     *
     * ### Step 1
     * ```
     *  - right = 0, char = 'a'
     *  - 'a' not in seen → add it
     *  - seen = {a}
     *  - window = "a" → length = 1 → maxLen = 1
     * ```
     * ### Step 2
     * ```
     * 	right = 1, char = 'b'
     * 	not in seen → add
     * 	seen = {a, b}
     * 	window = "ab" → length = 2 → maxLen = 2
     * 	```
     *
     * ### Step 3
     * ```
     * 	right = 2, char = 'c'
     * 	not in seen → add
     * 	seen = {a, b, c}
     * 	window = "abc" → length = 3 → maxLen = 3
     * 	```
     *
     * ### Step 4
     * ```
     * 	right = 3, char = 'a'
     * 	'a' already in seen → window invalid
     * 	We move left until we remove the old 'a':
     * 	left = 0 → remove 'a' from seen → seen = {b, c}
     * 	left = 1 now
     * 	Now we can add the new 'a' at right = 3:
     * 	seen = {b, c, a}
     * 	window = "bca" → indexes [1..3], length = 3 → maxLen = 3 (unchanged)
     * 	```
     *
     * You see the window effectively “slides” forward.
     *
     * Keep going like this → you’ll see the max length stays 3.
     *
     * @return The length of the longest substring without repeating characters.
     */
    override fun execute(): Int {
        val seen = HashSet<Char>()
        var left = 0
        var maxLen = 0

        for (right in s.indices) {
            val c = s[right]

            while (seen.contains(c)) {  // window invalid condition
                seen.remove(s[left])
                left++
            }

            // Now window has no duplicate for c
            seen.add(c)

            // Update max length
            maxLen = maxOf(maxLen, right - left + 1)
        }

        return maxLen
    }
}
