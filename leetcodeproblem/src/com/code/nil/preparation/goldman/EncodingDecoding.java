package com.code.nil.preparation.goldman;

public class EncodingDecoding {

    public static void main(String[] args) {

        String a = "aaabbcccdeeef";

        Character lastChar = a.charAt(0);
        int counter=0;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)==lastChar){
                counter++;
            }else{
                stringBuilder.append(lastChar);
                stringBuilder.append(counter);
                counter=1;
                lastChar=a.charAt(i);
            }

        }
        System.out.println(stringBuilder);
    }
}
