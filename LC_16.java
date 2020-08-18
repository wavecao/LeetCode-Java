package com.cheerway.leetcode;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-16  21:37
 */
public class LC_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left, right;
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; ++i) {
            left = i + 1;
            right = nums.length - 1;
            while(left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                if (threeSum == target) {
                    return target;
                } else if (Math.abs(threeSum - target) < Math.abs(closest - target)){
                    closest = threeSum;
                } else if (threeSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closest;
    }
}
