package org.example.ingredientfactories;

import org.example.ingredients.cheeses.Cheese;
import org.example.ingredients.cheeses.MozzarellaCheese;
import org.example.ingredients.clams.Clams;
import org.example.ingredients.clams.FrozenClams;
import org.example.ingredients.doughs.Dough;
import org.example.ingredients.doughs.ThickCrustDough;
import org.example.ingredients.pepperonis.Pepperoni;
import org.example.ingredients.pepperonis.SlicedPepperoni;
import org.example.ingredients.sauces.PlumTomatoSauce;
import org.example.ingredients.sauces.Sauce;
import org.example.ingredients.veggies.BlackOlives;
import org.example.ingredients.veggies.Eggplant;
import org.example.ingredients.veggies.Spinach;
import org.example.ingredients.veggies.Veggies;

public class ChicagoPizzaIngredientFactory extends PizzaIngredientFactory{

    public ChicagoPizzaIngredientFactory() {
        this.style = "Chicago Style ";
    }

    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {new BlackOlives(), new Spinach(), new Eggplant()};
        return veggies;
    }

    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return null;
    }

}
