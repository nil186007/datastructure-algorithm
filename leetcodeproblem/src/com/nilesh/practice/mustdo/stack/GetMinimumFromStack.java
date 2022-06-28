package com.nilesh.practice.mustdo.stack;

import java.util.ArrayList;
import java.util.List;

public class GetMinimumFromStack {


    private List<Integer> values = new ArrayList<>();
    private List<Integer> minimumValue = new ArrayList<>();

    void push(int i){
        values.add(i);
    }

    int pop(){
        if(!values.isEmpty()){
            return values.get(values.size()-1);
        }else{
            return -1;
        }
    }

    int getMin(){
        return -1;
    }

    public static void main(String[] args) {

    }

}
