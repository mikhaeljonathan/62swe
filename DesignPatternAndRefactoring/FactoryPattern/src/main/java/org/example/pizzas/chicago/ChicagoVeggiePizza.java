package org.example.pizzas.chicago;

import org.example.pizzas.Pizza;

public class ChicagoVeggiePizza extends Pizza {

    public void bake() {
        System.out.println("Baking Chicago Veggie Pizza");
    }

    public void cut() {
        System.out.println("Cutting Chicago Veggie Pizza");
    }

    public void box() {
        System.out.println("Boxing Chicago Veggie Pizza");
    }

    @Override
    public String getName() {
        return "Chicago Veggie Pizza";
    }
}
