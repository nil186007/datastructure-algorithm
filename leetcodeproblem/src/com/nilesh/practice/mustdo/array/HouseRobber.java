package com.nilesh.practice.mustdo.array;


import com.code.nil.preparation.striver.tree.TreeNode;

public class HouseRobber {

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int houseRobber(int [] a){

        int t1=0;
        int t2=0;

        for(int i=0; i<a.length; i++){
            int temp = t1;
            int current  = a[i];
            t1 = Math.max(current+t2, t1);
            t2=temp;
        }
        return t1;
    }

    public static Pair HouseRobberTree(TreeNode node){

        if(node == null ) return new Pair(0,0);

        Pair sum1 = HouseRobberTree(node.left);
        Pair sum2 = HouseRobberTree(node.right);

        Pair sum = new Pair(0,0);
        sum.first = sum1.second+ sum2.second+ node.val;
        sum.second = Math.max(sum1.first, sum1.second) + Math.max(sum2.first, sum2.second);
        return sum;
    }
















    public static void main(String[] args) {

        int[] a = {2, 7, 9, 3, 1, 8};

        int t1 = 0;
        int t2 = 0;

        for (int i = 0; i < a.length; i++) {
            int temp = t1;
            int current = a[i];
            t1 = Math.max(current + t2, t1);
            t2 = temp;
        }

        System.out.println(t1);
    }




}


