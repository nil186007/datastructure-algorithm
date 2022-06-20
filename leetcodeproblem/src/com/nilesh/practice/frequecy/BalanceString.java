package com.nilesh.practice.frequecy;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalanceString {

   static class parenthesis{
        Character c;
        Integer index;

        public parenthesis(Character c, Integer index) {
            this.c = c;
            this.index = index;
        }

       @Override
       public String toString() {
           return "parenthesis{" +
                   "c=" + c +
                   ", index=" + index +
                   '}';
       }
   }

    public static void main(String[] args) {
        Deque <parenthesis> stack = new ArrayDeque();
        String input = "L(e)))et((co)d(e";
        for (int i=0; i<input.length(); i++){
            Character c = input.charAt(i);
            if(c=='('){
                stack.push(new parenthesis(c,i));
            }
            if(c==')'){
                if(stack.isEmpty() || stack.peek().c==')'){
                    stack.push(new parenthesis(c,i));
                }else {
                    stack.pop();
                }
            }
        }
        System.out.println(stack);


    }
}
