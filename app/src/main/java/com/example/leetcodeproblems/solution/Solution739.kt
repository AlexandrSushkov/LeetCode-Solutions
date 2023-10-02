package com.example.leetcodeproblems.solution

import java.util.Stack

/**
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
 * is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 */
class Solution739(private val temperatures: IntArray) : Solution<IntArray> {

    override fun execute(): IntArray {
        return dailyTemperatures(temperatures)
    }

    private fun dailyTemperatures(temperatures: IntArray): IntArray {
        val answer = IntArray(temperatures.size)
        val stack = Stack<Int>()

        temperatures.forEachIndexed { currentDay, i ->
            val currentTemp = temperatures[currentDay]

            while (stack.isNotEmpty() && temperatures[stack.peek()] < currentTemp) {
                val prevDay = stack.pop()
                answer[prevDay] = currentDay - prevDay
            }
            stack.push(currentDay)
        }

        return answer
    }
}
