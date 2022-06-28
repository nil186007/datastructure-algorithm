package com.code.nil.preparation.striver.array;

import java.util.Arrays;

public class SortArray012 {

    public static void main(String[] args) {

        int arr[] = {2,0,2,1,1,0};
        int first =0;
        int last = arr.length-1;
        int mid = 0;

        while (mid<=last){
            if(arr[mid] == 0) {
                swap(arr,first, mid);
                first++;
                mid++;
            }
            if(arr[mid]==1){
                mid++;
            }
            if(arr[mid] == 2){
                swap(arr,mid,last);
                last--;
            }
        }

        System.out.println(Arrays.asList(arr));
    }

    static void swap(int [] a, int i , int j){

        int temp = a[i];
        a[i] = a[j];
        a[j]= temp;

    }
}
