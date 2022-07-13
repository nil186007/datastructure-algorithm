package com.code.nil.preparation.goldman;

public class JosephusProblem {

    public static int getWinner(int n, int k){
        if (n==1) return 0;
        return (getWinner(n-1,k)+k)%n;
    }

    public static void main(String[] args) {
        System.out.println( getWinner(5,2));
    }
}
