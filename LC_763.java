package com.cheerway.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-19  22:08
 */
public class LC_763 {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int len = S.length();
        //记录每个字母最后出现的位置
        for (int i = 0; i < len; ++i) {
            last[S.charAt(i) - 'a'] = i;
        }
        //区间的开始和结尾
        int start = 0, end = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; ++i) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            //i = end说明当前区间所有的字符都检查完了
            if (i == end) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
