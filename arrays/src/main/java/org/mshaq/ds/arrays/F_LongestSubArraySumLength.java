package org.mshaq.ds.arrays;

import java.util.HashMap;
import java.util.Map;

public class F_LongestSubArraySumLength {

    // TC : O(N^2)
    public static int getLengthBr(int[] nums, int k) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            int tempSum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                tempSum += nums[j];

                if (tempSum > k) break;

                if (tempSum == k) {
                    length = Math.max(length, j - i + 1);
                }

            }
        }
        return length;
    }

    // TC : O(N) SC : O(N) // POSITIVE and NEGATIVE
    public static int getLength(int[] nums, int k) {
        long sum = 0;
        int length = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                length = Math.max(length, i + 1);
            }

            long remaining = sum - k;
            if (map.containsKey(remaining)) {
                // get length of current index
                int tempLength = i - map.get(remaining);
                length = Math.max(length, tempLength);
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return length;
    }

    // TC : O(2*N)
    public static int getLengthBe(int[] nums, int k) {
        int length = 0;

        int n = nums.length;
        int sum = nums[0];
        int p1 = 0;
        int p2 = 0;
        while (p2 < n) {

            while (p1 <= p2 && sum > k) {
                sum -= nums[p1];
                p1++;
            }

            if (sum == k) {
                length = Math.max(length, p2 - p1 + 1);
            }
            p2++;
            if (p2 < n) {
                sum += nums[p2];
            }
        }
        return length;
    }
}
