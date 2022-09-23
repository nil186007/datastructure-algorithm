package com.nilesh.practice.atlassian;

import java.time.Instant;
import java.util.*;

class RateLimitingPlan {
    private int requestCount;
    private Long timeWindowMillis;

    public RateLimitingPlan(int requestCount, Long timeWindow) {
        this.requestCount = requestCount;
        this.timeWindowMillis = timeWindow;
    }
    public int getRequestCount() {
        return requestCount;
    }
    public Long getTimeWindowMillis() {
        return timeWindowMillis;
    }
}

class Customer {
    Integer customerId;
    RateLimitingPlan plan;
    Queue<Long> requestBuffer;
    public Customer(Integer customerId, RateLimitingPlan plan, Queue<Long> requestBuffer) {
        this.customerId = customerId;
        this.plan = plan;
        this.requestBuffer = requestBuffer;
    }
}

public class RateLimiter {
    Map<Integer, Deque<Long>> requestRegistry;
    RateLimitingPlan rateLimitingPlan;

    public RateLimiter(RateLimitingPlan rateLimitingPlan) {
        this.rateLimitingPlan = rateLimitingPlan;
        requestRegistry = new HashMap<>();
    }

    boolean rateLimit(int customerId) {
        Long currentTime = Instant.now().toEpochMilli();
        Deque<Long> existingRequest = requestRegistry.getOrDefault(customerId, new ArrayDeque<>());
        synchronized (existingRequest) {
            if (existingRequest.size() < rateLimitingPlan.getRequestCount()) {
                existingRequest.offer(currentTime);
                requestRegistry.put(customerId, existingRequest);
                return true;
            } else {
                if ((currentTime - existingRequest.peek()) < rateLimitingPlan.getTimeWindowMillis()) {
                    return false;
                } else {
                    while (!existingRequest.isEmpty()
                            && (currentTime - existingRequest.peek()) >= rateLimitingPlan.getTimeWindowMillis()) {
                        existingRequest.poll();
                    }
                    existingRequest.offer(currentTime);
                    return true;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        RateLimitingPlan rateLimitingPlan = new RateLimitingPlan(10, 2000L);
        RateLimiter rateLimiter = new RateLimiter(rateLimitingPlan);


        for (int i = 0; i < 5; i++) {
            System.out.println(i + 1 + " : " + rateLimiter.rateLimit(1));
        }
        System.out.println("---------");
        Thread.sleep(1500L);
        for (int i = 0; i < 5; i++) {
            System.out.println(i + 1 + " : " + rateLimiter.rateLimit(1));
        }
        System.out.println("---------");
        Thread.sleep(500L);
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1 + " : " + rateLimiter.rateLimit(1));
        }

    }


}
