package org.example.factories;

import org.example.QuackCounter;
import org.example.Quackable;
import org.example.duck.DuckCall;
import org.example.duck.MallardDuck;
import org.example.duck.RedheadDuck;
import org.example.duck.RubberDuck;

public class CountingDuckFactory extends AbstractDuckFactory {

        @Override
        public Quackable createMallardDuck() {
            return new QuackCounter(new MallardDuck());
        }

        @Override
        public Quackable createRedheadDuck() {
            return new QuackCounter(new RedheadDuck());
        }

        @Override
        public Quackable createDuckCall() {
            return new QuackCounter(new DuckCall());
        }

        @Override
        public Quackable createRubberDuck() {
            return new QuackCounter(new RubberDuck());
        }
}
