package org.mshaq.ds.dp_subsequences;

import java.util.Arrays;

public class Knapsack01 {

    private static class BasicRecursion {
        public int knapsack(int[] weight, int[] value, int n, int maxWeight) {
            return f(n - 1, maxWeight, weight, value);
        }

        private int f(int index, int maxWeight, int[] weight, int[] value) {
            //base-case
            if (index == 0) {
                if (weight[index] <= maxWeight) {
                    return value[0];
                }

                return 0;
            }

            // include
            int include = Integer.MIN_VALUE;
            if (weight[index] <= maxWeight) {
                include = value[index] + f(index - 1, maxWeight - weight[index], weight, value);
            }

            //not-include
            int notInclude = f(index - 1, maxWeight, weight, value);
            return Math.max(include, notInclude);
        }
    }

    private static class Memoization {
        public int knapsack(int[] weight, int[] value, int n, int maxWeight) {
            int[][] dp = new int[n][maxWeight + 1];

            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return f(n - 1, maxWeight, weight, value, dp);
        }

        private int f(int index, int maxWeight, int[] weight, int[] value, int[][] dp) {
            //base-case
            if (index == 0) {
                if (weight[index] <= maxWeight) {
                    return value[0];
                }

                return 0;
            }

            if (dp[index][maxWeight] != -1) {
                return dp[index][maxWeight];
            }

            // include
            int include = Integer.MIN_VALUE;
            if (weight[index] <= maxWeight) {
                include = value[index] + f(index - 1, maxWeight - weight[index], weight, value, dp);
            }

            //not-include
            int notInclude = f(index - 1, maxWeight, weight, value, dp);
            return dp[index][maxWeight] = Math.max(include, notInclude);
        }
    }

    private static class Tabulation {

        public int knapsack(int[] weight, int[] value, int n, int maxWeight) {
            int[][] dp = new int[n][maxWeight + 1];

            // base-case
            for (int i = weight[0]; i <= maxWeight; i++) {
                dp[0][i] = value[0];
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= maxWeight; j++) {

                    int include = Integer.MIN_VALUE;
                    if (weight[i] <= j) {
                        include = value[i] + dp[i - 1][j - weight[i]];
                    }

                    int notInclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, notInclude);
                }
            }
            return dp[n - 1][maxWeight];
        }
    }
}
