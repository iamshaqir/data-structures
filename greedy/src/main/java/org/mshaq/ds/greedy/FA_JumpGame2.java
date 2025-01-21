package org.mshaq.ds.greedy;

public class FA_JumpGame2 {

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
