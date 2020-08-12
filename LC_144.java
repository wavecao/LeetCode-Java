package com.cheerway.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-11  19:14
 */
public class LC_144 {

    /* 递归法 */
    private List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return res;
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }

    /* 迭代法 */
    public List<Integer> preorderTraversal_1 (TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        if (root == null) return res;

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            res.add(node.val);
            //把右节点先压入栈则可以保证后遍历到右节点，符合前序遍历：根->左->右 的顺序
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return res;
    }
}
