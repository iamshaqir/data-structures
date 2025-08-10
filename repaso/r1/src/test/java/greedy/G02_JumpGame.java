package greedy;


/**
 * Leetcode: <a href="https://leetcode.com/problems/jump-game/description/">Jump Game</a>
 */
public class G02_JumpGame {

    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < maxJump) return false;
            maxJump = Math.max(maxJump, nums[i] + i);
        }
        return true;
    }
}
/*
    You are given an integer array nums. You are initially positioned at the array's first index, and each element in
    the array represents your maximum jump length at that position.

    Return true if you can reach the last index, or false otherwise.

    Input: nums = [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
