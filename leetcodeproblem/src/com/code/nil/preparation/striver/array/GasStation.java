package com.code.nil.preparation.striver.array;

/**
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
 * <p>
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 * <p>
 * Solution = if gas[]
 **/


public class GasStation {

    public static int gasStation(int[] gas, int[] cost){

        int currentGasInTank = 0;
        int remainingGas = 0;
        int deficit = 0;
        int start = 0;
        for(int i=0; i<gas.length-1; i++){
            remainingGas =  currentGasInTank + gas[i] - cost[i];
            if(remainingGas<0){
                start = i+1;
                currentGasInTank = 0;
                deficit +=remainingGas;
            }else{
                currentGasInTank = remainingGas;
            }
        }
        if(currentGasInTank>=deficit){
            System.out.println(start);
            return start;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {

        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        //int[] gas =  {4,5,2,6,5,3};
        //int[] cost = {3,2,7,3,2,9};

        int current_tank = 0;
        int startPosition = 0;
        int deficit = 0;
        for (int i = 0; i < gas.length; i++) {
            int remainingGas = current_tank + gas[i] - cost[i];
            if (remainingGas >= 0) {
                current_tank = remainingGas;
            } else {
                //check how much deficit is created
                deficit += remainingGas;
                startPosition = i+1;
                current_tank = 0;
            }
        }
        //if no deficit then can be possible
        System.out.println( current_tank>=(deficit*-1) ? startPosition : -1 );
    }
}
