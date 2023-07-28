package com.example.leetcodeproblems.solution

class Solution287(private val nums: IntArray):Solution<Int> {
    override fun execute(): Int {
        var slow = 0
        var fast = 0

        while(true) {
            slow = nums[slow]
            fast = nums[nums[fast]]
            if (fast == slow) break
        }

        var slow2 = 0
        while(slow != slow2) {
            slow = nums[slow]
            slow2 = nums[slow2]
        }

        return slow
    }
}