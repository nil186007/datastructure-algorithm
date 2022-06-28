package com.code.nil.preparation.striver.array;

public class StockBuySellEasy {

    public <T> void method(T a){

    }

    public static void main(String[] args) {

        int[] array = {7,6,4,3,1};

        int lowest = array[0];
        int profit = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < lowest) {
                lowest = array[i];
            }
            if (profit < (array[i] - lowest)) {
                profit = array[i] - lowest;
            }
        }

        System.out.println(" lowest : " + lowest + " : profit : " + profit);
    }
}
