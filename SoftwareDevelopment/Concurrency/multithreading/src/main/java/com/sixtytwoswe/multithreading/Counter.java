package com.sixtytwoswe.multithreading;

public class Counter {
    private Long value = 0L;

    private final Object lock = new Object();

    public void increment() {
        // other statement
        synchronized(lock) {
            value++;
        }
        // other statement
    }

//    public synchronized void increment() {
//        // other statements
//        synchronized (value) {
//            value++;
//        }
//        // other statements
//    }

    public Long getValue() {
        return value;
    }
}
