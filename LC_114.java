package com.cheerway.leetcode;


/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-02  18:55
 */
public class LC_114 {
    TreeNode pre = null;
    public void flatten_1(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left != null) {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                //把左子树连接到原来右子树的位置
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    public void flatten_2(TreeNode root) {
        if (root == null) return;
        flatten_2(root.right);
        flatten_2(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode1.right = treeNode5;
        treeNode5.right = treeNode6;
        //new LC_114().flatten(treeNode1);
    }
}
