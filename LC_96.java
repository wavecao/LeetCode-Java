package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-25  22:06
 */
public class LC_96 {
    //利用中序遍历，因为二叉搜索数的中序遍历应该是一个递增的序列
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        t1.left = t2;
        new LC_96().isValidBST(t1);
    }
}
