package com.cheerway.leetcode;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-07  20:10
 */
public class LC_322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                //dp[i]代表amount为i时的解
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1+dp[i-1]);
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
