package org.example;


import org.example.components.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
                new Amplifier(),
                new Tuner(),
                new DvdPlayer(),
                new CdPlayer(),
                new Projector(),
                new TheaterLights(),
                new Screen(),
                new PopcornPopper());

        homeTheater.watchMovie("Raiders of the Lost Ark");
        homeTheater.endMovie();
    }
}