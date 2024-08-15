package org.example;

import org.example.observer.Observer;

import java.util.ArrayList;
import java.util.Iterator;

public class Flock implements Quackable{
    ArrayList<Quackable> quackers = new ArrayList<>();

    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        Iterator<Quackable> it = quackers.iterator();
        while (it.hasNext()) {
            Quackable quacker = it.next();
            quacker.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        Iterator<Quackable> it = quackers.iterator();
        while (it.hasNext()) {
            Quackable quacker = it.next();
            quacker.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {
        Iterator<Quackable> it = quackers.iterator();
        while (it.hasNext()) {
            Quackable quacker = it.next();
            quacker.notifyObservers();
        }
    }
}
