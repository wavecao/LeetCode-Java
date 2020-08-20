package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-18  20:50
 */
public class LC_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int n = nums.length - 1;
        return dfs(nums, 0, n);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        //数组有序，所以中间的数就是二叉搜索树的根节点
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        //递归构建左右子树
        root.left = dfs(nums, left, mid-1);
        root.right = dfs(nums, mid+1, right);
        return root;
    }
}
