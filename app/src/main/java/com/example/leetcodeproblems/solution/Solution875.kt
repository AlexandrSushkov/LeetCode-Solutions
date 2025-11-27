package com.example.leetcodeproblems.solution

/**
 * [875. Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/)
 *
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 * ### Example 1:
 * ```
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * ```
 *
 * ### Example 2:
 * ```
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * ```
 *
 * ### Example 3:
 * ```
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 * ```
 *
 * ### Constraints:
 * * `1 <= piles.length <= 104`
 * * `piles.length <= h <= 109`
 * * `1 <= piles[i] <= 109`
 */
class Solution875(private val piles: IntArray, private val h: Int): Solution<Int> {

    /**
     * Finds the minimum eating speed `k` for Koko to finish all bananas within `h` hours.
     *
     * This solution uses binary search on the eating speed `k`. The possible range for `k` is
     * from 1 to the maximum pile size.
     *
     * ### Example Walkthrough
     * For `piles = [3,6,7,11]` and `h = 8`:
     *
     * 1.  **Initialize bounds**: `low = 1`, `high = 11` (max pile size).
     *
     * 2.  **Iteration 1**:
     *     - `mid = (1 + 11) / 2 = 6`.
     *     - Check if Koko can finish with speed 6: `ceil(3/6) + ceil(6/6) + ceil(7/6) + ceil(11/6) = 1 + 1 + 2 + 2 = 6` hours.
     *     - `6 <= 8`, so speed 6 is possible. We try for a smaller speed: `high = 6`.
     *
     * 3.  **Iteration 2**:
     *     - `low = 1`, `high = 6` -> `mid = (1 + 6) / 2 = 3`.
     *     - Check for speed 3: `1 + 2 + 3 + 4 = 10` hours.
     *     - `10 > 8`, speed 3 is too slow. We need a higher speed: `low = 3 + 1 = 4`.
     *
     * 4.  **Iteration 3**:
     *     - `low = 4`, `high = 6` -> `mid = (4 + 6) / 2 = 5`.
     *     - Check for speed 5: `1 + 2 + 2 + 3 = 8` hours.
     *     - `8 <= 8`, speed 5 is possible. Try for smaller: `high = 5`.
     *
     * 5.  **Iteration 4**:
     *     - `low = 4`, `high = 5` -> `mid = (4 + 5) / 2 = 4`.
     *     - Check for speed 4: `1 + 2 + 2 + 3 = 8` hours.
     *     - `8 <= 8`, speed 4 is possible. Try for smaller: `high = 4`.
     *
     * Now `low = 4` and `high = 4`, so the loop terminates. The minimum speed is 4.
     *
     * @return The minimum integer `k` (eating speed).
     */
    override fun execute(): Int {
        var low = 1
        var high = piles.maxOrNull() ?: 1  // max pile size

        while (low < high) {
            val mid = low + (high - low) / 2
            if (canFinish(mid)) {
                // mid is fast enough, try to slow down
                high = mid
            } else {
                // mid is too slow, need faster speed
                low = mid + 1
            }
        }

        return low
    }

    private fun canFinish(speed: Int): Boolean {
        var hours = 0L  // use Long to avoid overflow for big inputs

        for (pile in piles) {
            // ceil(pile / speed) = (pile + speed - 1) / speed
            hours += (pile.toLong() + speed - 1) / speed
            if (hours > h) return false  // early exit
        }
        return true
    }
}
