package com.code.nil.preparation.multithread.webcrawler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WebCrawllerManger {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        List<WebCallerTask> tasks = new ArrayList<>();
        tasks.add(new WebCallerTask());
        tasks.add(new WebCallerTask());
        tasks.add(new WebCallerTask());
        tasks.add(new WebCallerTask());
        tasks.add(new WebCallerTask());
        tasks.add(new WebCallerTask());

        List<Future<String>> futures = executorService.invokeAll(tasks);
        futures.forEach(f -> {
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}
