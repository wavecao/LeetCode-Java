package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-24  20:59
 */
public class LC_459 {

    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

    //暴力枚举
    public boolean repeatedSubstringPattern_1(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; i++) {
            //n整除i，才意味着用i个字符可以拼成n
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j-i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}
