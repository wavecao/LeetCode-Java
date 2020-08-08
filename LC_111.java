package com.cheerway.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-07  21:12
 */
public class LC_111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                assert node != null;
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
