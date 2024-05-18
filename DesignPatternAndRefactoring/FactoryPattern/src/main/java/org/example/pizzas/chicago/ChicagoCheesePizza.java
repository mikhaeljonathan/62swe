package org.example.pizzas.chicago;

import org.example.pizzas.Pizza;

public class ChicagoCheesePizza extends Pizza {

    @Override
    public void bake() {
        System.out.println("Baking Chicago Cheese Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Chicago Cheese Pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing Chicago Cheese Pizza");
    }

    @Override
    public String getName() {
        return "Chicago Cheese Pizza";
    }
}
