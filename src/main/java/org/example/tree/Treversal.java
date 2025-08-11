package org.example.tree;

import java.util.*;

public class Treversal {
    public static class TreeNode {
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

    //层序
    public List<List<Integer>>  layerTraversal(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int count = que.size();
            for(int i = 0; i < count; i++){
                TreeNode poll = que.poll();
                temp.add(poll.val);
                if(poll.left != null) que.add(poll.left);
                if(poll.right != null) que.add(poll.right);
            }
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        //  [3,9,20,null,null,15,7]
        //      3
        //     / \\
        //    9  20
        //      /  \\
        //     15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Treversal treversal = new Treversal();
        List<List<Integer>> result = treversal.layerTraversal(root);

        System.out.println("Layer Traversal Result: " + result);
    }

    // 前序遍历顺序：中-左-右，入栈顺序：中-右-左
    class Solution1 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.right != null){
                    stack.push(node.right);
                }
                if (node.left != null){
                    stack.push(node.left);
                }
            }
            return result;
        }
    }

    // 中序遍历顺序: 左-中-右 入栈顺序： 左-右
    class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while(cur != null || !stack.isEmpty()){
                if(cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }else{
                    TreeNode pop = stack.pop();
                    result.add(pop.val);
                    cur = pop.right;
                }
            }
            return result;
        }
    }

    // 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
    class Solution3 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.left != null){
                    stack.push(node.left);
                }
                if (node.right != null){
                    stack.push(node.right);
                }
            }
            Collections.reverse(result);
            return result;
        }
    }
}
