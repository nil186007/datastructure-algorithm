package com.code.nil.preparation.striver.binarysearch;

public class MedianSortedArray {

    public static double findMedian(int [] a, int [] b){
        int left = 0;
        int right = a.length;
       // {1,6,\8,9}
       // {2,4,\5,10}
        while(left<=right){
            int cut1 = (left+right)/2;
            int cut2 = ((a.length+b.length+1)/2) - cut1;
            int aLeft = cut1==0?Integer.MIN_VALUE : a[cut1-1];
            int bLeft = cut2==0?Integer.MIN_VALUE : b[cut2-1];
            int aRight = cut1==a.length? Integer.MAX_VALUE:a[cut1];
            int bRight = cut2==b.length? Integer.MAX_VALUE:b[cut2];
            if(aLeft<bRight && bLeft<aRight){
                if(a.length == b.length){
                    return (Math.max(aLeft,bLeft) + Math.min(aRight,bRight))/2.0;
                }else {
                    return Math.max(aLeft,bLeft)/1.0;
                }
            }else if (aLeft>bRight){
                right=cut1-1;
            }else{
                left=cut1+1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int [] a = {1};

        int [] b = {2};

        System.out.println(findMedian(a,b));

    }
}
