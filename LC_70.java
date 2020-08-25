package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-25  21:44
 */
public class LC_70 {
    //动态规划
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; ++i) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //压缩空间的动态规划
    public int climbStairs_1(int n) {
        if (n == 1) return 1;
        int first = 1;
        int second = 2;
        int third = 0;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    //递归法,时间超时
    public int climbStairs_2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs_2(n-1) + climbStairs_2(n-2);
    }

    //带记忆的递归法
    public int climbStairs_3(int n) {
        if (n == 1) return 1;
        int[] memory = new int[n+1];
        return helper(n, memory);
    }

    private int helper(int n, int[] memory) {
        if (memory[n] > 0) {
            return memory[n];
        }
        if (n == 1) {
            memory[n] = 1;
        } else if (n == 2) {
            memory[n] = 2;
        } else {
            memory[n] = helper(n-1, memory) + helper(n-2, memory);
        }
        return memory[n];
    }
}
