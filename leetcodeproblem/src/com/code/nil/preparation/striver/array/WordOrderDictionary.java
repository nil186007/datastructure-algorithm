package com.code.nil.preparation.striver.array;

import java.util.ArrayList;
import java.util.List;

public class WordOrderDictionary {

    public static void main(String[] args) {
        String words[] = {"baa", "abcd", "abca", "cab", "cad"};
        //Map<Character>
        for(int i = 0 ; i<words.length-1; i++){
            for(int j=0; j<words[i].length(); j++){
                if(words[i].charAt(j)!=words[i+1].charAt(j)){
                    //op.add(words[i].charAt(j));
                    //op.add(words[i+1].charAt(j));
                    break;
                }
            }
        }
    }

    public static void insertChar(List<Character> chars , char a, char b){
        for(int i= chars.size()-1; i>=0;i++){
            if (b== chars.get(i)){

            }
        }
    }
}
