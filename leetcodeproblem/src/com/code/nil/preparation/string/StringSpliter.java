package com.code.nil.preparation.string;

import java.util.ArrayList;
import java.util.List;

public class StringSpliter {

    //abc abc abcd 3
    //abc
    //\sab
    //c\sa
    //bcd
    public List<String> splitString(String s, int length) {
        List<String> output = new ArrayList<>();
        String[] tokens = s.split(" ");
        String remainingOfLastToken = "";
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < tokens.length; i++) {
            line = new StringBuilder();
            if (!remainingOfLastToken.isEmpty()) {
                line.append(remainingOfLastToken);
            }
            line.append(tokens[i]);
            //line.append(" ");
            if (line.length() > length) {
                if (line.toString().contains(" ")) {
                    output.add(line.substring(0, line.lastIndexOf(" ") + 1));
                    i--;
                } else {
                    remainingOfLastToken = line.substring(length, line.length());
                    output.add(line.substring(0, length));
                }
            } else if (line.length() == length) {
                output.add(line.toString());
            }

        }
        output.add(line.toString());

       // for(int i)
        return output;
    }

    public static void main(String[] args) {
        StringSpliter spliter = new StringSpliter();
        System.out.println(spliter.splitString("abc xyz nm", 2));
    }
}
