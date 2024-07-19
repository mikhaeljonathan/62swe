package org.example.receivers;

public class Light {

    private String location;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println("Light in " + location + " is on");
    }

    public void off() {
        System.out.println("Light in " + location + " is off");
    }
}
