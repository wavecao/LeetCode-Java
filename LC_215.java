package com.cheerway.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-09  22:20
 */
public class LC_215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public int findKthLargest_1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                //检索返回并删除队列的头，每次弹出的时队列头即最小的值，保证队列中只有k个元素
                //那么队列头就是第k大的值
                heap.poll();
            }
        }
        //检索返回但是不删除队列的头
        return heap.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        new LC_215().findKthLargest_1(nums, k);
    }
}
