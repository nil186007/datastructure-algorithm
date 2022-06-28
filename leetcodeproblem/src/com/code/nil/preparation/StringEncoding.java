package com.code.nil.preparation;

public class StringEncoding {

    public static void main(String[] args) {

        String s= "aaabbeeecc";

        int start =0;
        int end = 0;

        int count=0;
        StringBuilder result = new StringBuilder();
        Character currentChar=s.charAt(start);
        while (end<s.length()){
            currentChar = s.charAt(start);
            if(currentChar.equals(s.charAt(end))){
                count++;
                end++;
            }else{
                result.append(currentChar);
                result.append(count);
                start=end;
                count=0;
            }
        }
        result.append(currentChar);
        result.append(count);

        System.out.println(result);
    }
}
