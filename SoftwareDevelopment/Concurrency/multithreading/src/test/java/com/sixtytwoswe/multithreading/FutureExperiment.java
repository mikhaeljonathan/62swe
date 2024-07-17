package com.sixtytwoswe.multithreading;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExperiment {
    @Test
    void experiment() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<String> future = executor.submit(() -> {
            Thread.sleep(5000);
            return "Hi mom";
        });

//        while(!future.isDone()) {
//            System.out.println("Waiting for the future to be done");
//            Thread.sleep(1000);
//        }

        // blocking
        System.out.println(future.get());

        System.out.println("Done");
    }
}
