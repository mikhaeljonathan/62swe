package com.sixtytwoswe.multithreading;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;

public class ThreadExperiment {

    @Test
    void execute() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName);

        // anonymous inner class
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("Hello from thread: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    System.out.println("Thread was interrupted");
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("Hello");
        Thread.sleep(1000);

//
//
////        Thread.sleep(3000); // older jvm, the thread above won't be done executed
//        System.out.println("Done");
//        Thread.sleep(1000);
//        thread.interrupt();
//        thread.join(); // wait for the thread to finish
    }
}
