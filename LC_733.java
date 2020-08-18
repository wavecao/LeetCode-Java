package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-16  15:27
 */
public class LC_733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (newColor == oldColor) return image;
        return dfs(image, sr, sc, newColor, oldColor);
    }

    private int[][] dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (sr < 0 || sr > image.length || sc < 0 || sc > image[0].length) return image;
        if (image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
            dfs(image, sr+1, sc, newColor, oldColor);
            dfs(image, sr-1, sc, newColor, oldColor);
            dfs(image, sr, sc+1, newColor, oldColor);
            dfs(image, sr, sc-1, newColor, oldColor);
        }
        return image;
    }
}
