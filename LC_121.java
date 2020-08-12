package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-08  19:52
 */
public class LC_121 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int maxRes = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int temp = prices[j] - prices[i];
                if (temp > maxRes) maxRes = temp;
            }
        }
        return maxRes;
    }

    public int maxProfit_1(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price > minPrice) {
                maxProfit = Math.max(maxProfit, price - minPrice);
            } else {
                minPrice = price;
            }
        }
        return maxProfit;
    }
}
