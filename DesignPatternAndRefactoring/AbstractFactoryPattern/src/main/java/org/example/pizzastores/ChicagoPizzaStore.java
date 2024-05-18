package org.example.pizzastores;

import org.example.ingredientfactories.ChicagoPizzaIngredientFactory;
import org.example.ingredientfactories.PizzaIngredientFactory;
import org.example.pizzas.*;

public class ChicagoPizzaStore extends PizzaStore {

    private PizzaIngredientFactory chicagoIngredientFactory = new ChicagoPizzaIngredientFactory();

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza(chicagoIngredientFactory);
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza(chicagoIngredientFactory);
        } else if (type.equals("clam")) {
            pizza = new ClamPizza(chicagoIngredientFactory);
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza(chicagoIngredientFactory);
        } else if (type.equals("plain")) {
            pizza = new PlainPizza(chicagoIngredientFactory);
        }

        return pizza;
    }
}
