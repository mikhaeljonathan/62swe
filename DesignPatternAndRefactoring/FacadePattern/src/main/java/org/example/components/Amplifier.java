package org.example.components;

public class Amplifier {
    public void on() {
        System.out.println("Amplifier is on");
    }

    public void off() {
        System.out.println("Amplifier is off");
    }

    public void setDvd(DvdPlayer dvd) {
        System.out.println("Amplifier is set to DVD player");
    }

    public void setSurroundSound() {
        System.out.println("Amplifier is set to surround sound");
    }

    public void setVolume(int volume) {
        System.out.println("Amplifier volume is set to " + volume);
    }
}
