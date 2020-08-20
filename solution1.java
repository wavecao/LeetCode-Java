package com.cheerway.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-20  20:56
 */
public class solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] computers = new int[n];
        int[][] customs = new int[m][2];
        for (int i = 0; i < n; i++) {
            computers[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            customs[i][0] = in.nextInt();
            customs[i][1] = in.nextInt();
        }
        Arrays.sort(computers);
        Arrays.sort(customs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int money = 0;
        boolean[] isUsed = new boolean[n];
        Arrays.fill(isUsed, false);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[j] >= customs[i][0] && !isUsed[j]) {
                    money += customs[i][1];
                    isUsed[j] = true;
                }
            }
        }
        System.out.println(money);
    }
}
