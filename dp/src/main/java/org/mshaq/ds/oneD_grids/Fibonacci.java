package org.mshaq.ds.oneD_grids;

public class Fibonacci {

    private static class Memoization {
        // TOP DOWN
        public int fib(int n, int[] A) {
            if (n <= 1) {
                return n;
            }
            if (A[n] != -1) {
                return A[n];
            }
            return A[n] = fib(n - 1, A) + fib(n - 2, A);
        }
    }

    private static class Tabulation {
        // BOTTOM UP
        public int fib(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }

        public int fibonacci(int n) {
            if (n < 0) return -1;
            if (n == 0 || n == 1) return n;
            int first = 1;
            int second = 1;
            for (int i = 2; i <= n; i++) {
                int sum = first + second;
                first = second;
                second = sum;
            }

            return second;
        }
    }
}
