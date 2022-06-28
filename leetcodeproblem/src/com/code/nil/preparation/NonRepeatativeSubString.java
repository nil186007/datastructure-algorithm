package com.code.nil.preparation;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatativeSubString {

    public static void main(String[] args) {

        String input = "abcabcdeafg";

        int start = 0;
        int end = 0;
       Map<Integer,Integer> subStrings = new HashMap<>();

        Map<Character,Integer> repeatedChar = new HashMap<>();
        while(end<input.length()){
            Integer index = repeatedChar.get(input.charAt(end));
            if(index==null){
                repeatedChar.put(input.charAt(end), end);
                end++;
            }else{
                repeatedChar.clear();
                subStrings.put(start, end-1);
                start=end;
            }
        }

        subStrings.put(start,end);

        System.out.println(subStrings);
    }
}
