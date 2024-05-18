package org.example.pizzas;

import org.example.ingredientfactories.PizzaIngredientFactory;

public class PepperoniPizza extends Pizza{
    private PizzaIngredientFactory ingredientFactory;

    public PepperoniPizza(PizzaIngredientFactory ingredientFactory){
        name = ingredientFactory.getStyle() + " Pepperoni Pizza";
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        pepperoni = ingredientFactory.createPepperoni();
    }
}
