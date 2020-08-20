package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-19  21:26
 */
public class LC_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String res = strs[0];
        //用strs[0]的每一个字符和后面的字符串的对应字符作比较
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            //j就是每次比较的下标
            for (; j < res.length() && j < strs[i].length(); j++) {
                if (res.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            res = res.substring(0, j);
            //如果比较过某个字符串之后共同前缀为空，那么直接返回就行了，再比较也是浪费时间
            if ("".equals(res)) {
                return res;
            }
        }
        return res;
    }
}
