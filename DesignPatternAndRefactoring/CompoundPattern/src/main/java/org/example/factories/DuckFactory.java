package org.example.factories;

import org.example.Quackable;
import org.example.duck.DuckCall;
import org.example.duck.MallardDuck;
import org.example.duck.RedheadDuck;
import org.example.duck.RubberDuck;

public class DuckFactory extends AbstractDuckFactory {

    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createRedheadDuck() {
        return new RedheadDuck();
    }

    @Override
    public Quackable createDuckCall() {
        return new DuckCall();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RubberDuck();
    }
}
