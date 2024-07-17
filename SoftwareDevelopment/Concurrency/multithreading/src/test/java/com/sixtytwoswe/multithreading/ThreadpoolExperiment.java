package com.sixtytwoswe.multithreading;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadpoolExperiment {

    @Test
    void experiment() throws InterruptedException {
        int minThread = 5;
        int maxThread = 10;
        long keepAliveTime = 1;
        TimeUnit time = TimeUnit.MINUTES;

        ArrayBlockingQueue queue = new ArrayBlockingQueue<Runnable>(20);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(minThread, maxThread, keepAliveTime, time, queue, new LogRejectedExecutionHandler());

        for (int i = 0; i < 30; i++) {
            int task = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println("Hello from task " + task + " thread: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();
        System.out.println(executor.awaitTermination(2, TimeUnit.SECONDS));
        System.out.println("Done");
    }

    public static class LogRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Task rejected: " + r);
        }
    }
}
