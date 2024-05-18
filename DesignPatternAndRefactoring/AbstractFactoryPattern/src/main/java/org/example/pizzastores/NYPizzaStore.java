package org.example.pizzastores;

import org.example.ingredientfactories.NYPizzaIngredientFactory;
import org.example.ingredientfactories.PizzaIngredientFactory;
import org.example.pizzas.*;

public class NYPizzaStore extends PizzaStore {

    private PizzaIngredientFactory nyPizzaIngredientFactory = new NYPizzaIngredientFactory();

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza(nyPizzaIngredientFactory);
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza(nyPizzaIngredientFactory);
        } else if (type.equals("clam")) {
            pizza = new ClamPizza(nyPizzaIngredientFactory);
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza(nyPizzaIngredientFactory);
        } else if (type.equals("plain")) {
            pizza = new PlainPizza(nyPizzaIngredientFactory);
        }
        return pizza;
    }
}
