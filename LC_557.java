package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-30  10:57
 */
public class LC_557 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(new StringBuilder(word).reverse().toString());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
