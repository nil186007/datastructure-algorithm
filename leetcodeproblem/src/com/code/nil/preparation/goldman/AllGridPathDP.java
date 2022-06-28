package com.code.nil.preparation.goldman;

import java.util.HashMap;
import java.util.Map;

public class AllGridPathDP {

    public static int getAllPath(int [][]a , int i, int j, Map<String, Integer> indexMap){

        if(a.length-1==i && a[0].length-1==j ){
            return 1;
        }
        if(i>=a.length || j>= a[0].length){
            return 0;
        }
        if (indexMap.get(i+","+j)!=null) {
            return indexMap.get(i+","+j);
        }
        int result = getAllPath(a,i+1, j , indexMap) + getAllPath(a,i, j+1 , indexMap);
        indexMap.put(i+","+j , result);
        return result;
    }

    public static void main(String[] args) {
        int [][] a = new int[3][3];
        getAllPath(a,0,0,new HashMap<>());

        System.out.println(getAllPath(a,0,0,new HashMap<>()));
    }
}
