package com.code.nil.preparation.multithread.webcrawler;

import java.util.concurrent.Callable;

public class Crawller implements Callable<String> {

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName()+" :: 2nd Task";
    }
}
