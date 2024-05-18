package org.example;

import org.example.behaviors.FlyNoWay;
import org.example.behaviors.FlyWithJet;
import org.example.behaviors.Squeak;
import org.example.ducks.Duck;
import org.example.ducks.MallardDuck;

public class Main {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
        mallard.setQuackBehavior(new Squeak());
        mallard.performQuack();
        mallard.setFlyBehavior(new FlyNoWay());
        mallard.performFly();
        mallard.setFlyBehavior(new FlyWithJet());
        mallard.performFly();

        mallard.setQuackBehavior(() -> System.out.println("Quack Quack"));
        mallard.performQuack();
    }
}