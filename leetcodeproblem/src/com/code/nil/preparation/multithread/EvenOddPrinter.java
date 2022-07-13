package com.code.nil.preparation.multithread;

public class EvenOddPrinter {



    public static void main(String[] args) {

        Thread evenPrinter = new Thread(()->{


        }, "0");

        Thread oddPrinter = new Thread(()->{

        },"1");

        evenPrinter.start();
        oddPrinter.start();

    }



}
