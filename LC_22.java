package com.cheerway.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-02  20:09
 */
public class LC_22 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n <= 0) return res;
        backtrack(n, n, new StringBuilder());
        return res;
    }

    private void backtrack(int left, int right, StringBuilder stringBuilder) {
        if (left > right) return;
        if (left < 0 || right < 0) return;
        if (left == 0 && right == 0) {
            res.add(stringBuilder.toString());
            return;
        }
        stringBuilder.append('(');
        backtrack(left-1, right, stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        stringBuilder.append(')');
        backtrack(left, right-1, stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
    }

    //SynchronousQueue
}
