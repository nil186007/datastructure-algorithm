package com.code.nil.preparation;

public class LCA {

    public static Node getLCA(Node root, int a, int b){

        if(root== null || root.data ==a || root.data == b){
            return root;
        }

        Node leftLCA = getLCA(root.left,a,b);
        Node rigtLCA = getLCA(root.right,a,b);

        if(leftLCA!=null && rigtLCA!=null){
            return root;
        }else if(leftLCA==null && rigtLCA!=null){
            return rigtLCA;
        }else if(leftLCA!=null && rigtLCA==null){
            return leftLCA;
        }else{
            return null;
        }

    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(12);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left=new Node(9);
        root.right.right = new Node(21);
        root.right.right.left = new Node(19);
        root.right.right.right = new Node(25);

        Node result = getLCA(root, 3,19);
        System.out.println(result.data);
    }
}
