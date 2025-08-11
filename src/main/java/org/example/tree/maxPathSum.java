package org.example.tree;

import org.example.tree.Treversal.TreeNode;

public class maxPathSum {
    int sum = 0;
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        search(root);
        return max;
    }
    public void search(TreeNode root){
        if(root == null) return;
        search(root.left);
        search(root.right); 
        sum = 0;
        frontDfs(root);
    }
    public void frontDfs(TreeNode root){
        if(root == null) return;
        sum += root.val;
        max = Math.max(max, sum);
        frontDfs(root.left);
        frontDfs(root.right);
        sum -= root.val;
    }
    public int dfs2(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0, dfs2(root.left));
        int right = Math.max(0, dfs2(root.right));
        int startPOint = Math.max(left, right) + root.val;
        int cornerPOint = left+right+root.val;
        max = Math.max(max, Math.max(startPOint, cornerPOint));
        return Math.max(left, right) + root.val;
    }

}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        treversal(root, targetSum);
        return count / 2;
    }
    public void treversal(TreeNode root, int targetSum){
        if(root == null) return;
        treversal(root.left, targetSum);
        find(root, 0, targetSum, false);
        treversal(root.right, targetSum);
    }
    public void find(TreeNode root, long sum, int targetSum, boolean star){
        if(sum == targetSum && star) count++;
        if(root == null) return;
        find(root.left, sum + root.val, targetSum, true);
        find(root.right, sum + root.val, targetSum, true);
    }
}