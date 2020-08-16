package com.cheerway.leetcode;

import java.util.HashMap;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-03  22:11
 */
public class LC_1 {
    public int[] twoSum_1(int[] nums, int target) {
        // [2,7,11,15]
        int[] index = new int[2];
        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                index[0] = hash.get(nums[i]);
                index[1] = i;
                return index;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        return index;
    }

    /**
     * 输入：
     * [3,2,4]
     * 6
     * 输出：
     * [-1,-1]
     * 预期结果：
     * [1,2]
     *
     * 因为数组无序，可能会出现错过的情况！！！！！！
     */
    public int[] twoSum_2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i);
        }
    }
}
