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
 * @since : 2020-08-11  20:06
 */
public class LC_94 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        help(root);
        return res;
    }

    private void help(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                help(root.left);
            }
            res.add(root.val);
            if (root.right != null) {
                help(root.right);
            }
        }
    }

    public List<Integer> inorderTraversal_1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

}
