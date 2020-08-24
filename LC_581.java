package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-23  21:05
 */
public class LC_581 {


    /**
     * <pre>
     * 寻找右边界：
     * 从前往后遍历的过程中，用max记录遍历过的最大值，如果max大于当前的nums[i]，说明nums[i]的位置不正确，
     * 属于需要排序的数组，因此将右边界更新为i，然后更新max；这样最终可以找到需要排序的数组的右边界，右边界之后的元素都大于max；
     * 寻找左边界：
     * 从后往前遍历的过程中，用min记录遍历过的最小值，如果min小于当前的nums[j]，说明nums[j]的位置不正确，
     * 应该属于需要排序的数组，因此将左边界更新为j，然后更新min；这样最终可以找到需要排序的数组的左边界，左边界之前的元素都小于min；
     *
     * 右边界的定义：右边界的左边一定存在一个比右边界大的数，导致它不配在右边界这个位置；
     * 左边界的定义：左边界的右边一定存在一个比左边界小的数，导致它不配在左边界这个位置。
     * </pre>
     */
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int min = nums[len-1];
        int l = 0, r = -1;
        for(int i=0;i<len;i++){
            if(max>nums[i]){
                r = i;
            }else{
                max = nums[i];
            }
            if(min<nums[len-i-1]){
                l = len-i-1;
            }else{
                min = nums[len-i-1];
            }
        }
        return r-l+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        //findUnsortedSubarray(nums);
    }
}
