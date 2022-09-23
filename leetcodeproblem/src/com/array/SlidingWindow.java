package com.array;

import java.util.*;

public class SlidingWindow {


    public static int longestSubstringUniqueChar(String  s){
        int lenght = 0;
        int left=0;
        int right=0;
        Set<Character> seen = new HashSet<>();
        while(right<s.length()){
            if(!seen.contains(s.charAt(right))){
                seen.add(s.charAt(right));
                right++;
            }else{
                seen.remove(s.charAt(left));
                left++;

            }
            if(right-left > lenght){
                lenght = right-left;
            }
        }
        return lenght;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = k-1;

        int max = 0;

        int [] output = new int[nums.length-k+1];

        for(int i=0; i<k; i++){
            max = Math.max(max, nums[i]);
        }
        //output[0] = max;
        max=0;
       // while(right<nums.length){

       // }


        for(int i=0; i<=nums.length-k;i++){
            for(int j=i; j<i+k; j++){
                output[i] =Math.max(output[i], nums[j]);
            }
        }

        return output;
    }

    /*Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

    The testcases will be generated such that the answer is unique.

    A substring is a contiguous sequence of characters within the string.*/



    public String minWindow(String s, String t) {

        int left=0;
        int right =0;

        Map<Character, Integer> testStringMap = new HashMap<>();
        for(int i=0 ; i < t.length(); i++){
            Integer freq = testStringMap.get(t.charAt(i));
            if(freq == null){
                testStringMap.put(t.charAt(i),1);
            }else{
                testStringMap.put(t.charAt(i),freq+1);
            }
        }
        return "";
       // return -1;

    }


    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(longestSubstringUniqueChar(s));

        int [] nums = {1,3,-1,-3,5,3,6,7};
       int[] res =  maxSlidingWindow( nums, 3);

        Arrays.stream(res).forEach(System.out::println);
    }
}
