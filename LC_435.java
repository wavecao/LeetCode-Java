package com.cheerway.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-09  16:02
 */
public class LC_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int length = intervals.length;
        if (length == 0) return 0;
        int count = 1;
        //按照区间的end升序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int end = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                count++;
                end = interval[1];
            }
        }
        return length-count;
    }
}
