package com.code.nil.preparation.striver.array;

import java.util.Arrays;
import java.util.Comparator;

public class MergeOverLappingSubIntervals {

    public static void main(String[] args) {
        int [] [] input  = {{1,3},{8,10},{7,11},{2,6},{15,18}};

       Arrays.sort(input, Comparator.comparingInt(a -> a[1]));

        int [] [] result = new int[input.length][2];
        int m = 0;

       for(int i=0; i<input.length; i++){
           if(i<input.length-1 && input[i+1][0]<input[i][1] && input[i][1]<input[i+1][1]){
               result[m][0]  = Math.min(input[i][0],input[i+1][0]);
               result[m][1]  = Math.max(input[i][1],input[i+1][1]);
               m++;
               i++;
           }else{
               result[m][0]  = input[i][0];
               result[m][1]  = input[i][1];
               m++;
           }
       }

        System.out.println(result);
    }


}
