package org.example.ducks;

import org.example.behaviors.FlyBehavior;
import org.example.behaviors.QuackBehavior;

public abstract class Duck {

    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public void swim() {
        System.out.println("Swimming...");
    }

    public void display() {
        System.out.println("I'm a duck");
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

}
