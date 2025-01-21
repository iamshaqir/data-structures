package org.mshaq.ds.tooD_grids;

import java.util.Arrays;

public class GridUniquePaths {

    private static class BasicRecursion {
        public int uniquePaths(int m, int n) {
            return helper(m - 1, n - 1);
        }

        private int helper(int m, int n) {
            if (m == 0 && n == 0) {
                return 1;
            }

            if (m < 0 || n < 0) {
                return 0;
            }
            int left = helper(m - 1, n);
            int right = helper(m, n - 1);
            return left + right;
        }
    }

    // TOP - DOWN
    private static class Memoization {

        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];

            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return helper(m - 1, n - 1, dp);
        }

        private int helper(int m, int n, int[][] dp) {
            if (m == 0 && n == 0) {
                return 1;
            }

            if (m < 0 || n < 0) {
                return 0;
            }

            if (dp[m][n] != -1) {
                return dp[m][n];
            }

            return dp[m][n] =
                    helper(m - 1, n, dp) + helper(m, n - 1, dp);
        }
    }

    private static class Tabulation {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];

            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            //Base case of recursion
            dp[0][0] = 1;

            // Express various states in for loops and write recursion logic
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) continue;
                    int right = 0, bottom = 0;

                    if (i > 0) {
                        bottom = dp[i - 1][j];
                    }

                    if (j > 0) {
                        right = dp[i][j - 1];
                    }

                    dp[i][j] = right + bottom;
                }
            }

            return dp[m - 1][n - 1];
        }

        public int uniquePathsSO(int m, int n) {
            int[] previous = new int[n];

            for (int i = 0; i < m; i++) {
                int[] temp = new int[n];
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) temp[j] = 1;
                    int right = 0, bottom = 0;
                    if (i > 0) {
                        bottom = previous[j];
                    }

                    if (j > 0) {
                        right = temp[j - 1];
                    }
                    temp[j] = right + bottom;
                }
                previous = temp;
            }

            return 0;
        }
    }
}
