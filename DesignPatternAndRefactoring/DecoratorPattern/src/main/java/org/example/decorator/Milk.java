package org.example.decorator;

import org.example.Beverage;

public class Milk extends CondimentDecorator{
    private float price = 0.10f;
    public Milk(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription(){
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public float getCost(){
        return price + beverage.getCost();
    }
}
