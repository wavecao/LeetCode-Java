package com.cheerway.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-04  22:13
 */
public class LC_567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        int l, r, valid;
        l = r = valid = 0;
        for (Character c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0)+1);
        }
        while (r < s2.length()) {
            char c = s2.charAt(r);
            r++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0)+1);
                if (window.get(c).compareTo(need.get(c)) == 0) {
                    valid++;
                }
            }
            //1、本题移动left缩小窗口的时机是窗口大小大于t.size()时，因为排列嘛，
            // 显然长度应该是一样的。
            //2、当发现valid == need.size()时，就说明窗口中就是一个合法的排列，
            // 所以立即返回true。
            while (r - l >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char temp = s2.charAt(l);
                l++;
                if (need.containsKey(temp)) {
                    if (window.get(temp).compareTo(need.get(temp)) == 0) {
                        valid--;
                    }
                    window.put(temp, window.getOrDefault(temp, 1)-1);
                }
            }
        }
        return false;
    }
}
