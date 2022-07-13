package com.nilesh.practice.gs;

import java.util.*;
import java.util.stream.Collectors;

public class AverageStudent {

    public static void main(String[] args) {
        String highestScorer;
        Integer maxAverage;



        Map<String, PriorityQueue<Integer>> scoreTable = new HashMap();
        List<String> marks = new ArrayList<>();
        List<Integer> l = new ArrayList<>();


        Double average = marks.stream().mapToInt(s -> Integer.parseInt(s)).average().getAsDouble();
        average.intValue();

        for(String s : marks){
            String [] token = s.split(",");
            PriorityQueue<Integer> markQueue = scoreTable.get(token[0]);
            int currentAvg = 0;
            if(markQueue== null){
                PriorityQueue<Integer> q = new PriorityQueue();
                q.add(Integer.parseInt(token[1]));
                scoreTable.put(token[0], q);
                currentAvg = Integer.parseInt(token[1]);
            }else{

            }
        }
    }
}
