package com.example.leetcodeproblems.solution

/**
 * 1185. Day of the Week
 * Given a date, return the corresponding day of the week for that date.
 *
 * The input is given as three integers representing the day, month and year respectively.
 *
 * Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
 *
 * Note: January 1, 1971 was a Friday.
 */
class Solution1185(
    private val day: Int,
    private val month: Int,
    private val year: Int
) : Solution<String> {

    private val daysOfWeek =
        arrayOf(
            "Friday",
            "Saturday",
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday"
        )

    private val daysInMonth = intArrayOf(
        31, 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31
    )


    override fun execute(): String {
        var days = 0

        // Count full years passed since 1971
        for (y in INITIAL_YEAR until year) {
            days += if (isLeap(y)) DAYS_IN_LEAP_YEAR else DAYS_IN_YEAR
        }

        // Count full months passed in current year
        for (m in 1 until month) {
            days += daysInMonth[m - 1]
            if (m == 2 && isLeap(year)) days += 1 // Feb 29
        }

        // Add days
        days += day - 1

        return daysOfWeek[days % 7]
    }

    private fun isLeap(year: Int): Boolean {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
    }

    companion object {
        private const val INITIAL_YEAR = 1971
        private const val DAYS_IN_YEAR = 365
        private const val DAYS_IN_LEAP_YEAR = 366
    }
}