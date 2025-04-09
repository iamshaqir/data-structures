package org.mshaq.ds.dp_lis;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    private static class BasicRecursion {
        public static int longestIncreasingSubsequence(int[] arr) {
            //Your code goes here
            int n = arr.length;
            return f(0, -1, arr);
        }

        private static int f(int index, int prevIndex, int[] A) {
            if (index == A.length) {
                return 0;
            }
            // include
            int include = 0;
            if (prevIndex == -1 || A[index] > A[prevIndex]) {
                include = 1 + f(index + 1, index, A);
            }

            //notInclude
            int notInclude = f(index + 1, index, A);
            return Math.max(include, notInclude);
        }
    }

    private static class Memoization {
        public static int longestIncreasingSubsequence(int[] arr) {
            //Your code goes here
            int n = arr.length;
            int[][] dp = new int[n][n + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return f(0, -1, arr, dp);
        }

        private static int f(int index, int prevIndex, int[] A, int[][] dp) {
            if (index == A.length) {
                return 0;
            }

            if (dp[index][prevIndex + 1] != -1) {
                return dp[index][prevIndex + 1];
            }
            // include
            int include = 0;
            if (prevIndex == -1 || A[index] > A[prevIndex]) {
                include = 1 + f(index + 1, index, A, dp);
            }

            int notInclude = f(index + 1, prevIndex, A, dp);
            //notInclude
            return dp[index][prevIndex + 1] = Math.max(include, notInclude);
        }
    }
}
