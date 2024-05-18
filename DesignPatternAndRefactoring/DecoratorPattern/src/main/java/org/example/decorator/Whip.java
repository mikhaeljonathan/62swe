package org.example.decorator;

import org.example.Beverage;

public class Whip extends CondimentDecorator{
    private float price = 0.10f;
    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription(){
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public float getCost(){
        return price + beverage.getCost();
    }
}
