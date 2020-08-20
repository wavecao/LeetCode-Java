package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-19  19:42
 */
public class LC_647 {
    //中心扩展法
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int left = i / 2;
            int right = i / 2 + i % 2;
            //如果新扩展出的两端字符相同就ans++
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                ans++;
            }
        }
        return ans;
    }
}
