package org.mshaq.ds.oneD_grids;

import java.util.Arrays;

public class FrogJump {

    private static class basicRec {
        public int minimumEnergy(int[] arr, int N) {
            return helper(arr, N - 1);
        }

        private int helper(int[] A, int N) {
            if (N == 0) {
                return 0;
            }

            int left = helper(A, N - 1) + Math.abs(A[N] - A[N - 1]);
            int right = Integer.MAX_VALUE;

            if (N > 1) {
                right = helper(A, N - 2) + Math.abs(A[N] - A[N - 2]);
            }

            return Math.min(left, right);
        }
    }

    private static class Memoization {

        public int minimumEnergy(int N, int[] arr) {
            int[] dp = new int[N + 1];
            Arrays.fill(dp, -1);
            return helper(N - 1, arr, dp);
        }

        private int helper(int N, int[] A, int[] DP) {
            if (N == 0) {
                return 0;
            }
            if (DP[N] != -1) {
                return DP[N];
            }

            int left = helper(N - 1, A, DP) + Math.abs(A[N - 1] - A[N]);
            int right = Integer.MAX_VALUE;
            if (N > 1) {
                    right = helper(N - 1, A, DP) + Math.abs(A[N - 2] - A[N]);
            }

            return DP[N] = Math.min(left, right);
        }

    }

    private static class Tabulation {
        public int minimumEnergy(int N, int[] arr) {
            int[] dp = new int[N + 1];
            dp[0] = 0;
            for (int i = 1; i < N; i++) {

                int left = dp[i - 1] + Math.abs(arr[i - 1] - arr[i]);
                int right = Integer.MAX_VALUE;
                if (i > 1) {
                    right = dp[i - 2] + Math.abs(arr[i - 2] - arr[i]);
                }
                dp[i] = Math.min(left, right);
            }
            return dp[N - 1];
        }

        public int minimumEnergySO(int N, int[] A) {
            int first = 0;
            int second = 0;
            for (int i = 1; i < N; i++) {
                int left = first + Math.abs(A[i - 1] - A[i]);
                int right = Integer.MAX_VALUE;
                if (i > 1) {
                    right = second + Math.abs(A[i - 2] - A[i]);
                }
                int minEnergy = Math.min(left, right);
                second = first;
                first = minEnergy;
            }

            return first;
        }
    }

    public static void main(String[] args) {
        int[] A = {10, 20, 30, 10};
        int N = 4;
        int res = new FrogJump.basicRec().minimumEnergy(A, N);
    }
}
