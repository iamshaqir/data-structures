package org.mshaq.ds.dp_stocks;

public class BuyAndSellStocks {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = prices[0];
        for (int price : prices) {
            int currentPrice = price - minPrice;
            profit = Math.max(profit, currentPrice);
            minPrice = Math.min(price, minPrice);
        }
        return profit;
    }
}
