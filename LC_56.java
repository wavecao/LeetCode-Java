package com.cheerway.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-17  21:10
 */
public class LC_56 {
    public int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int index = -1;
        for (int[] interval : intervals) {
            if (index == -1 || interval[0] > res[index][1]) {
                res[++index] = interval;
            } else {
                res[index][1] = Math.max(res[index][1], interval[1]);
            }
        }
        //Arrays.copyOf(T[] original, int newLength)
        return Arrays.copyOf(res, index+1);
    }

}
