package org.example.tree;

// LeetCode 104. 二叉树的最大深度
// 递归计算左右子树深度
public class MaxDepth {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
