package com.cheerway.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-01  21:29
 */
public class Sunsets_78 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) return res;
        backtrack(0, nums, new ArrayList<>());
        return res;
    }

    private void backtrack(int start, int[] nums, ArrayList<Integer> track) {
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(i+1, nums, track);
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {
        new Sunsets_78().subsets(new int[]{1,2,3});
    }
}
