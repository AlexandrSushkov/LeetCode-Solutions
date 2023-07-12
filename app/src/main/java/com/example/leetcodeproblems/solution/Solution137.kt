package com.example.leetcodeproblems.solution

class Solution137(private val input: IntArray) : Solution<Int> {

    override fun execute(): Int {
        val setOfUniqueItems = mutableSetOf<Int>()
        val setOfDuplicates = mutableSetOf<Int>()
        input.forEach {
            if (setOfDuplicates.contains(it)) {
                return@forEach
            } else {
                if (setOfUniqueItems.contains(it)) {
                    setOfDuplicates.add(it)
                    setOfUniqueItems.remove(it)
                } else {
                    // first time
                    setOfUniqueItems.add(it)
                }
            }
        }
        return setOfUniqueItems.first()
    }
}
