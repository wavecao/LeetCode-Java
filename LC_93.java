package com.cheerway.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-09  20:27
 */
public class LC_93 {

    static final int SEG_COUNT = 4;
    List<String> list = new ArrayList<>();
    int[] seg = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                for (int k = 1; k < 4; k++) {
                    for (int l = 1; l < 4; l++) {
                        if (i+j+k+l == s.length()) {
                            int i1 = Integer.parseInt(s.substring(0,i));
                            int i2 = Integer.parseInt(s.substring(i,i+j));
                            int i3 = Integer.parseInt(s.substring(i+j,i+j+k));
                            int i4 = Integer.parseInt(s.substring(i+j+k));
                            if (i1 <= 255 && i2 <= 255 && i3 <= 255 && i4 <= 255) {
                                sb.append(i1).append(".").append(i2).append(".").
                                        append(i3).append(".").append(i4);
                                //之所以加三是因为sb在上面家了三个点，加三之后相等说明没有前导0被parseInt排除掉，说明这个组合是一个合法的ip
                                if (sb.length() == s.length()+3) {
                                    res.add(sb.toString());

                                }
                                sb.delete(0,sb.length());
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public List<String> restoreIpAddresses_1(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        dfs(arr, 0, 0, len);
        return list;
    }

    private void dfs(char[] arr, int depth, int start, int len) {
        //如果深度（即切片的个数）达到了四个
        if (depth == SEG_COUNT) {
            StringBuilder sb = new StringBuilder();
            if (start == len) {
                for (int i = 0; i < SEG_COUNT; i++) {
                    sb.append(seg[i]);
                    if (i != SEG_COUNT-1) {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            //如果start != len说明没有用完s的所有字符，直接回溯
            return;
        }

        //如果用完了所有字符还没有找够4个切片，就回溯
        if (start == len) return;

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (arr[start] == '0') {
            seg[depth] = 0;
            dfs(arr, depth+1, start+1, len);
        }

        int temp = 0;
        for (int i = start; i < len; i++) {
            //因为循环内存在回溯，比如第一次temp = 0 + 2 = 2
            //回溯之后temp = 2 * 10 + 5 = 25，这就是乘10的原因
            temp = temp*10 + (arr[i] - '0');
            if (temp > 0 && temp <= 255) {
                seg[depth] = temp;
                dfs(arr, depth+1, i+1, len);
            } else {
                //如果已经不在合理范围内了，temp就没有必要往下拼接了，直接结束整个循环
                break;
            }
        }
    }
}
