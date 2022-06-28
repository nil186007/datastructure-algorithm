package com.code.nil.preparation.javamemory;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeak {
    List<Double> doubles = new ArrayList<>();
    public static void main(String[] args) {
        MemoryLeak memoryLeak = new MemoryLeak();
        for (int i = 0; i<1000000; i++){
            memoryLeak.doubles.add(Double.valueOf(0.0+i));

            System.out.println();
        }
        System.out.println();

       //List
    }
}
