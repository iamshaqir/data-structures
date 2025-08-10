package org.mshaq.ds;

/**
 * Leetcode: <a href="https://leetcode.com/problems/jump-game-ii/description/?source=submission-ac">Jump game 2</a>
 */
public class M02_JumpGame2 {

    /**
     * Count the minimum jumps to get to last index position,
     * we can do this using sliding window approach
     * <ol>
     *     <li>Maintain a variable to count the farthest index position, along with window left and right</li>
     *     <li>Initially it start with INTEGER.MIN_VALUE</li>
     *     <li>Compare the current index position + current value and update the max jump</li>
     *     <li>Iterate from left to right to check for other farthest jump</li>
     *     <li>if not slide window, left will be right + 1, right will be farthest</li>
     *     <li>Update the jump</li>
     * </ol>
     */
    public static int jump(int[] A) {
        int jumps = 0;
        int left = 0, right = 0;

        while (right < A.length - 1) {
            int farthest = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + A[i]);
            }

            if (farthest >= A.length - 1) {
                jumps++;
                break;
            }
            left = right + 1;
            right = farthest;
            jumps += 1;
        }
        return jumps;
    }
}
/*
    You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.

    Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at
    index i, you can jump to any index (i + j)

    Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index
    n - 1.

    Input: nums = [2,3,1,1,4]
    Output: 2
    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps
    to the last index.
 */