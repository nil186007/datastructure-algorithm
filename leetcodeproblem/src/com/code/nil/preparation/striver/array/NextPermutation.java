package com.code.nil.preparation.striver.array;

public class NextPermutation {

    public static void main(String[] args) {

        int [] a = {1,5,8,4,7,6,5,3,1};

        int k = -1;

        //find index of first element where a[i]<a[i+1] from right
        for(int i= a.length-2; i>=0; i--){
            if(a[i]<a[i+1]){
                k=i;
                break;
            }
        }

        if(k==-1){
            reverse(a,0,a.length-1);
            return;
        }
 // find the first eklement greater than a[k] from right and swap it
        for(int i = a.length-1; i>=k; i--){
            if(a[i]>a[k]){
                swap(a, i , k);
                break;
            }
        }
    // reverse the array after K
        reverse(a, k+1, a.length-1);
        System.out.println(k);
    }

    private static void reverse(int[] a, int i, int j) {
        while(i<j){
            swap(a,i,j);
            i++;
            j--;
        }
    }

    private static void swap(int[] a, int i, int k) {
        int temp = a[i];
        a[i]=a[k];
        a[k]=temp;
    }
}
