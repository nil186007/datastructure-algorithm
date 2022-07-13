package com.code.nil.preparation.striver.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class FrequencyStack {

    Map<Character, Integer> charToFreq = new HashMap<>();
    Map<Integer, Deque<Character>> freqToChar = new HashMap<>();

    int highestFrequency = 0;

    void push(char i) {
        charToFreq.put(i, charToFreq.getOrDefault(i, 0) + 1);
        int currentFreq = charToFreq.get(i);

        Deque<Character> stack = freqToChar.getOrDefault(currentFreq, new ArrayDeque<>());
        stack.push(i);
        freqToChar.put(currentFreq, stack);
        if (currentFreq > highestFrequency) {
            highestFrequency = currentFreq;
        }
    }

    char pop() {
        Deque<Character> stack = freqToChar.get(highestFrequency);
        char output = stack.pop();
        charToFreq.put(output, charToFreq.get(output) - 1);
        if (stack.size() == 0) {
            freqToChar.remove(highestFrequency);
            highestFrequency--;
        }
        return output;
    }

}