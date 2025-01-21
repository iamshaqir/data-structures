package org.mshaq.ds.arrays;

public class TrapRainWater {


    public static int getTrappedRainWater(int[] input) {
        int trappedWater = 0;
        int n = input.length;
        int[] leftMax = new int[input.length];
        int[] rightMax = new int[input.length];

        leftMax[0] = input[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], input[i]);
        }

        rightMax[n - 1] = input[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], input[i]);
        }

        for (int i = 0; i < n; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            int currTrappedWater = min - input[i];
            trappedWater += currTrappedWater;
        }
        return trappedWater;
    }

    public static int getTrappedRainWaterO(int[] nums) {
        int trappedWater = 0;
        int n = nums.length;
        int si = 0;
        int ei = n - 1;
        int leftMax = Integer.MIN_VALUE; // 0
        int rightMax = Integer.MIN_VALUE; // 2
        // 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        while (si < ei) {
            if (nums[si] < nums[ei]) {
                if (nums[si] > leftMax) {
                    leftMax = nums[si];
                } else {
                    trappedWater += leftMax - nums[si];
                }
                si++;
            } else {
                if (nums[ei] > rightMax) {
                    rightMax = nums[ei];
                } else {
                    trappedWater += rightMax - nums[ei];
                }
                ei--;
            }
        }
        return trappedWater;
    }
}
