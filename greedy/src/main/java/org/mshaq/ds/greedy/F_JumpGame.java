package org.mshaq.ds.greedy;

//https://leetcode.com/problems/jump-game/description/
public class F_JumpGame {

    /**
     * [2,3,1,1,4]
     * [3,2,1,0,4]
     * [1,1,2,2,0,1,1]
     * [2,5,0,0]
     * [1,0,2]
     * [0,2,3]
     * [0]
     */
    public boolean canJump(int[] nums) {

        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxJump) return false;
            // i + nums[i] -> indicates to which index position I can jump
            // from current position + number of positions
            maxJump = Math.max(maxJump, i + nums[i]);
        }
        return true;
    }

    public boolean canJumpO(int[] nums) {

        int goal = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }
}
