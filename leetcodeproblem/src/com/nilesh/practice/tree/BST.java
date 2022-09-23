package com.nilesh.practice.tree;

public class BST {

    public boolean isBST(TreeNode root, TreeNode leftLimit, TreeNode rightLimit){

        if(root == null ) return true;
        if((leftLimit!=null && leftLimit.val>root.val)
                || (rightLimit!=null && rightLimit.val<root.val)) return false;
        return isBST(root.left, leftLimit, root) && isBST(root.right, root, rightLimit);

    }
}
