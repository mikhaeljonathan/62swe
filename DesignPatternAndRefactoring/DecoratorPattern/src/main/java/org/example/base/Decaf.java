package org.example.base;

import org.example.Beverage;

public class Decaf extends Beverage {

    public Decaf() {
        description = "Decaf Coffee";
    }

    @Override
    public float getCost() {
        return 1.05f;
    }
}
