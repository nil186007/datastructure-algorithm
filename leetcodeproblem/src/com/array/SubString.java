package com.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubString {

    public static int uniqueLetterString(String s) {
        Map<Character, List<Integer>> charPositions = new HashMap<>();

        int n = s.length();

        for(int i=0;i<s.length();i++) {
            charPositions.computeIfAbsent(s.charAt(i), key-> new ArrayList<>()).add(i);
        }
        System.out.println(charPositions);

        //     LEETCODE
        // check each character can be part of how many subsString
        // ea
        int result = 0;
        for(List<Integer> index: charPositions.values()) {
            for(int i=0;i<index.size();i++) {
                int left = i==0 ? index.get(i) + 1 : index.get(i) - index.get(i-1);
                System.out.print (left + " ");
                int right = i==index.size()-1 ? n - index.get(i): index.get(i+1) - index.get(i);
                System.out.print (right + " ");
                result += left * right;
                System.out.println(result);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(uniqueLetterString("LEETCODE"));
    }
}
