package com.code.nil.preparation.goldman;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AllPathGrid {

    static  List<String> fullPath = new ArrayList<>();

    public static void findAllPath(int [][] a, int row, int col, String currentPath){

        currentPath = currentPath +","+row+"-"+col ;
        if(row == a.length-1 &&  col == a[0].length-1){
            fullPath.add(currentPath);
            return;
        }else if (row >= a.length ||  col >= a[0].length){
            currentPath.substring(0,currentPath.lastIndexOf(","));
            return;
        }else {
            findAllPath(a, row + 1, col, currentPath);
            findAllPath(a, row, col + 1, currentPath);
        }

    }

    public static void main(String[] args) {
        int [][] a = new int[3][2];
        findAllPath(a,0,0,"");

        System.out.println(fullPath);
    }
}
