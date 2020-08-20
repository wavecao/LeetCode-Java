package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-19  20:05
 */
public class LC_5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";
        //左指针
        int left;
        //右指针
        int right;
        //每次扩展后的长度，初始长度为1是指s.charAt(i)这个字符，而左右指针在这个字符两侧扩展
        int len = 1;
        //最大长度
        int maxLen = 0;
        //最长回文子串开始的地方
        int maxStart = 0;

        for (int i = 0; i < n; ++i) {
            left = i - 1;
            right = i + 1;
            //单独向左扩展
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
                len++;
            }
            //单独向右扩展
            while (right < n && s.charAt(right) == s.charAt(i)) {
                right++;
                len++;
            }
            //尝试向两侧扩展
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                len += 2;
            }
            if (len > maxLen) {
                maxLen = len;
                //因为在扩展后执行了left--，所以开始的下标应该是left+1
                maxStart = left + 1;
            }
            //len回归初始状态
            len = 1;
        }
        return s.substring(maxStart, maxStart+maxLen);
    }

    //动态规划法
    public String longestPalindrome_1(String s) {
        int n = s.length();
        if (n < 2) return s;
        //最大长度
        int maxLen = 1;
        //开始下标
        int begin = 0;

        //dp[i][j] 表示s[i, j] 是否是回文串
        boolean dp[][] = new boolean[n][n];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    //else内的判断是建立在charArray[i] = charArray[j]的前提之下的
                    if (j - i < 3) {
                        //i位置=j位置并且字串长度为2的话，一定是回文串
                        dp[i][j] = true;
                    } else {
                        //i位置=j位置并且字串长度大于2的话，取决于他内层的字符串是不是回文
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }
}
