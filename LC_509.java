package com.cheerway.leetcode;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-07  19:38
 */
public class LC_509 {

    /**
     * 递归写法，时间复杂度O(2^n)
     */
    public int fib_1(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        return fib_1(N - 1) + fib_1(N - 2);
    }

    /**
     * 带记忆的递归算法，时间复杂度为O(n)
     */
    public int fib_2(int N) {
        if (N < 1) return 0;
        int[] memory = new int[N+1];
        Arrays.fill(memory, 0);
        return helper(memory, N);
    }

    private int helper(int[] memory, int n) {
        // base case
        if (n == 1 || n == 2) return 1;
        //如果已经计算过的
        if (memory[n] != 0) return memory[n];
        memory[n] = helper(memory, n - 1) + helper(memory, n - 2);
        return memory[n];
    }

    /**
     * 动态规划写法，时间复杂度O(n)
     */
    public int fib(int N) {
        if (N == 0) return 0;
        //题目会有N=1的测试用例
        if (N == 1 || N == 2) return 1;
        int[] dp = new int[N+1];
        //base case
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= N; ++i) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N];
    }

    /**
     * 动态规划写法，时间复杂度O(n)，不需要声明一个大数组，看上去更优雅一些
     */
    int fib_3(int n) {
        if(n == 0) return 0;
        if (n == 2 || n == 1)
            return 1;
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
