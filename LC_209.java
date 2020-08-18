package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-17  20:23
 */
public class LC_209 {
    //暴力法 O(n^2)
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            int sum = 0;
            for (int j = i; j < nums.length; ++j) {
                sum += nums[j];
                if (sum >= s) {
                    minLen = Math.min(minLen, j-i+1);
                    //跳出内层循环，就是尝试缩小长度
                    break;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    //双指针法，O(n)
    public int minSubArrayLen_1(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) return n;
        int minLen = Integer.MAX_VALUE;
        int left = 0, right = 0, sum = 0;
        while (right < n) {
            sum += nums[right];
            while (sum >= s) {
                minLen = Math.min(minLen, right-left+1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
