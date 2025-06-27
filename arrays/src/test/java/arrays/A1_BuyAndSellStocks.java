package arrays;


import org.junit.jupiter.api.Test;

/**
 * Leetcode: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Best Time to Buy and Sell Stock</a>
 */
public class A1_BuyAndSellStocks {

    int[] A = {7,1,5,3,6,4};

    @Test
    void BuyAndSellStocksOptimal() {
        int maxProfit = BuyAndSellStocksOptimal(A);
        System.out.println("Max profit: " + maxProfit);
    }

    @Test
    void BuyAndSellStocksBest() {

        int maxProfitBest = BuyAndSellStocksBest(A);
        System.out.println("Max profit: " + maxProfitBest);
    }

    @Test
    void buyAndSellStocksBrute() {

        int maxProfitBrute = buyAndSellStocksBrute(A);
        System.out.println("Max profit: " + maxProfitBrute);
    }
    // 7 1 5 3 6 4

    int BuyAndSellStocksOptimal(int[] A) {
        int maxProfit = 0;
        int minBuyPrice = Integer.MAX_VALUE;

        for (int currentPrice : A) {
            int currentProfit = currentPrice - minBuyPrice;
            maxProfit = Math.max(maxProfit, currentProfit);
            minBuyPrice = Math.min(minBuyPrice, currentPrice);
        }
        return maxProfit;
    }

    int BuyAndSellStocksBest(int[] A) {
        int maxProfit = 0;
        int minBuyPrice = Integer.MAX_VALUE;
        for (int currentPrice : A) {
            if (currentPrice > minBuyPrice) {
                int currentProfit = currentPrice - minBuyPrice;
                maxProfit = Math.max(maxProfit, currentProfit);
            } else {
                minBuyPrice = currentPrice;
            }
        }
        return maxProfit;
    }

    // 7 1 5 3 6 4
    int buyAndSellStocksBrute(int[] A) {
        int maxprofit = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] > A[i]) {
                    maxprofit = Math.max(maxprofit, A[j] - A[i]);
                }
            }
        }
        return maxprofit;
    }
}

/*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to buy one stock and choosing a
    different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any
    profit, return 0.

    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transactions are done and the max profit = 0.

 */
