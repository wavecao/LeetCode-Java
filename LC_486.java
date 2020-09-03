package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-09-01  20:49
 */
public class LC_486 {

    /**
     * 递归法：
     * 用一个total去记录玩家A-玩家B，即每次加上玩家A拿到的数字，减去玩家B拿到的数字
     * turn这个变量就是用来控制加减的，初始为1，每次取反，即可实现
     */
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        if (n == 1 || n % 2 == 0) return true;
        return total(nums, 0, n-1, 1) >= 0;
    }

    private int total(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return nums[start] * turn;
        }
        int startTotal = nums[start] * turn + total(nums, start + 1, end, -turn);
        int endTotal = nums[end] * turn + total(nums, start, end - 1, -turn);
        return Math.max(startTotal * turn, endTotal * turn) * turn;
    }

    public boolean PredictTheWinner_1(int[] nums) {
        int n = nums.length;
        //dp[i][j] 表示当数组剩下的部分为下标 i 到下标 j 时，当前玩家与另一个玩家的分数之差的最大值，注意当前玩家不一定是先手。
        //当j>i时，dp数组没有意义，当i=j时，意味着只有一个数字可以拿，此时dp = nums[i]
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = n - 2; i >= 0 ; i--) {
            for (int j = i + 1; j < n; j++) {
                //nums[i] - dp[i+1][j]的意思是，如果当前玩家选择了nums[i]，则另一个玩家必须从[i+1, j]中挑选，这个相减就是得到分数之差
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
            }
        }
        return dp[0][n-1] >= 0;
    }
}
