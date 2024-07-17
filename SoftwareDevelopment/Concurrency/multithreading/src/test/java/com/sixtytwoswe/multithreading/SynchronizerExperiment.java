package com.sixtytwoswe.multithreading;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class SynchronizerExperiment {
    @Test
    void semaphore() throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);
        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            service.execute(() -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(1000);
                    System.out.println("Finish");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }
            });
        }

        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    void exchanger() throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(() -> {
            try {
                System.out.println("First thread sending");
                Thread.sleep(1000);
                String value = exchanger.exchange("First data");
                System.out.println("First thread received: " + value);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.execute(() -> {
            try {
                System.out.println("Second thread sending");
                Thread.sleep(2000);
                String value = exchanger.exchange("Second data");
                System.out.println("Second thread received: " + value);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
