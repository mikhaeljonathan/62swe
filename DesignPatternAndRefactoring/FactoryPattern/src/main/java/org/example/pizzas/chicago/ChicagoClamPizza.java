package org.example.pizzas.chicago;

import org.example.pizzas.Pizza;

public class ChicagoClamPizza extends Pizza {

    @Override
    public void bake() {
        System.out.println("Baking Chicago Clam Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Chicago Clam Pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing Chicago Clam Pizza");
    }

    @Override
    public String getName() {
        return "Chicago Clam Pizza";
    }
}
