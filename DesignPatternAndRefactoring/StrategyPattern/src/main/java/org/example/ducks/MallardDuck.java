package org.example.ducks;

import org.example.behaviors.FlyWithWings;
import org.example.behaviors.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a Mallard duck");
    }

}
