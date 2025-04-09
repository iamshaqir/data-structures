package org.mshaq.ds.greedy;


/**
 * Leetcode URL: <a href="https://leetcode.com/problems/jump-game-ii/description/">Jump game 2</a>
 */
public class FA_JumpGame2 {

    /**
     * Count the minimum jumps to get to last index position,
     * we can do this using sliding window approach
     * <ol>
     *     <li>Maintain a variable to count the farthest index position, with window left and right</li>
     *     <li>Initially it start with INTEGER.MIN_VALUE</li>
     *     <li>Compare the current index position + current value, update the max jump</li>
     *     <li>Iterate from left to right to check for other farthest jump</li>
     *     <li>if not slide window, left will be right + 1, right will be farthest</li>
     *     <li>Update the jump</li>
     * </ol>
     */
    public int jump(int[] nums) {
        int jumps = 0;
        int left = 0, right = 0;

        while (right < nums.length) {
            int farthest = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            left = right + 1;
            right = farthest;
            jumps += 1;
        }
        return jumps;
    }

    public int jumpO(int[] nums) {
        int jumps = 0;
        int end = 0;
        int farthest = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                end = farthest;
                jumps++;
            }
        }
        return jumps;
    }
}
