package com.graph;

public class DisjointSet {

    public int[] disjointSet;

    public DisjointSet(int size) {
        disjointSet = new int[size];
        for(int i=0; i<size; i++){
            disjointSet[i]=i;
        }
    }
 //quick find to find root
    public int quickFind(int element) {
        //each element has root
        return disjointSet[element];
    }

 //slow find
    public int slowFind(int a){
        if(disjointSet[a] == a){
            return disjointSet[a];
        }else {
            //search till index and value are same
            return slowFind(disjointSet[a]);
        }
    }

//o(N) union
    public void slowUnion(int a, int b) {
        int rootA = quickFind(a);
        int rootB = quickFind(b);
        if (rootA != rootB) {
            for (int i = 0; i < disjointSet.length; i++) {
                if (disjointSet[i] == rootB) {
                    disjointSet[i] = rootA;
                }
            }
        }
    }

    //quick union
    public void quickUnion(int a, int b) {
        int rootA = slowFind(a);
        int rootB = slowFind(b);
        // just change the root of B
        if(rootA != rootB){
            disjointSet[b] = rootA;
        }
    }

    public boolean isConnected(int a, int b) {
        return quickFind(a) == quickFind(b);
    }

    public static void main(String[] args) {

        DisjointSet uf = new DisjointSet(10);
        // 1-2-5-6-7 3-8-9 4
        uf.slowUnion(1, 2);
        uf.slowUnion(2, 5);
        uf.slowUnion(5, 6);
        uf.slowUnion(6, 7);
        uf.slowUnion(3, 8);
        uf.slowUnion(8, 9);
        System.out.println(uf.isConnected(1, 5)); // true
        System.out.println(uf.isConnected(5, 7)); // true
        System.out.println(uf.isConnected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.slowUnion(9, 4);
        System.out.println(uf.isConnected(4, 9)); // true


    }
}
