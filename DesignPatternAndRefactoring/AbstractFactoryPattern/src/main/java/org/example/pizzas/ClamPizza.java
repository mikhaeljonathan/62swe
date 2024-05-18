package org.example.pizzas;

import org.example.ingredientfactories.PizzaIngredientFactory;

public class ClamPizza extends Pizza{
    private PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory){
        name = ingredientFactory.getStyle() + " Clam Pizza";
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clam = ingredientFactory.createClams();
    }
}
