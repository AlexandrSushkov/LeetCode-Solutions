package com.example.leetcodeproblems.solution

/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
class Solution67(private val a: String, private val b: String) : Solution<String> {
    override fun execute(): String {
        return addBinary(a, b)
    }

    /**
     * @param a must be longer than b
     */
    private fun addBinary(a: String, b: String): String {
        val n = a.length
        val m = b.length
        if (n < m) return addBinary(b, a)

        val sb = StringBuilder()
        var carry = 0
        var j = m - 1
        for (i in n - 1 downTo 0) {
            if (a[i] == ONE) ++carry
            if (j > -1 && b[j--] == ONE) ++carry

            if (carry % 2 == 1) sb.append(ONE) else sb.append(ZERO)

            carry /= 2
        }

        if (carry == 1) sb.append(ONE);
        return sb.toString().reversed()
    }

    companion object {
        private const val ONE = '1'
        private const val ZERO = '0'
    }
}
