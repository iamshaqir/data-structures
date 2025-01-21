package org.mshaq.ds.oneD_grids;

import java.util.Arrays;

public class FrogJumpK {

    private static class Memoization {

        public int minimizeCost(int k, int[] arr) {
            int n = arr.length;
            int[] dp = new int[n];
            Arrays.fill(dp, -1);
            return helper(n - 1, arr, k, dp);
        }

        private int helper(int n, int[] arr, int k, int[] dp) {
            if (n == 0) {
                return 0;
            }

            if (dp[n] != -1) {
                return dp[n];
            }

            int minSteps = Integer.MAX_VALUE;
            for (int i = 1; i <= k; i++) {
                if (n - i >= 0) {
                    int left = helper(n - i, arr, k, dp) + Math.abs(arr[n] - arr[n - i]);
                    minSteps = Math.min(minSteps, left);
                }
            }
            return dp[n] = minSteps;
        }
    }

    private static class Tabulation {
        public int minimizeCost(int k, int[] arr) {
            int n = arr.length;
            int[] dp = new int[n];
            dp[0] = 0;

            for (int i = 1; i < n; i++) {
                int minCost = Integer.MAX_VALUE;
                for (int j = 1; j <= k; j++) {
                    if (i - j >= 0) {
                        int jump = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                        minCost = Math.min(minCost, jump);
                    }
                }
                dp[i] = minCost;
            }
            return dp[n - 1];
        }
    }
}
