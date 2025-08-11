package org.example.tree;

import java.util.HashMap;
import java.util.Map;

public class PreInConstruct {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        PreInConstruct preInConstruct = new PreInConstruct();
        preInConstruct.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        twoSum(new int[]{3,3}, 6);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    public TreeNode construct(int[] preorder, int[] inorder, int s1, int e1, int s2, int e2){
        if(s1 > e1 || s2 > e2) return null;
        TreeNode root = new TreeNode(preorder[s1]);
        int in_dex = findIndex(inorder, root.val);
        int lenLeft = in_dex - s2;
        int lenRight = e2 - in_dex;
        root.left = construct(preorder, inorder, s1 + 1, s1 + lenLeft, s2, in_dex - 1);
        root.right = construct(preorder, inorder, s1 + lenLeft + 1, e1,
                in_dex + 1, e2);
        return root;
    }
    public int findIndex(int[] arr, int tar){
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == tar){
                index = i;
                break;
            }
        }
        return index;
    }



    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        treversal(root, targetSum);
        return count / 2;
    }
    public void treversal(TreeNode root, int targetSum){
        if(root == null) return;
        find(root, 0, targetSum, false);
        treversal(root.left, targetSum);
        treversal(root.right, targetSum);
    }
    public void find(TreeNode root, int sum, int targetSum, boolean star){
        if(sum == targetSum && star) count++;
        if(root == null) return;
        find(root.left, sum + root.val, targetSum, true);
        find(root.right, sum + root.val, targetSum, true);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
            int tar = target - nums[i];
            if(map.containsKey(tar) && i != map.get(tar)){
                result[0] = i;
                result[1] = map.get(tar);
                break;
            }
        }
        return result;
    }


}
