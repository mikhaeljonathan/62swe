package org.example.pizzas.chicago;

import org.example.pizzas.Pizza;

public class ChicagoPepperoniPizza extends Pizza {

    public void bake() {
        System.out.println("Baking Chicago Pepperoni Pizza");
    }

    public void cut() {
        System.out.println("Cutting Chicago Pepperoni Pizza");
    }

    public void box() {
        System.out.println("Boxing Chicago Pepperoni Pizza");
    }

    @Override
    public String getName() {
        return "Chicago Pepperoni Pizza";
    }
}
