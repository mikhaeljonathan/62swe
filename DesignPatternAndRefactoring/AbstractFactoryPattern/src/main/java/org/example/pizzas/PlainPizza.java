package org.example.pizzas;

import org.example.ingredientfactories.PizzaIngredientFactory;

public class PlainPizza extends Pizza{

    private PizzaIngredientFactory ingredientFactory;

    public PlainPizza(PizzaIngredientFactory ingredientFactory){
        name = ingredientFactory.getStyle() + " Plain Pizza";
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
