package org.example.base;

import org.example.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public float getCost() {
        return 0.89f;
    }
}
