package com.cheerway.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-22  21:55
 */
public class LC_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepth_1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int res = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                //因为队列中出队了一个节点
                size--;
            }
            //遍历完了一层，所以res++;
            res++;
        }
        return res;
    }
}
