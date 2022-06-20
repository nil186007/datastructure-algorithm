package com.nilesh.practice.mustdo.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class FindNextLargerElement {

    public static void main(String[] args) {
        int [] arr = {1,3,2,4};
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> result = new HashMap<>();

        for(int i=0; i< arr.length; i++){
            while(!stack.isEmpty() && stack.peek()<arr[i]){
                result.put(stack.pop(), arr[i]);
            }
            stack.push(arr[i]);
        }
        while(!stack.isEmpty()){
            result.put(stack.pop(), -1);
        }
        System.out.println(result);
    }
}
