package com.example.leetcodeproblems.solution

class Solution2224(private val current: String, private val correct: String) : Solution<Int> {

    override fun execute(): Int {
        val currentHour = current.substring(0, 2).toInt()
        val currentMin = current.substring(3, 5).toInt()

        val correctHour = correct.substring(0, 2).toInt()
        val correctMin = correct.substring(3, 5).toInt()

        var currentTimeInMinutes = currentHour * 60 + currentMin
        val correctTimeInMinutes = correctHour * 60 + correctMin

        var operationsCount = 0

        while (currentTimeInMinutes < correctTimeInMinutes) {
            when {
                correctTimeInMinutes - currentTimeInMinutes >= 60 -> {
                    currentTimeInMinutes += 60
                    operationsCount++
                }

                correctTimeInMinutes - currentTimeInMinutes >= 15 -> {
                    currentTimeInMinutes += 15
                    operationsCount++
                }

                correctTimeInMinutes - currentTimeInMinutes >= 5 -> {
                    currentTimeInMinutes += 5
                    operationsCount++
                }

                correctTimeInMinutes - currentTimeInMinutes >= 1 -> {
                    currentTimeInMinutes += 1
                    operationsCount++
                }
            }
        }

        return operationsCount
    }
}
