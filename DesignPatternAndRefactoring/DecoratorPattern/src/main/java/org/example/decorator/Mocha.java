package org.example.decorator;

import org.example.Beverage;

public class Mocha extends CondimentDecorator{
    private float price = 0.20f;
    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription(){
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public float getCost(){
        return price + beverage.getCost();
    }
}
