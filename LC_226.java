package com.cheerway.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-23  20:01
 */
public class LC_226 {
    //递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        return root;
    }
    //迭代
    public TreeNode invertTree_1(TreeNode root) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }
}
