package org.mshaq.ds.oneD_grids;

import java.util.Arrays;

public class HouseRobber {

    private static class basicRec {
        public int rob(int[] nums) {
            int n = nums.length;
            return helper(n - 1, nums);
        }

        private int helper(int n, int[] nums) {
            if (n == 0) {
                return nums[n];
            }

            if (n < 0) {
                return 0;
            }

            int first = nums[n] + helper(n - 2, nums);
            int second = helper(n - 1, nums);
            return Math.max(first, second);
        }
    }

    private static class Memoization {
        public int rob(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, -1);
            return helper(n - 1, nums, dp);
        }

        private int helper(int n, int[] nums, int[] dp) {
            if (n == 0) {
                return nums[n];
            }

            if (n < 0) {
                return 0;
            }

            if (dp[n] != -1) {
                return dp[n];
            }
            int first = nums[n] + helper(n - 2, nums, dp);
            int second = helper(n - 1, nums, dp);
            return dp[n] = Math.max(first, second);
        }
    }

    private static class Tabulation {
        public int rob(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            for (int i = 1; i < n; i++) {
                int first = nums[i];
                if (i > 1) {
                    first += dp[i - 2];
                }
                int second = dp[i - 1];
                dp[i] = Math.max(first, second);
            }

            return dp[n - 1];
        }

        public int robSpaceO(int[] nums) {
            int n = nums.length;
            int previous = nums[0];
            int previous2 = 0;

            for (int i = 1; i < n; i++) {
                int first = nums[i];
                if (i > 1) {
                    first += previous2;
                }
                int second = previous;
                int currMax = Math.max(first, second);
                previous2 = previous;
                previous = currMax;
            }
            return previous;
        }
    }
}
