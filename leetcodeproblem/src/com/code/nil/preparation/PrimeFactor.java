package com.code.nil.preparation;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class PrimeFactor {

    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(5,4,8,3,2,7,9);
        //list.stream()


        int n =63;
        for(int i=2; i<=n; i++){
            while(n%i == 0){
                System.out.println(i);
                n=n/i;
            }
        }
    }
}
