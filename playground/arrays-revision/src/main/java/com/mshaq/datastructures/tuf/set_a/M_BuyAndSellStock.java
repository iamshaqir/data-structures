package com.mshaq.datastructures.tuf.set_a;

public class M_BuyAndSellStock {


    public int getStockBru(int[] A) {
        int maxProfit = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] > A[i]) {
                    int currentProfit = A[j] - A[i];
                    maxProfit = Math.max(maxProfit, currentProfit);
                }
            }
        }
        return maxProfit;
    }

    public int getStockPriceBet(int[] A) {
        int maxProfit = 0;
        int minPurchasePrice = Integer.MAX_VALUE;
        for (int currentPrice : A) {
            if (currentPrice > minPurchasePrice) {
                int profit = currentPrice - minPurchasePrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                minPurchasePrice = currentPrice;
            }
        }
        return maxProfit;
    }

    public int getStockPrice(int[] A) {
        int maxProfit = 0;
        int minPurchasePrice = Integer.MAX_VALUE;
        for (int currentPrice : A) {
            int profit = currentPrice - minPurchasePrice;
            maxProfit = Math.max(maxProfit, profit);
            minPurchasePrice = Math.min(minPurchasePrice, currentPrice);
        }
        return maxProfit;
    }

    //Input: prices = [7,1,5,3,6,4]
    //Output: 5
}
