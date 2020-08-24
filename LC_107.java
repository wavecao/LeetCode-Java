package com.cheerway.leetcode;

import java.util.*;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-22  22:07
 */
public class LC_107 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            //for循环相当于把每一层的n个一次遍历完
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(0, level);
        }
        return res;
    }

    public static void main(String[] args) {
        Integer a = new Integer(5);
        Integer b = new Integer(5);
        System.out.println(a == b); // false
        System.out.println(a.equals(b));

    }
}
