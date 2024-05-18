package org.example.pizzas;

import java.util.ArrayList;

public abstract class Pizza {

    protected String name;
    protected String dough;
    protected String sauce;
    protected ArrayList<String> toppings = new ArrayList<String>();

    public void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings: ");
        for (String topping : toppings) {
            System.out.println("   " + topping);
        }
    }
    public abstract void bake();
    public abstract void cut();
    public abstract void box();
    public abstract String getName();
}
