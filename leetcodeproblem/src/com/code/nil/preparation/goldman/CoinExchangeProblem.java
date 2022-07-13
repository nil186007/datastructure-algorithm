package com.code.nil.preparation.goldman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinExchangeProblem {


    public static int getCoinCount(int [] coins, int amount, Map<Integer, Integer> resultMap){

        if(amount==0) return 0;
        if(amount<0) return -1;
        if(resultMap.get(amount)!=null) return resultMap.get(amount);
        int minValue = Integer.MAX_VALUE;
        for(int i : coins){
            int value = getCoinCount(coins, amount-i, resultMap);
            if(value==-1) continue;
            minValue = Math.min(minValue, value + 1);

        }
        minValue = minValue == Integer.MAX_VALUE ? -1 : minValue;
        resultMap.put(amount, minValue);
        return minValue;
    }

    public static void main(String[] args) {
        int [] coins = {1,2,5};
        int number = 13;
        Map<Integer, Integer> resultMap = new HashMap<>();

        int count = getCoinCount(coins, number, resultMap);

        System.out.println(count);
    }

}
