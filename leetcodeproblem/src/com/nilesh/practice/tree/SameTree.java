package com.nilesh.practice.tree;

public class SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        if ((p==null && q!=null) ||(p!=null && q==null) || (p.val != q.val)) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    public static void main(String[] args) {

        TreeNode first = new TreeNode(1);
        first.left=new TreeNode(2);
        first.right = new TreeNode(3);

        TreeNode second = new TreeNode(1);
        second.left=new TreeNode(2);
        second.right = new TreeNode(3);

        System.out.println(isSameTree(first,second));
    }
}
