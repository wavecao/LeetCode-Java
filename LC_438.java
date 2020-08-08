package com.cheerway.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-05  19:48
 */
public class LC_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for (Character ch : p.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0)+1);
        }
        //当前窗口中包含的有效字符种数，不是个数！！！
        int valid = 0;
        int left, right;
        left = right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0)+1);
                if (window.get(c).compareTo(need.get(c)) == 0) {
                    valid++;
                }
            }

            while (right - left >= p.length()){
                if (valid == need.size()) {
                    res.add(left);
                }
                char temp = s.charAt(left);
                left++;
                if (need.containsKey(temp)) {
                    if (need.get(temp).equals(window.get(temp))) {
                        valid--;
                    }
                    window.put(temp, window.getOrDefault(temp, 1)-1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //String s = "cbaebabacd";
        String s = "abab";
        //String p = "abc";
        String p = "ab";

        List<Integer> list = new LC_438().findAnagrams(s, p);
        System.out.println(list);
        for (Integer i : list)
            System.out.println(i);
    }
}
