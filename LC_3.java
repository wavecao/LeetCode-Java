package com.cheerway.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-05  20:23
 */
public class LC_3 {
    public int lengthOfLongestSubstring_1(String s) {
        int maxLen = 0;
        if (s.length() == 0) return 0;
        //pwwkew
        Map<Character,Integer> window = new HashMap<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (window.containsKey(s.charAt(i))) {
                //如果此次冲突的字母的下标在以前冲突过的前面，直接start = window.get(s.charAt(i)) + 1会把start倒回去
                start = Math.max(start,window.get(s.charAt(i)) + 1);
            }
            window.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i-start+1);
        }
        return maxLen;
    }

    //此方法还未运行通------运行痛了，问题同23行注释
    public int lengthOfLongestSubstring_2(String s) {
        int maxLen = 0;
        if (s.length() == 0) return 0;
        Map<Character,Integer> window = new HashMap<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            if (window.containsKey(ch)) {
                left = Math.max(left, window.get(ch)+1);
            }
            window.put(ch, right-1);
            maxLen = Math.max(maxLen, right-left);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(new LC_3().lengthOfLongestSubstring_1(s));
    }
}
