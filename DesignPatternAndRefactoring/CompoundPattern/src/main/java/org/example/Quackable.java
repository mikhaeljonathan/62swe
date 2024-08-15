package org.example;

import org.example.observer.QuackObservable;

public interface Quackable extends QuackObservable {
    public void quack();
}
