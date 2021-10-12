package com.nilesh.practice.tree;

public class SymmetricTree {

    public static boolean isSymmetricTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        } else {
            return isSameTree(root.left, root.right);
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null) || (p.val != q.val)) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    public static void main(String[] args) {

    }
}
