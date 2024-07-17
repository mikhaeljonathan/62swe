package com.sixtytwoswe.multithreading;

import org.junit.jupiter.api.Test;

public class ThreadCommunication {

    private volatile String message = null;

    @Test
    void manual() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (message == null) {
            }
            System.out.println(message);
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Setting message");
                message = "Hello, World!";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    @Test
    void waitNotify() throws InterruptedException {
        Object lock = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(2000);
                    message = "Hello, World!";
                    lock.notify();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
