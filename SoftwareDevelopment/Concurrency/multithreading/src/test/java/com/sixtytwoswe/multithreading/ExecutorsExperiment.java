package com.sixtytwoswe.multithreading;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsExperiment {

    @Test
    void experiment() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            int task = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Hello from task " + task + " thread: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();
        System.out.println(executor.awaitTermination(30, TimeUnit.SECONDS));
        System.out.println("Done");
//        Thread.sleep(60000);
    }
}
