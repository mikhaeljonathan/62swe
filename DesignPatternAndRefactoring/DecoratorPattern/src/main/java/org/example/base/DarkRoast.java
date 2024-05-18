package org.example.base;

import org.example.Beverage;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    @Override
    public float getCost() {
        return 0.99f;
    }
}
