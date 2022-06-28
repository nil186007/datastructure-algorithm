package com.code.nil.preparation.striver.binarysearch;


//{1,1,2,2,3,4,4,5,5}
public class SingleElementInSortedArray {

    public static void main(String[] args) {
        int [] a = {1,1,2,2,3,4,4,5,5};

        int val = 0;
        for(int i= 0; i<a.length; i++){
            val ^= a[i];
        }
        System.out.println(val);
        System.out.println(findSingle(a));
    }
    //{1,1,3,3,4,5,5,6,6}
    public static int findSingle(int [] a){
        int left = 0;
        int right = a.length-2;
        while(left<=right){
           int mid = (left+right)/2;

           if(mid%2 == 0){
               if(a[mid]!=a[mid+1]){
                   right = mid-1;
               }else{
                   left = mid+1;
               }
           }else{
                if(a[mid]==a[mid+1]){
                    right= mid-1;
                }else{
                    left = mid+1;
                }
           }

        }
        return a[left];
    }

}
