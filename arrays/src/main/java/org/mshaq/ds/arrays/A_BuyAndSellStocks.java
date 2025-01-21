package org.mshaq.ds.arrays;

public class A_BuyAndSellStocks {

    public static int getPrice(int[] prices) {
        int profit = 0;
        int minBuyPrice = Integer.MAX_VALUE;
        for (int currentPrice : prices) {
            if (currentPrice > minBuyPrice) {
                int currentProfit = currentPrice - minBuyPrice;
                profit = Math.max(currentProfit, profit);
            } else {
                minBuyPrice = currentPrice;
            }
        }
        return profit;
    }

    public static int getPriceOp(int[] prices) {
        int profit = 0;
        int minBuyPrice = Integer.MAX_VALUE;
        for (int currentPrice : prices) {
            int currentProfit = currentPrice - minBuyPrice;
            profit = Math.max(currentProfit, profit);
            minBuyPrice = Math.min(currentPrice, minBuyPrice);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] input = {7, 1, 5, 3, 6, 4};
        getPriceOp(input);
    }
}
