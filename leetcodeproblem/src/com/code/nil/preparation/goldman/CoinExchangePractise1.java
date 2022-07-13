package com.code.nil.preparation.goldman;

import java.util.function.DoubleToIntFunction;

public class CoinExchangePractise1 {

    public static int coinChange(int[] coins, int amount) {
        if(amount == 0 ) return 0;
        if(amount < 0 ) return -1;
        int min = Integer.MAX_VALUE;
        for(int i=0 ; i< coins.length ; i++){
           int value =  coinChange(coins,amount-coins[i]);
           if(value>=0 && value<min){
               min = 1+value;
           }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        int [] a = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(a,amount));
    }


}
