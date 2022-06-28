package com.code.nil.preparation.striver.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextBigElementInArray {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4,};

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> elementToNextBigElement = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            while ( !stack.isEmpty() && stack.peek() < a[i] ) {
                elementToNextBigElement.put(stack.pop(), a[i]);
            }
            stack.push(a[i]);
        }
        while(!stack.isEmpty()){
            elementToNextBigElement.put(stack.pop(), -1);
        }
        System.out.println(elementToNextBigElement);
    }
}
