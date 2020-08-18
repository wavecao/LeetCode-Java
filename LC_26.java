package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-16  22:04
 */
public class LC_26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            //在遇到不相等的元素的时候，说明需要把这个元素往前挪
            if (nums[i] != nums[j]) {
                //首先把左指针右移一位，这就是num[j]需要挪到的位置
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
