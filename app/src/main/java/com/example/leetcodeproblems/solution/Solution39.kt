package com.example.leetcodeproblems.solution

import java.util.LinkedList

/**
 * [39. Combination Sum](https://leetcode.com/problems/combination-sum/)
 *
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 * ### Example 1:
 * ```
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * ```
 *
 * ### Example 2:
 * ```
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * ```
 *
 * ### Example 3:
 * ```
 * Input: candidates = [2], target = 1
 * Output: []
 * ```
 *
 * ### Constraints:
 * * `1 <= candidates.length <= 30`
 * * `2 <= candidates[i] <= 40`
 * * All elements of candidates are distinct.
 * * `1 <= target <= 40`
 */
class Solution39(
    private val candidates: IntArray,
    private val target: Int
) : Solution<List<List<Int>>> {

    /**
     * Finds all unique combinations of candidates that sum up to the target.
     *
     * @return A list of all unique combinations.
     */
    override fun execute(): List<List<Int>> {
        return version1()
    }

    private fun version1(): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val combination = LinkedList<Int>()
        backtrack(target, combination, 0, candidates, result)
        return result
    }

    private fun backtrack(
        remain: Int,
        combination: LinkedList<Int>,
        start: Int,
        candidates: IntArray,
        result: MutableList<List<Int>>
    ) {
        if (remain == 0) {
            result.add(combination.toList())
            return
        } else if (remain < 0) {
            return
        }

        for (i in start until candidates.size) {
            combination.add(candidates[i])
            backtrack(remain - candidates[i], combination, i, candidates, result)
            combination.removeLast()
        }
    }

    private fun version2(): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val sortedCandidates = candidates.sorted()

        fun dfs(index: Int, current: MutableList<Int>, remaining: Int) {
            // found exact sum
            if (remaining == 0) {
                result.add(current.toList())
                return
            }
            // no more candidates or overshoot
            if (index == sortedCandidates.size || remaining < 0) return

            // 1. choose current candidate (unlimited times)
            current.add(sortedCandidates[index])
            dfs(index, current, remaining - sortedCandidates[index])
            current.removeAt(current.size - 1) // backtrack

            // 2. skip candidate
            dfs(index + 1, current, remaining)
        }

        dfs(0, mutableListOf(), target)
        return result
    }
}
