package com.code.nil.preparation;

import java.util.HashMap;

public class SubarraySum {

    public static void main(String[] args) {
        int [] a = {1,2,3,4,5,6,7,8,4};

        int sum = 12;

        HashMap<Integer, Integer> prefixSumToIndex = new HashMap<>();

        int prefixSum = 0;
        int start = 0;
        int end = 0;
        for(int i=0; i<a.length; i++){
            prefixSum +=a[i];
            prefixSumToIndex.put(prefixSum,i);
            if(prefixSumToIndex.get(prefixSum-sum) !=null){
                start = prefixSumToIndex.get(prefixSum-sum)+1;
                end = i;
            }
        }

        System.out.println(start + " : " + end);
    }

}
