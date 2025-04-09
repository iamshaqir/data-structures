package com.mshaq.datastructures.tuf.set_a;

import java.util.HashMap;
import java.util.Map;

public class J_LongestSubArrayWithSumK {

    // Input: A[] = [1, 2, 3, 4, 1, 2, 3, 1, 4], k = 7
    // Output: 4
    // Positives
    public int longestSubarrayBr(int[] A, int k) {
        int longCount = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];

                if (sum > k) break;

                if (sum == k) {
                    int cnt = j - i + 1;
                    longCount = Math.max(longCount, cnt);
                    break;
                }
            }
        }
        return longCount;
    }

    public int longestSubarray(int[] A, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];

            if (sum == k) {
                count = Math.max(count, i + 1);
                continue;
            }
            int diff = sum - k;
            if (map.containsKey(diff)) {
                int length = i - map.get(diff);
                count = Math.max(count, length);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return count;
    }

    // Input: A[] = [1, 2, 3, 4, 1, 2, 3, 1, 4], k = 7
    // Output: 4
    // Positives
    public int longestSubArrayO(int[] A, int k) {
        int windowStart = 0;
        int longestCount = 0;
        int currentSum = 0;

        for (int i = 0; i < A.length; i++) {
            currentSum += A[i];
            while (windowStart <= i && currentSum >= k) {
                if (currentSum == k) {
                    longestCount = Math.max(longestCount, i - windowStart + 1);
                }
                currentSum -= A[windowStart++];
            }
        }

        return longestCount;
    }
}
