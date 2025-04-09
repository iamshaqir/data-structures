package com.mshaq.datastructures.apnacollege.set_a;

import java.util.Arrays;

public class B_ChocolateDistributionProblem {

    // Sort and use Sliding window and keep track of minimum
    public int findMinDiff(int[] A, int m) {
        Arrays.sort(A);
        int left = 0;
        int difference = Integer.MAX_VALUE;
        for (int right = m - 1; right < A.length; right++) {
            int currDiff = A[right] - A[left++];
            difference = Math.min(difference, currDiff);
        }
        return difference;
    }

    /**
     * Input: arr = [3, 4, 1, 9, 56, 7, 9, 12], m = 5
     * Output: 6
     * <p>
     * Input: arr = [3, 4, 1, 9, 56], m = 5
     * Output: 55
     */
}
