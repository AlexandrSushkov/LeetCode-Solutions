package com.example.leetcodeproblems.solution

class Solution136(private val nums: IntArray): Solution<Int> {
    override fun execute(): Int {
        val set = hashSetOf<Int>()
        nums.forEach { num ->
            if (set.contains(num)) {
                set.remove(num)
            } else {
                set.add(num)
            }
        }
        return set.first()
    }
}