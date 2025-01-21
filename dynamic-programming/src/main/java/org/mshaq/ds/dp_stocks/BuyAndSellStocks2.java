package org.mshaq.ds.dp_stocks;

import java.util.Arrays;

public class BuyAndSellStocks2 {

    private static class BasicRecursion {

        public int maxProfit(int[] prices) {
            return f(0, 1, prices);
        }

        private int f(int index, int buy, int[] prices) {

            if (index == prices.length) {
                return 0;
            }
            // 1 - BUY, 2 - SELL
            int profit = 0;
            if (buy == 1) {
                // if you are buying, you need subtract from previous bought price
                profit = Math.max(f(index + 1, 0, prices) - prices[index],
                        f(index + 1, 1, prices));
            } else {
                // if you are selling, it means you are in profit, add it.
                profit = Math.max(f(index + 1, 1, prices) + prices[index],
                        f(index + 1, 0, prices));
            }
            return profit;
        }
    }

    private static class Memoization {
        public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][2];
            for (int[] rows : dp) {
                Arrays.fill(rows, -1);
            }
            return f(0, 1, prices, dp);
        }

        private int f(int index, int buy, int[] prices, int[][] dp) {
            if (index == prices.length) {
                return 0;
            }

            if (dp[index][buy] != -1) {
                return dp[index][buy];
            }
            // 1 - BUY, 2 - SELL
            int profit = 0;
            if (buy == 1) {
                // if you are buying, you need subtract from previous bought price
                profit = Math.max(f(index + 1, 0, prices, dp) - prices[index],
                        f(index + 1, 1, prices, dp));
            } else {
                // if you are selling, it means you are in profit, add it.
                profit = Math.max(f(index + 1, 1, prices, dp) + prices[index],
                        f(index + 1, 0, prices, dp));
            }
            return dp[index][buy] = profit;
        }
    }

    private static class Tabulation {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n + 1][2];
            dp[n][0] = dp[n][1] = 0;

            // BUY = 0, SELL = 0
            for (int index = n - 1; index >= 0; index--) {
                for (int buy = 0; buy <= 1; buy++) {
                    if (buy == 0) {
                        // if you are buying, you need subtract from previous bought price
                        dp[index][buy] = Math.max(dp[index + 1][1] - prices[index], dp[index + 1][0]);
                    } else {
                        // if you are selling, it means you are in profit, add it.
                        dp[index][buy] = Math.max(dp[index + 1][0] + prices[index], dp[index + 1][1]);
                    }
                }
            }
            return dp[0][0];
        }

        public int maxProfitSO(int[] prices) {
            int n = prices.length;
            int[] next = new int[2];
            int[] current = new int[2];
            // BUY = 0, SELL = 0
            for (int index = n - 1; index >= 0; index--) {
                for (int buy = 0; buy <= 1; buy++) {
                    if (buy == 0) {
                        // if you are buying, you need subtract from previous bought price
                        current[buy] = Math.max(next[1] - prices[index], next[0]);
                    } else {
                        // if you are selling, it means you are in profit, add it.
                        current[buy] = Math.max(next[0] + prices[index], next[1]);
                    }
                }
                next = current;
            }
            return current[0];
        }

        public int maxProfitSOVar(int[] prices) {
            int n = prices.length;
            int nextBuy = 0, nextNotBuy = 0;
            int currentBuy = 0, currentNotBuy = 0;
            for (int index = n - 1; index >= 0; index--) {
                // if you are buying, you need subtract from previous bought price
                currentBuy = Math.max(nextNotBuy - prices[index], nextBuy);
                // if you are selling, it means you are in profit, add it.
                currentNotBuy = Math.max(nextBuy + prices[index], nextNotBuy);
                nextBuy = currentBuy;
                nextNotBuy = currentNotBuy;
            }
            return nextBuy;
        }
    }
}
