package com.code.nil.preparation;

public class BSTDistance {

    static void insertBST(Node root, int n){

        if(n<root.data){
            if(root.left==null){
                root.left = new Node(n);
            }else{
                insertBST(root.left,n);
            }
        }else{
            if(root.right==null){
                root.right = new Node(n);
            }else{
                insertBST(root.right,n);
            }
        }
    }

    static Node getLCA(Node root, int a, int b){
        if(a< root.data && b<root.data){
            return getLCA(root.left,a,b);
        }else if(a> root.data && b>root.data){
            return getLCA(root.right,a,b);
        }else{
            return root;
        }
    }

    static int getDistance(Node root, int a){
      if(root.data== a){
          return 0;
      }else if(root.data > a){
          return 1+ getDistance(root.left, a);
      }else {
          return 1+ getDistance(root.right, a);
      }
    }

    public static void main(String[] args) {

       /* root.left = new Node(2);
        root.right = new Node(12);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left=new Node(9);
        root.right.right = new Node(21);
        root.right.right.left = new Node(19);
        root.right.right.right = new Node(25);*/

        int [] input = {5,2,12,1,3,9,21,19,25};
        Node root = new Node(input[0]);
        for(int i=1; i<input.length; i++){
            insertBST(root,input[i]);
        }

        Node lca1 = getLCA(root,3,19);
        int dist11 = getDistance(lca1, 3);
        int dist12 = getDistance(lca1, 19);

        Node lca2 = getLCA(root,9,19);

        int dist21 = getDistance(lca2, 9);
        int dist22 = getDistance(lca2, 19);

        System.out.println("");
    }
}
