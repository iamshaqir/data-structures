package org.mshaq.ds.dp_stocks;

import java.util.Arrays;

public class BuyAndSellStocks3 {

    private static class BasicRecursion {

        public int maxProfit(int[] prices) {
            return f(0, 0, 2, prices);
        }

        private int f(int index, int buy, int cap, int[] prices) {

            if (index == prices.length || cap == 0) {
                return 0;
            }

            // BUY = 0 and SELL = 1
            if (buy == 0) {
                return Math.max(
                        f(index + 1, 1, cap, prices) - prices[index], // Not allowed to BUY as you already bought
                        f(index + 1, 0, cap, prices)); // Allowed to buy as you don't have aset stock
            }
            return Math.max(
                    f(index + 1, 0, cap - 1, prices) + prices[index + 1], // Already bought need to sell and add previous profit
                    f(index + 1, 1, cap, prices)); // You can WAIT or BUY
        }
    }

    private static class Memoization {
        public int maxProfit(int[] prices) {
            int[][][] dp = new int[prices.length][2][3];
            for (int[][] rows : dp) {
                for (int[] row : rows) {
                    Arrays.fill(row, -1);
                }
            }
            return f(0, 0, 2, prices, dp);
        }

        private int f(int index, int buy, int cap, int[] prices, int[][][] dp) {
            if (index == prices.length || cap == 0) {
                return 0;
            }

            if (dp[index][buy][cap] != -1) {
                return dp[index][buy][cap];
            }
            // 0 - BUY, 1 - SELL
            int profit = 0;
            if (buy == 0) {
                profit = Math.max(
                        f(index + 1, 1, cap, prices, dp) - prices[index], // Not allowed to BUY as you already bought
                        f(index + 1, 0, cap, prices, dp)); // Allowed to buy as you don't have aset stock
            } else {
                profit = Math.max(
                        f(index + 1, 0, cap - 1, prices, dp) + prices[index + 1], // Already bought need to sell and add previous profit
                        f(index + 1, 1, cap, prices, dp)); // You can WAIT or BUY
            }
            return dp[index][buy][cap] = profit;
        }
    }

    private static class Tabulation {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][][] dp = new int[n + 1][2][3];
            // BUY = 0, SELL = 1
            for (int index = n - 1; index >= 0; index--) {
                for (int buy = 0; buy <= 1; buy++) {
                    for (int cap = 1; cap <= 2; cap++) {
                        if (buy == 0) {
                            // if you are buying, you need subtract from previous bought price
                            dp[index][buy][cap] = Math.max(dp[index + 1][1][cap] - prices[index], dp[index + 1][0][cap]);
                        } else {
                            // if you are selling, it means you are in profit, add it.
                            dp[index][buy][cap] = Math.max(dp[index + 1][0][cap - 1] + prices[index], dp[index + 1][1][cap]);
                        }
                    }
                }
            }
            return dp[0][0][2];
        }

        public int maxProfitSO(int[] prices) {
            int n = prices.length;
            int[][] next = new int[2][3];
            int[][] current = new int[2][3];
            // BUY = 0, SELL = 0
            for (int index = n - 1; index >= 0; index--) {
                for (int buy = 0; buy <= 1; buy++) {
                    for (int cap = 1; cap <= 2; cap++) {
                        if (buy == 0) {
                            // if you are buying, you need subtract from previous bought price
                            current[buy][cap] = Math.max(next[1][cap] - prices[index], next[0][cap]);
                        } else {
                            // if you are selling, it means you are in profit, add it.
                            current[buy][cap] = Math.max(next[0][cap - 1] + prices[index], next[1][cap]);
                        }
                    }
                }
                next = current;
            }
            return current[0][2];
        }
    }
}
