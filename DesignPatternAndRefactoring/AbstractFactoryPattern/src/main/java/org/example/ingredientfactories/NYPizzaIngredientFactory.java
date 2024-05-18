package org.example.ingredientfactories;

import org.example.ingredients.cheeses.Cheese;
import org.example.ingredients.cheeses.ReggianoCheese;
import org.example.ingredients.clams.Clams;
import org.example.ingredients.clams.FreshClams;
import org.example.ingredients.doughs.Dough;
import org.example.ingredients.doughs.ThinCrustDough;
import org.example.ingredients.pepperonis.Pepperoni;
import org.example.ingredients.pepperonis.SlicedPepperoni;
import org.example.ingredients.sauces.MarinaraSauce;
import org.example.ingredients.sauces.Sauce;
import org.example.ingredients.veggies.*;

public class NYPizzaIngredientFactory extends PizzaIngredientFactory {

    public NYPizzaIngredientFactory() {
        this.style = "New York Style ";
    }

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FreshClams();
    }

}
