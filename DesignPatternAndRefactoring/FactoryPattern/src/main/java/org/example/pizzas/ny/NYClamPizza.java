package org.example.pizzas.ny;

import org.example.pizzas.Pizza;

public class NYClamPizza extends Pizza {

    public NYClamPizza() {
        name = "NY Clam Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }
    @Override
    public void bake() {
        System.out.println("Baking NY Clam Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting NY Clam Pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing NY Clam Pizza");
    }

    @Override
    public String getName() {
        return "NY Clam Pizza";
    }
}
