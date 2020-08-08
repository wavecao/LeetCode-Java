package com.cheerway.leetcode;

import java.util.*;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-01  19:31
 */
public class CombinationSum_39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;

        Arrays.sort(candidates);
        dfs(candidates, len, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    /**
     * @param candidates 数组输入
     * @param len        输入数组的长度，冗余变量
     * @param residue    剩余数值
     * @param begin      本轮搜索的起点下标
     * @param path       从根结点到任意结点的路径
     * @param res        结果集变量
     */
    private static void dfs(int[] candidates,
                     int len,
                     int residue,
                     int begin,
                     Deque<Integer> path,
                     List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(path));
        }

        for (int i = begin; i < len; i++) {
            if (residue < candidates[0]) {
                break;
            }
            path.addLast(candidates[i]);
            dfs(candidates, len, residue-candidates[i], i, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        combinationSum(candidates, 7);
    }
}
