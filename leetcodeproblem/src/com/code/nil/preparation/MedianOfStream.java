package com.code.nil.preparation;

import java.util.*;

public class MedianOfStream {

   static PriorityQueue<Integer> leftQueue = new PriorityQueue<>(Collections.reverseOrder());
   static PriorityQueue<Integer> rightQueue = new PriorityQueue<>();

    public static void main(String[] args) {
        Random r = new Random();
        List<Integer> numbers = new ArrayList<>();
        List<Integer> medians = new ArrayList<>();
        for(int i = 0; i<10; i++){
            int streamVal = r.nextInt(100);
            numbers.add(streamVal);
            medians.add(getMedian(streamVal));
            System.out.println("Number : " + numbers);
            System.out.println("Left : " + leftQueue);
            System.out.println("Right: " + rightQueue);
            System.out.println("median : " + medians);
            System.out.println("=========================");
        }

    }

    public static int getMedian(int n){

        leftQueue.offer(n);
        rightQueue.offer(leftQueue.poll());
        if(leftQueue.size()<rightQueue.size()){
            leftQueue.offer(rightQueue.poll());
        }
        if(leftQueue.size()-rightQueue.size() == 1){
            return leftQueue.peek();
        }else {
            return (leftQueue.peek()+rightQueue.peek()) / 2;
        }

    }
}
