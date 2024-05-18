package org.example.ingredientfactories;

import org.example.ingredients.cheeses.Cheese;
import org.example.ingredients.clams.Clams;
import org.example.ingredients.doughs.Dough;
import org.example.ingredients.pepperonis.Pepperoni;
import org.example.ingredients.sauces.Sauce;
import org.example.ingredients.veggies.Veggies;

public abstract class PizzaIngredientFactory {
    protected String style;
    public abstract Dough createDough();
    public abstract Sauce createSauce();
    public abstract Cheese createCheese();
    public abstract Veggies[] createVeggies();
    public abstract Pepperoni createPepperoni();
    public abstract Clams createClams();

    public String getStyle() {
        return style;
    }
}
