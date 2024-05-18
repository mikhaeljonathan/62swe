package org.example.pizzas.ny;

import org.example.pizzas.Pizza;

public class NYPepperoniPizza extends Pizza {

    @Override
    public void bake() {
        System.out.println("Baking NY Pepperoni Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting NY Pepperoni Pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing NY Pepperoni Pizza");
    }

    @Override
    public String getName() {
        return "NY Pepperoni Pizza";
    }
}
