package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-10  20:45
 */
public class LC_696 {
    public int countBinarySubstrings(String s) {
        // pre : 前一种数字的个数统计 ，从0开始，刚开的时候前面没有另一种值，所以为0
        // cur : 当前这种数字的个数统计 ，从1开始，因为就是从自己开始，当然为1
        // res : 满足要求的结果数量
        int last, curr, res;
        curr = 1; last = res = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i-1)) {
                curr++;
            }
            else {
                last = curr;
                curr = 1;
            }
            // 如果前一种值比当前的值多，就表明可以满足一个
            // 当pre小于cur的时候，
            // 就比如  00 111， 从00 1 到 00 11 到 00 111 加了两次count，
            // 第三次就加不了了，因为00111 已经不满足个数相等了
            if (last >= curr){
                res++;
            }
        }
        return res;
    }



}
