package com.code.nil.preparation.goldman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AllPathGrid {

    static  List<String> fullPath = new ArrayList<>();

    public static void findAllPath(int [][] a, int row, int col, String currentPath){

        currentPath = currentPath +","+row+"-"+col ;
        if(row == a.length-1 &&  col == a[0].length-1){
            fullPath.add(currentPath);
            return;
        }else if (row >= a.length ||  col >= a[0].length){
            currentPath.substring(0,currentPath.lastIndexOf(","));
            return;
        }else {
            findAllPath(a, row + 1, col, currentPath);
            findAllPath(a, row, col + 1, currentPath);
        }

    }

    public static void main(String[] args) {
        int [][] a = new int[4][4];
        //findAllPath(a,0,0,"");

        int[][] dp = new int[a.length][a[0].length];

        //System.out.println(getAllPath(a,0,0, dp));

        int [] coins = {1,2,5};
        int amount = 16;
        int [] dp1 = new int[amount+1];
        System.out.println(coinExchangeProblem(coins,amount,dp1));
        Arrays.stream(dp1).forEach(System.out::println);
    }

    public static int getAllPath(int [][] a, int row, int col, int dp[][]){

        if(row== a.length-1 && col == a[0].length-1) return 1;
        if(row>=a.length ||  col>=a[0].length) return 0;
        if(dp[row][col] >0) return dp[row][col];

        int totalPath = getAllPath(a, row+1, col, dp) + getAllPath(a, row, col+1,dp);
        dp[row][col] = totalPath;
        return totalPath;
    }

    public static int coinExchangeProblem(int [] a, int amount, int [] dp){

        if(amount == 0 ) return 0;
        if(amount < 0 ) return -1;
        if(dp[amount] > 0 ) return dp[amount];
        int min = Integer.MAX_VALUE;
        for(int i=0; i< a.length; i++){
            int result = coinExchangeProblem(a, amount-a[i], dp);
            if(result>=0){
                min = Math.min(min, result+1);
            }
        }
        min = min == Integer.MAX_VALUE ? -1 : min;
        dp[amount] = min;
        return min;

    }

    public static int roundGame(int n, int k){
        if(n==0) return 1;
        return (roundGame(n-1,k)+k)%n;
    }




}
