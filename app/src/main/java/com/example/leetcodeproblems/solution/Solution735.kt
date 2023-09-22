package com.example.leetcodeproblems.solution

import java.util.Stack
import kotlin.math.absoluteValue

class Solution735(private val asteroids: IntArray) : Solution<IntArray> {

    private val result = Stack<Int>()

    override fun execute(): IntArray {
        asteroids.forEach {
            if (result.isEmpty()) {
                result.push(it)

            } else {
                var shouldContinue = true
                while (shouldContinue) {
                    val lastOne = result.peek()
                    val willCollide = lastOne > 0 && it < 0
                    if (willCollide) {
                        if (it == -lastOne) {
                            result.pop()
                            shouldContinue = false
                        } else if (it.absoluteValue > lastOne.absoluteValue) {
                            result.pop()
                            if (result.isNotEmpty()) {
                                shouldContinue = true
                            } else {
                                shouldContinue = false
                                result.add(it)
                            }
                        } else {
                            shouldContinue = false
                        }
                    } else {
                        result.add(it)
                        shouldContinue = false
                    }
                }
            }
        }
        return result.toIntArray()
    }
}