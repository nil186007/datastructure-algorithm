package com.code.nil.preparation.striver.tree;

import java.util.*;

public class LevelOdertraversals {

    public static List<List<Integer>> spiraltraversal(TreeNode node) {
        List<List<Integer>> arrayList = new ArrayList<>();
        if (node == null) return arrayList;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        boolean flag = Boolean.TRUE;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);

                if (flag) subList.add(queue.poll().val);
                else subList.add(0, queue.poll().val);
            }
            flag = !flag;
            arrayList.add(subList);
            System.out.println();
        }
        return arrayList;
    }

    public static void iterativeInorderTraversal(TreeNode root) {

        if (root == null) {
            return;
        }
        Deque<TreeNode> nodes = new ArrayDeque<>();
        TreeNode currentNode = root;
        while (!nodes.isEmpty() || currentNode!=null) {
           if(currentNode !=null){
               nodes.push(currentNode);
               currentNode = currentNode.left;
           }else{
               currentNode = nodes.pop();
               System.out.println(currentNode.val);
               currentNode = currentNode.right;
           }
        }
    }

    public static void iterativePreOrderTraversal(TreeNode root) {

        if (root == null) {
            return;
        }
        Deque<TreeNode> nodes = new ArrayDeque<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            TreeNode currentNode = nodes.pop();
            System.out.println(currentNode.val);
            if(currentNode.right!=null) nodes.push(currentNode.right);
            if(currentNode.left!=null) nodes.push(currentNode.left);
        }
    }

    private void postOrderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while(true) {
            while(root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }
            // Check for empty stack
            if(stack.empty()) return;
            root = stack.pop();

            if(!stack.empty() && stack.peek() == root) root = root.right;

            else {

                System.out.print(root.val + " ");
                root = null;
            }
        }
    }


    //              1
    //        2             3
    //    4       5     6       7
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        //System.out.println(spiraltraversal(root));
        //iterativePostOrderTraversal(root);
    }
}
