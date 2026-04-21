package org.example.daily;
public class Extra_InvertBinaryTree_20260421_01 {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}