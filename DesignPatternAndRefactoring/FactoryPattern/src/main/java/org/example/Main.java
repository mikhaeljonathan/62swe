package org.example;

import org.example.pizzas.Pizza;
import org.example.pizzastores.ChicagoPizzaStore;
import org.example.pizzastores.NYPizzaStore;
import org.example.pizzastores.PizzaStore;

public class Main {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("plain");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}