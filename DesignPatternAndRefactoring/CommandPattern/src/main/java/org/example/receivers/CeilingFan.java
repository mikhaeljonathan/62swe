package org.example.receivers;

public class CeilingFan {
    private String location;
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    private int speed;

    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;
    }

    public void high() {
        System.out.println(location + " ceiling fan is on high");
        speed = HIGH;
    }

    public void medium() {
        System.out.println(location + " ceiling fan is on medium");
        speed = MEDIUM;
    }

    public void low() {
        System.out.println(location + " ceiling fan is on low");
        speed = LOW;
    }

    public void off() {
        System.out.println(location + " ceiling fan is off");
    }

    public int getSpeed() {
        return speed;
    }


}
