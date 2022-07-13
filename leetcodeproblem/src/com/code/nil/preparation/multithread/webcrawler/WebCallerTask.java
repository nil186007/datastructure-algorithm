package com.code.nil.preparation.multithread.webcrawler;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class WebCallerTask implements Callable<String> {

    ArrayBlockingQueue<Callable<String>> queue = new ArrayBlockingQueue(10);

    Random random = new Random();

    @Override
    public String call() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        if(random.nextInt()%2 == 0){
            queue.add(new Crawller());
        }
        List<Future<String>> futures = executorService.invokeAll(queue);
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

        return Thread.currentThread().getName() + " :: 1st task";
    }
}
