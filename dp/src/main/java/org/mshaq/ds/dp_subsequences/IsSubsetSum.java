package org.mshaq.ds.dp_subsequences;

import java.util.Arrays;

public class IsSubsetSum {

    private static class BasicRecursion {

        public boolean isSubsetSum(int[] arr, int target) {
            int n = arr.length;
            return f(arr, n - 1, target);
        }

        private boolean f(int[] A, int index, int target) {
            if (target == 0) return true;
            if (index == 0) return target == A[0];
            boolean notInclude = f(A, index - 1, target);
            boolean include = false;

            if (target >= A[index]) {
                include = f(A, index - 1, target - A[index]);
            }
            return notInclude || include;
        }
    }

    private static class Memoization {
        public boolean isSubsetSum(int[] arr, int target) {
            int n = arr.length;
            int[][] dp = new int[n][target + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return f(arr, n - 1, target, dp);
        }

        private boolean f(int[] A, int index, int target, int[][] dp) {
            if (target == 0) return true;
            if (index == 0) return target == A[0];

            if (dp[index][target] != -1) {
                return dp[index][target] == 1;
            }

            boolean notInclude = f(A, index - 1, target, dp);
            boolean include = false;

            if (target >= A[index]) {
                include = f(A, index - 1, target - A[index], dp);
            }

            dp[index][target] = (notInclude || include) ? 1 : 0;
            return notInclude || include;
        }
    }

    private static class Tabulation {
        public boolean isSubsetSum(int[] A, int k) {
            int n = A.length;
            boolean[][] dp = new boolean[n][k + 1];

            // target can be zero at any index of array, so true
            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }

            if (k >= A[0]) {
                dp[0][A[0]] = true;
            }

            for (int index = 1; index < n; index++) {
                for (int target = 1; target <= k; target++) {

                    boolean notInclude = dp[index - 1][target];
                    boolean include = false;

                    if (target >= A[index]) {
                        include = dp[index - 1][target - A[index]];
                    }
                    dp[index][target] = include || notInclude;
                }
            }
            return dp[n - 1][k];
        }

        public boolean isSubsetSumSP(int[] A, int k) {
            int n = A.length;
            boolean[] previous = new boolean[k + 1];

            previous[0] = true;
            if (k >= A[0]) {
                previous[A[0]] = true;
            }

            for (int index = 1; index < n; index++) {
                boolean[] current = new boolean[k + 1];
                current[0] = true;
                for (int target = 1; target <= k; target++) {
                    boolean notInclude = previous[target];
                    boolean include = false;

                    if (target >= A[index]) {
                        include = previous[target - A[index]];
                    }
                    current[target] = include || notInclude;
                }
                previous = current;
            }
            return previous[k];
        }
    }
}
