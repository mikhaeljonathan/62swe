package org.example.pizzas;

import org.example.ingredients.cheeses.Cheese;
import org.example.ingredients.clams.Clams;
import org.example.ingredients.doughs.Dough;
import org.example.ingredients.pepperonis.Pepperoni;
import org.example.ingredients.sauces.Sauce;
import org.example.ingredients.veggies.Veggies;

import java.util.ArrayList;

public abstract class Pizza {

    protected String name;

    protected Dough dough;
    protected Sauce sauce;
    protected Veggies veggies[];
    protected Cheese cheese;
    protected Pepperoni pepperoni;
    protected Clams clam;

    public abstract void prepare();
    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }
    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }
    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }
    public String getName() {
        return name;
    }
}
