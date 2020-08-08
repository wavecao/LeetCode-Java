package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-03  20:36
 */
public class LC_415 {
    public String addStrings(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) return null;
        StringBuilder stringBuilder = new StringBuilder();
        int i = num1.length()-1;
        int j = num1.length()-1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            //'0'代表是字符0的ascii值：48 因此，'0' - '0' = 0, '1' - '0' = 1, ... '9' - '0' = 9
            // 此处可以将ASCII码转化为数字
            if (i >= 0) carry += num1.charAt(i--) - '0';
            if (j >= 0) carry += num2.charAt(j--) - '0';
            stringBuilder.append(carry % 10);
            carry /= 10;
        }
        return stringBuilder.reverse().toString();
    }
}
