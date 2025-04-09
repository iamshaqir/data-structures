package com.mshaq.sliding.window;

public class C_MaxConsecutiveOnes {

    // [1,1,1,0,0,0,1,1,1,1,0]
    public int longestOnesBrute(int[] nums, int k) {
        int longestOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            int flip = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) flip++;
                if (flip > k) {
                    break;
                }
                longestOnes = Math.max(longestOnes, j - i + 1);
            }
        }
        return longestOnes;
    }

    public int longestOnesBetter(int[] A, int k) {
        int longestOnes = 0;
        int left = 0, right = 0, flips = 0;

        while (right < A.length) {
            if (A[right] == 0) flips++;

            while (flips > k) {
                if (A[left] == 0) flips--;
                left++;
            }

            longestOnes = Math.max(longestOnes, right - left + 1);
            right++;
        }
        return longestOnes;
    }

    public int longestOnesBest(int[] A, int k) {
        int longestOnes = 0;
        int left = 0, right = 0, flips = 0;

        while (right < A.length) {
            if (A[right] == 0) flips++;

            // Move the left pointer to get the window size
            if (flips > k) {
                if (A[left] == 0) flips--;
                left++;
            }
            if (flips <= k) {
                longestOnes = Math.max(longestOnes, right - left + 1);
            }
            right++;
        }
        return longestOnes;
    }
}
