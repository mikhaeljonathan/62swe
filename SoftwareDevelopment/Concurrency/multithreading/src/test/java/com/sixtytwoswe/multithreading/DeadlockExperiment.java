package com.sixtytwoswe.multithreading;

import org.junit.jupiter.api.Test;

public class DeadlockExperiment {

    @Test
    public void deadlockExperiment() throws InterruptedException {
        Balance balance1 = new Balance(1000);
        Balance balance2 = new Balance(2000);

        Thread thread1 = new Thread(() -> {
            try {
                transfer(balance1, balance2, 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                transfer(balance2, balance1, 300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Balance 1: " + balance1.getBalance());
        System.out.println("Balance 2: " + balance2.getBalance());
    }


//    public void transfer(Balance from, Balance to, long amount) throws InterruptedException {
//        synchronized (from) {
//            Thread.sleep(1000);
//            synchronized (to) {
//                Thread.sleep(1000);
//                from.setBalance(from.getBalance() - amount);
//                to.setBalance(to.getBalance() + amount);
//            }
//        }
//    }

    public void transfer(Balance from, Balance to, long amount) throws InterruptedException {
        synchronized (from) {
            Thread.sleep(1000);
            from.setBalance(from.getBalance() - amount);
        }
        synchronized (to) {
            Thread.sleep(1000);
            to.setBalance(to.getBalance() + amount);
        }
    }
}
