package org.example.behaviors;

public class FlyWithJet implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I'm flying with a jet!");
    }
}
