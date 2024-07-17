package com.sixtytwoswe.multithreading;

import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;

public class TimerExperiment {

    @Test
    void scheduleTimer() throws InterruptedException {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("scheduled task");
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 5000);

        Thread.sleep(6000);
    }

    @Test
    void periodicTask() throws InterruptedException {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("periodic task");
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 2000, 1000);

        Thread.sleep(10000);
    }
}
