package com.cheerway.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-15  16:53
 */
public class LC_387 {

    /**
     * HashMap法
     */
    public int firstUniqChar(String s) {
        if (s.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public int firstUniqChar_1(String s) {
        if (s.length() == 0) return -1;
        int[] chars = new int[256];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)] = chars[s.charAt(i)] + 1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        new LC_387().firstUniqChar_1(s);
    }
}
