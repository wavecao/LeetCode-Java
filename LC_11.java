package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-16  19:46
 */
public class LC_11 {
    /**
     * 暴力法，O(n^2)
     */
    public int maxArea(int[] height) {
        if (height.length == 0 || height.length == 1) return 0;
        if (height.length == 2) return Math.min(height[0], height[1]);
        int maxArea = 0;
        for (int i = 0; i < height.length-1; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                maxArea = Math.max(maxArea, (j-i) * Math.min(height[i], height[j]));
            }
        }
        return maxArea;
    }

    /**
     * 双指针法，每次移动更小的那个，O(n)
     */
    public int maxArea_1(int[] height) {
        if (height.length == 0 || height.length == 1) return 0;
        if (height.length == 2) return Math.min(height[0], height[1]);
        int maxArea = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            maxArea = height[i] < height[j] ?
                    Math.max(maxArea, (j-i) * height[i++]) :
                    Math.max(maxArea, (j-i) * height[j--]);
        }
        return maxArea;
    }
}
