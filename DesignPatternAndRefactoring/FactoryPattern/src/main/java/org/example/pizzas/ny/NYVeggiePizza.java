package org.example.pizzas.ny;

import org.example.pizzas.Pizza;

public class NYVeggiePizza extends Pizza {

    @Override
    public void bake() {
        System.out.println("Baking NY Veggie Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting NY Veggie Pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing NY Veggie Pizza");
    }

    @Override
    public String getName() {
        return "NY Veggie Pizza";
    }
}
