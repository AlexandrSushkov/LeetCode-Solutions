package com.example.leetcodeproblems.solution

import java.util.PriorityQueue
import kotlin.math.ceil


/**
 * You are given a 0-indexed integer array piles, where piles[i] represents the number of stones in the ith pile, and an integer k. You should apply the following operation exactly k times:
 *
 * Choose any piles[i] and remove floor(piles[i] / 2) stones from it.
 * Notice that you can apply the operation on the same pile more than once.
 *
 * Return the minimum possible total number of stones remaining after applying the k operations.
 *
 * floor(x) is the greatest integer that is smaller than or equal to x (i.e., rounds x down).
 *
 *
 *
 * Example 1:
 *
 * Input: piles = [5,4,9], k = 2
 * Output: 12
 * Explanation: Steps of a possible scenario are:
 * - Apply the operation on pile 2. The resulting piles are [5,4,5].
 * - Apply the operation on pile 0. The resulting piles are [3,4,5].
 * The total number of stones in [3,4,5] is 12.
 *
 * Example 2:
 *
 * Input: piles = [4,3,6,7], k = 3
 * Output: 12
 * Explanation: Steps of a possible scenario are:
 * - Apply the operation on pile 2. The resulting piles are [4,3,3,7].
 * - Apply the operation on pile 3. The resulting piles are [4,3,3,4].
 * - Apply the operation on pile 0. The resulting piles are [2,3,3,4].
 * The total number of stones in [2,3,3,4] is 12.
 */
class Solution1962(private val piles: IntArray, private val k: Int) : Solution<Int> {

    override fun execute(): Int {
        return correctSolution()
    }

    /**
     * throws Time Limit Exceeded
     *
     * Sort integers descending.
     * Pick biggest.
     * Divide.
     * Put into the sorted array in sorted order.
     */
    private fun mySolution(): Int {
        if (piles.isEmpty()) return 0
        var j = k
        val sortedNum = piles.sortedDescending().toMutableList()
        while (j > 0) {
            val newFirst = ceil(sortedNum.first() / 2.0).toInt()
            sortedNum[0] = newFirst
            j--

            // sort.
            for (i in 0 until sortedNum.size) {
                if (i == sortedNum.size - 1 || sortedNum[i] >= sortedNum[i + 1]) {
                    break
                } else {
                    // swap
                    val temp = sortedNum[i]
                    sortedNum[i] = sortedNum[i + 1]
                    sortedNum[i + 1] = temp
                }
            }

        }
        return sortedNum.sum()
    }

    /**
     * Basically the same as mine. But instead of the array heap is used.
     */
    private fun correctSolution(): Int {
        val heap = PriorityQueue { a: Int, b: Int -> b - a }
        for (num in piles) {
            heap.add(num)
        }

        for (i in 0 until k) {
            val curr = heap.remove()
            val remove = curr / 2
            heap.add(curr - remove)
        }

        return heap.sum()
    }
}