package com.code.nil.preparation.striver.stack;


public class StackMaximumFrequency {

    public static void main(String[] args) {

        char[] input = {'a', 'b', 'c', 'a', 'a', 'c', 'b'};

        FrequencyStack s = new FrequencyStack();
        s.push('a');
        s.push('b');
        s.push('c');
        s.push('a');
        s.push('a');
        s.push('b');
        s.push('b');
        System.out.println(s.pop());
    }
}
