package com.nilesh.practice.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        Deque<Long> buffer = new ArrayDeque<>();
        buffer.offer(1l);
        buffer.offer(2l);
        buffer.offer(3l);

        System.out.println(buffer.peek());
        System.out.println(buffer.getLast());
        System.out.println(buffer.poll());
        System.out.println(buffer);
    }

}
