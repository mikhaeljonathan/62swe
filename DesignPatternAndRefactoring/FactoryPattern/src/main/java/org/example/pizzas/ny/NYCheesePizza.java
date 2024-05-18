package org.example.pizzas.ny;

import org.example.pizzas.Pizza;

public class NYCheesePizza extends Pizza {

    public NYCheesePizza() {
        name = "NY Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }
    @Override
    public void bake() {
        System.out.println("Baking NY Cheese Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting NY Cheese Pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing NY Cheese Pizza");
    }

    @Override
    public String getName() {
        return "NY Cheese Pizza";
    }
}
