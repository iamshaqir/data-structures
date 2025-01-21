package com.ms.data.structures.arrays;

public class BuyAndSellStocks {


    // 2 3 6 5 4 7 1

    public int _getProfit(int[] prices) {
        int profit = 0;
        int minBuyPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            int currentPrice = price - minBuyPrice;
            profit = Math.max(profit, currentPrice);
            minBuyPrice = Math.min(price, minBuyPrice);
        }
        return profit;
    }

    public int getProfit_(int[] prices) {
        int profit = 0;
        int minBuyPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price > minBuyPrice) {
                int currentPrice = price - minBuyPrice;
                profit = Math.max(profit, currentPrice);
            } else {
                minBuyPrice = price;
            }
        }
        return profit;
    }

    // currentPrice = 6
    // profit = 5
    public int getProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    int currentPrice = prices[j] - prices[i];
                    profit = Math.max(profit, currentPrice);
                }
            }
        }
        return profit;
    }
}
