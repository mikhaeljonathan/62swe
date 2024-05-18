package org.example.decorator;

import org.example.Beverage;

public class Soy extends CondimentDecorator{
    private float price = 0.15f;
    public Soy(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription(){
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public float getCost(){
        return price + beverage.getCost();
    }
}
