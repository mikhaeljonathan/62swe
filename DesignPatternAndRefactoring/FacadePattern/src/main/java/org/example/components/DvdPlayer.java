package org.example.components;

public class DvdPlayer {
    public void on() {
        System.out.println("DvdPlayer on");
    }

    public void play(String movie) {
        System.out.println("DvdPlayer playing " + movie);
    }

    public void stop() {
        System.out.println("DvdPlayer stopped");
    }

    public void eject() {
        System.out.println("DvdPlayer eject");
    }

    public void off() {
        System.out.println("DvdPlayer off");
    }
}
