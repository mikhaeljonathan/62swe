package org.example.pizzastores;

import org.example.pizzas.*;
import org.example.pizzas.ny.*;

public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new NYCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new NYPepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new NYClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new NYVeggiePizza();
        } else if (type.equals("plain")) {
            pizza = new NYPlainPizza();
        }
        return pizza;
    }
}
