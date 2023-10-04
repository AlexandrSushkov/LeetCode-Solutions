package com.example.leetcodeproblems.solution

import java.lang.StringBuilder

/**
 * Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 *
 * For example:
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 *
 * Example 1:
 *
 * Input: columnNumber = 1
 * Output: "A"
 * Example 2:
 *
 * Input: columnNumber = 28
 * Output: "AB"
 * Example 3:
 *
 * Input: columnNumber = 701
 * Output: "ZY"
 */
class Solution168(private val columnNumber: Int) : Solution<String> {

    override fun execute(): String {
        return convertToTitle(columnNumber)
    }

    private fun convertToTitle(columnNumber: Int): String {
        val letters = 26
        return if (columnNumber > letters) {
            convertToTitle((columnNumber - 1) / letters) + (columnNumber % letters).toMyChar()
        } else {
            columnNumber.toMyChar()
        }
    }

    private fun Int.toMyChar(): String = if (this > 0) ('@' + this).toString() else "Z"

}
