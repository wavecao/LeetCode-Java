package com.cheerway.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-08-17  21:54
 */
public class LC_110 {

    /**
     * <pre>
     * 思路是对二叉树做先序遍历，从底至顶返回子树最大高度，若判定某子树不是平衡树则 “剪枝” ，直接向上返回。
     *
     * 算法流程：
     * recur(root):
     *   递归返回值：
     *      1. 当节点root左/右子树的高度差 <2 ：则返回以节点root为根节点的子树的最大高度，
     *      即节点 root 的左右子树中最大高度加1（ max(left, right) + 1 ）；
     *      2. 当节点root左/右子树的高度差2≥2 ：则返回−1,代表此子树不是平衡树 。
     *   递归终止条件：
     *      1. 当越过叶子节点时，返回高度 0；
     *      2. 当左（右）子树高度 left== -1 时，代表此子树的 左（右）子树 不是平衡树，因此直接返回−1 ；
     * isBalanced(root) ：
     *   返回值： 若 recur(root) != 1 ，则说明此树平衡，返回 true ； 否则返回 false 。
     *
     * 复杂度分析：
     *    时间复杂度 O(N)O(N)： NN 为树的节点数；最差情况下，需要递归遍历树的所有节点。
     *    空间复杂度 O(N)O(N)： 最差情况下（树退化为链表时），系统递归需要使用 O(N)O(N) 的栈空间
     *</pre>
     */
    public boolean isBalanced_1(TreeNode root) {
        return recur(root) == -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return left;
        int right = recur(root.right);
        if (right == -1) return right;

        return Math.abs(right-left) >= 2 ? -1 : Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
