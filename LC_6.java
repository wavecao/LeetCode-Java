package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-19  20:57
 */
public class LC_6 {

    // 这道题可以这么考虑：对于输入的字符串s，其下标 i / (numRows-1) 如果为偶数或零，
    // 则代表该下标代表的字符在Z字型中属于竖列。如果 i / (numRows-1) 如果为奇数，
    // 则代表该下标代表的字符在Z字型中属于斜列（Z字型的中间倾斜部分）。
    // 如果当前字符属于竖列，则按照正序依次保存在StringBuilder数组 res 中res[remain].append(s.charAt(i));
    // 如果属于斜列，则逆序保存res[numRows-remain-1].append(s.charAt(i));
    public String convert(String s, int numRows) {
        int len = s.length();
        if (len == 0 || numRows < 1) {
            return "";
        }
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows; ++i) {
            res[i] = new StringBuilder();
        }
        int ans;
        int remain;
        for (int i = 0; i < len; ++i) {
            ans = i / (numRows-1);
            remain = i % (numRows-1);
            if (ans % 2 == 0) {
                res[remain].append(s.charAt(i));
            } else {
                res[numRows-remain-1].append(s.charAt(i));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            stringBuilder.append(res[i].toString());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 3;
        new LC_6().convert(s, numRows);
    }
}
