package com.cheerway.leetcode;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-09  14:05
 */
public class LC_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        Arrays.fill(dp[0], false);
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i-1] < 0) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    // 装入或不装入背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j-nums[i-1]];
                }
            }
            if (dp[i][sum]) return true;
        }
        return dp[nums.length][sum];
    }
}
