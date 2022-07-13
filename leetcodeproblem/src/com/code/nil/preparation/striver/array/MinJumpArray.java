package com.code.nil.preparation.striver.array;

public class MinJumpArray {

    public static void main(String[] args) {

        int [] array = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

        int farthest = 0;
        int jump = 0;
        int currentFarthest = 0;
        for(int i = 0 ; i< array.length; i++){

            farthest = Math.max(farthest, i+array[i]);

            System.out.println(farthest);

            if(i == currentFarthest && farthest<array.length){
                jump++;
                currentFarthest = farthest;
            }

        }
        System.out.println(jump);


    }
}
