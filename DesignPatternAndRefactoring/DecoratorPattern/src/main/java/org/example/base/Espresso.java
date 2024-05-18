package org.example.base;

import org.example.Beverage;

public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public float getCost() {
        return 1.99f;
    }
}
