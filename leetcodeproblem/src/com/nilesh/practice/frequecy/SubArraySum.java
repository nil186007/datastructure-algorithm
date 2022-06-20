package com.nilesh.practice.frequecy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArraySum {

    static void findSubArraySum(int [] a, int sum){

        List<String> ranges = new ArrayList<>();
        Map<Integer,Integer> currentSumToIndexMap = new HashMap<>();

        int currentSum = 0;
        for(int i=0; i<a.length; i++){
            currentSum+=a[i];
            if(currentSum==sum){
                ranges.add(0+"-"+i);
            }
            currentSumToIndexMap.put(currentSum,i);
            Integer end = currentSumToIndexMap.get(currentSum-sum);
            if(end!=null){
                ranges.add(end+1+"-"+i);
            }
        }
        System.out.println(ranges);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        findSubArraySum(a,3);
    }
}
