package com.mshaq.sliding.window;

public class A_MaxScore {

    public int maxScore(int[] C, int k) {

        int n = C.length;
        int leftSum = 0, rightSum = 0, maxSum = 0;

        for (int i = 0; i < k; i++) {
            leftSum += C[i];
        }
        maxSum = leftSum;

        int rightIndex = n - 1;
        for (int j = k - 1; j >= 0; j--) {
            leftSum -= C[j];

            rightSum += C[rightIndex--];
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        return maxSum;

    }
}
