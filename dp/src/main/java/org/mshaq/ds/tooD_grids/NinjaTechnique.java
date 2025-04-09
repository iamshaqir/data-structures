package org.mshaq.ds.tooD_grids;

import java.util.Arrays;

public class NinjaTechnique {

    private static class BasicRec {

        public int maximumPoints(int[][] arr, int N) {
            return helper(arr, N - 1, 3);
        }

        private int helper(int[][] A, int index, int lastWorkout) {
            if (index <= 0) {
                int maximum = Integer.MIN_VALUE;
                for (int i = 0; i < A[0].length; i++) {
                    if (i != lastWorkout) {
                        int currentMax = A[index][i];
                        maximum = Math.max(maximum, currentMax);
                    }
                }
                return maximum;
            }

            int maximum = Integer.MIN_VALUE;
            for (int i = 0; i < A[0].length; i++) {
                if (i != lastWorkout) {
                    int currentMax = A[index][i] + helper(A, index - 1, i);
                    maximum = Math.max(maximum, currentMax);
                }
            }
            return maximum;
        }
    }

    private static class Memoization {

        public int maximumPoints(int[][] arr, int N) {
            int[][] dp = new int[arr.length][arr[0].length + 1];

            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return helper(arr, N - 1, 3, dp);
        }

        private int helper(int[][] A, int currentDay, int lastDay, int[][] dp) {
            if (currentDay <= 0) {
                int maximum = Integer.MIN_VALUE;
                for (int i = 0; i < A[0].length; i++) {
                    if (i != lastDay) {
                        int currentMax = A[currentDay][i];
                        maximum = Math.max(maximum, currentMax);
                    }
                }
                return maximum;
            }

            if (dp[currentDay][lastDay] != -1) {
                return dp[currentDay][lastDay];
            }

            int maximum = Integer.MIN_VALUE;
            for (int i = 0; i < A[0].length; i++) {
                if (i != lastDay) {
                    int currentMax = A[currentDay][i] + helper(A, currentDay - 1, i, dp);
                    maximum = Math.max(maximum, currentMax);
                }
            }
            return dp[currentDay][lastDay] = maximum;
        }
    }

    private static class Tabulation {
        public int maximumPoints(int[][] A, int N) {
            // Reason for taking extra index at column is,
            // suppose if he gives us single row
            // then we can compare either of indexes not all
            // with extra index position we can compare all the three for max.
            int[][] dp = new int[A.length][4];
            dp[0][0] = Math.max(A[0][1], A[0][2]);
            dp[0][1] = Math.max(A[0][0], A[0][2]);
            dp[0][2] = Math.max(A[0][0], A[0][1]);
            dp[0][3] = Math.max(A[0][0], Math.max(A[0][1], A[0][2]));

            for (int day = 1; day < A.length; day++) {
                for (int lastDay = 0; lastDay < 4; lastDay++) {
                    for (int task = 0; task < 3; task++) {
                        if (lastDay != task) {
                            int currMax = A[day][task] + dp[day - 1][task];
                            dp[day][lastDay] = Math.max(dp[day][lastDay], currMax);
                        }
                    }
                }
            }
            return dp[N - 1][3];
        }

        public int maximumPointsSO(int[][] A, int N) {
            int[] prev = new int[4];
            prev[0] = Math.max(A[0][1], A[0][2]);
            prev[1] = Math.max(A[0][0], A[0][2]);
            prev[2] = Math.max(A[0][0], A[0][1]);
            prev[3] = Math.max(A[0][0], Math.max(A[0][1], A[0][2]));

            for (int day = 1; day < A.length; day++) {
                int[] temp = new int[4];
                for (int lastDay = 0; lastDay < 4; lastDay++) {
                    for (int task = 0; task < 3; task++) {
                        if (lastDay != task) {
                            int currMax = A[day][task] + prev[task];
                            temp[lastDay] = Math.max(temp[lastDay], currMax);
                        }
                    }
                }
                prev = temp;
            }
            return prev[3];
        }
    }
}
