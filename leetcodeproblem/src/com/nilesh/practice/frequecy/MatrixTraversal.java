package com.nilesh.practice.frequecy;

import java.util.ArrayList;
import java.util.List;

public class MatrixTraversal {

   static int totalCount = 0;
   static List<Integer> allSum = new ArrayList<>();

    static  void traverseMatrix(int [][]a, int startRow, int startCol, int sum){
        int lastRow = a.length-1;
        int lastCol = a[0].length-1;
        //System.out.println(startRow +" "+ startCol +" ;;" +lastRow+" "+lastCol);
        if(startRow==lastRow && startCol==lastCol){
            sum = sum+a[startRow][startCol];
            totalCount++;
        }
        if(startRow<lastRow){
            sum = sum+a[startRow][startCol];
            traverseMatrix(a, startRow+1 , startCol, sum);
        }else{
            return;
        }
        if(startCol<lastCol){
            sum = sum+a[startRow][startCol];
            traverseMatrix(a, startRow , startCol+1, sum);
        }else{
            return;
        }
    }

    public static void main(String[] args) {
        int row = 3;
        int column = 7;

        int [][] a = new int[3][7];

        //traverseMatrix(a,0,0);


        int[][] grid = {{3, 7, 9, 2, 7},
                        {9, 8, 3, 5, 5},
                        {1, 7, 9, 8, 6},
                        {3, 8, 6, 4, 9},
                        {6, 3, 9, 7, 8}};

        int mat[][] = {{3, 7}, {9, 8}};



        System.out.println(totalCount);

    }
}
