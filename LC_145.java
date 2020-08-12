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
 * @since : 2020-08-11  20:21
 */
public class LC_145 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return res;

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);

        return res;
    }

    LinkedList<Integer> ress = new LinkedList<>();
    public List<Integer> postorderTraversal_1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                ress.addFirst(root.val);
                root = root.right;
            } else {
                root = stack.pop();
                root = root.left;
            }
        }
        return ress;
    }

}
