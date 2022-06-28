package com.code.nil.preparation.striver.array;

public class MaximumSumSubarrayKadanes {

    public static void main(String[] args) {
        //int [] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int[] arr = {  1};
        int maxSum = 0;
        int currentSum = 0;
        int start = 0;
        int tempStart = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum = currentSum + arr[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                end = i;
                if (tempStart > start) {
                    start = tempStart;
                }
            }
            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i+1;
            }
        }

        System.out.println("start index : " + start + " :: end index : " + end + " :: total sum : " + maxSum);
    }
}
