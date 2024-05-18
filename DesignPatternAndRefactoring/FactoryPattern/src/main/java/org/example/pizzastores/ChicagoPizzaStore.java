package org.example.pizzastores;

import org.example.pizzas.*;
import org.example.pizzas.chicago.*;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new ChicagoCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new ChicagoPepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ChicagoClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new ChicagoVeggiePizza();
        } else if (type.equals("plain")) {
            pizza = new ChicagoPlainPizza();
        }
        return pizza;
    }
}
