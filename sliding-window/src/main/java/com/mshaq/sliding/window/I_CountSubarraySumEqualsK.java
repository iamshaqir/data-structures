package com.mshaq.sliding.window;

public class I_CountSubarraySumEqualsK {

    // Only positives, For positive and negative use presum with hashmap
    public int countSubarraySumK(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        int windowStart = 0;
        for (int j = 0; j < nums.length; j++) {
            currentSum += nums[j];
            while (windowStart < nums.length && currentSum >= k) {
                if (currentSum == k) {
                    count++;
                }
                currentSum -= nums[windowStart++];
            }
        }
        return count;
    }
}
