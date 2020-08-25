package com.cheerway.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-25  21:22
 */
public class LC_491 {
    // 定义全局变量保存结果
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        // idx 初始化为 -1，开始 dfs 搜索。
        dfs(nums, -1, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int idx, ArrayList<Integer> list) {
        if (list.size() > 1) {
            res.add(new ArrayList<>(list));
        }

        Set<Integer> set = new HashSet<>();
        for (int i = idx + 1; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            if (idx == -1 || nums[i] >= nums[idx]) {
                list.add(nums[i]);
                dfs(nums, i, list);
                list.remove(list.size()-1);
            }
        }
    }
}
