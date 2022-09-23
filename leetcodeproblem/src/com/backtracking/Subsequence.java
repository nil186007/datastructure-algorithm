package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subsequence {

    public static void printSubsequence(int index, int[] input, List<Integer> result) {

        if (index == input.length) {
            System.out.println(result);
            return;
        }
        result.add(input[index]);
        printSubsequence(index + 1, input, result);
        result.remove(result.size() - 1);
        printSubsequence(index + 1, input, result);
    }

    public static boolean isSubsequencePresentWithGivenSum(int index, int[] input, List<Integer> result, int targetSum) {

        if (index == input.length) {
            int sum = 0;
            for (int i = 0; i < input.length; i++) {
                sum += result.get(i);
            }
            if (targetSum == sum) {
                System.out.println(result);
                return true;
            } else return false;
        }

        result.add(input[index]);
        if (isSubsequencePresentWithGivenSum(index + 1, input, result, targetSum)) return true;
        result.remove(result.size() - 1);
        if (isSubsequencePresentWithGivenSum(index + 1, input, result, targetSum)) return true;

        return false;
    }

    public static int totalNumSubsequnceMatchingTargetSum(int index, int[] input, List<Integer> result, int targetSum) {

        if (index == input.length) {
            if (targetSum == result.stream().reduce(0, Integer::sum)) {
                System.out.println(result);
                return 1;
            } else return 0;
        }

        result.add(input[index]);
        int l = totalNumSubsequnceMatchingTargetSum(index + 1, input, result, targetSum);
        result.remove(result.size() - 1);
        int h = totalNumSubsequnceMatchingTargetSum(index + 1, input, result, targetSum);
        return l + h;
    }

    public static void combinationSum(int index, int[] input, int targetSum, List<Integer> result) {
        if (index == input.length) {
            if (targetSum == 0) {
                System.out.println(result);
            }
            return;
        }

        if (input[index] <= targetSum) {
            result.add(input[index]);
            combinationSum(index, input, targetSum - input[index], result);
            result.remove(result.size() - 1);
        }
        combinationSum(index + 1, input, targetSum, result);

    }

    public static void combinationSum2(int index, int [] input, int targetSum, List<Integer> dataStore){

        if(targetSum == 0){
            System.out.println(dataStore);
            return;
        }

        for(int i=index; i<input.length; i++){
            if(i>index && input[i] == input[i-1]) continue;
            if(input[index] > targetSum) break;

            dataStore.add(input[index]);
            combinationSum2(i+1, input, targetSum-input[index], dataStore);
            dataStore.remove(dataStore.size()-1);
        }
    }



    public static void permutation(int index, int [] array, List<Integer> eachSubset){
        if(index == array.length) {
           for(int i : array){
               System.out.print(i+" ");
           }
            System.out.println();
            return;
        }
        for(int i=index; i<array.length; i++){
            swap(array, i, index);
            permutation(index+1, array, eachSubset);
            swap(array, i, index);
        }
    }
    private static void swap(int[] array, int i, int index) {
        int temp = array[i];
        array[i] = array[index];
        array[index] = temp;
    }

    public static int allCombinationStairs(int steps, int remainingStairs ){

        if(remainingStairs == 0 ){
            //System.out.println(result);
            return 1;
        }

        int count = 0;
        for(int i=steps; i<=2; i++){
            if(remainingStairs >= steps) {
                //result.add(i);
                count +=allCombinationStairs(steps, remainingStairs-i);
                //result.remove(result.size()-1);
            }
        }
        return count;
    }



    public static void main(String[] args) {

        int[] input = {1,2,3};

        //permutation(0, input, new ArrayList<>());
        System.out.println(allCombinationStairs(1, 2));


        //int[] input = {3,2,1};
        List<Integer> result = new ArrayList<>();
        //printSubsequence(0, input,result);
        //isSubsequencePresentWithGivenSum(0, input, result,3);
        //System.out.println(totalNumSubsequnceMatchingTargetSum(0,input,result,3));

        /*int[] input = {2, 3, 6, 7};
        combinationSum(0, input, 7, result);

        Arrays.sort(input);
        combinationSum2(0,input,7, result);*/


    }
}
