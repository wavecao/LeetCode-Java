package com.cheerway.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-01  21:04
 */
public class Combinations_77 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) return res;
        List<Integer> track = new ArrayList<>();
        backtrack(n, k, 1, new Stack<>());
        return res;
    }

    private void backtrack(int n, int k, int start, Stack<Integer> track) {
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, k, i+1, track);
            track.pop();
        }
    }
}
