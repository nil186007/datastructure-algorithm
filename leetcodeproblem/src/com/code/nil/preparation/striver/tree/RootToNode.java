package com.code.nil.preparation.striver.tree;

public class RootToNode {

    public static void getPath(TreeNode root, int val, String tempPath) {
        if (root == null) return;
        tempPath = tempPath + "->" + root.val;
        if (root.val == val) {
            System.out.println(tempPath);
            return;
        }
        getPath(root.left, val, tempPath);
        getPath(root.right, val, tempPath);
        if (!tempPath.contains("->")) {
            tempPath.substring(0, tempPath.indexOf("->"));
        }
    }

    public static TreeNode findLCA(TreeNode root, int a, int b) {
        if (root == null) return null;
        if (root.val == a || root.val == b) return root;

        TreeNode left = findLCA(root.left, a, b);
        TreeNode right = findLCA(root.right, a, b);

        if (left != null && right != null) return root;
        else if (left == null && right != null) return right;
        else if (left != null && right == null) return left;
        else return null;
    }

    public static int getHeight(TreeNode node) {
        if (node == null) return 0;

        int lh = getHeight(node.left);
        int rh = getHeight(node.right);

        return Math.max(lh, rh) + 1;
    }

    public static int getDiameter(TreeNode node, int[] diameter) {
        if (node == null) return 0;

        int lh = getDiameter(node.left, diameter);
        int rh = getDiameter(node.right, diameter);

        diameter[0] = Math.max(diameter[0], lh + rh);

        return Math.max(lh, rh) + 1;
    }

    public static int isBalanced(TreeNode root) {
        if (root == null) return 0;

        int lh = isBalanced(root.left);
        if (lh == -1) return -1;
        int rh = isBalanced(root.right);
        if (rh == -1) return -1;

        if (Math.abs(lh - rh) > 1) return -1;
        return 1 + Math.max(lh, rh);
    }

    static int max_level = 0;
    public static void getLeftView(TreeNode root, int level){
        if(root==null) return;
        if(max_level<level){
            System.out.println(root.val);
            max_level = level;
        }
        getLeftView(root.left, level+1);
        getLeftView(root.right, level+1);
    }



    public static void main(String[] args) {
        //       1
        //   2        3
        //4      5  6       7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);

        //getPath(root,6, "");
        //System.out.println(paths);

        TreeNode lca = findLCA(root, 7, 6);
        System.out.println(lca.val);

        System.out.println(getHeight(root));
        int[] dia = new int[1];
        getDiameter(root, dia);
        System.out.println(dia[0]);

        System.out.println(isBalanced(root));

    }
}
