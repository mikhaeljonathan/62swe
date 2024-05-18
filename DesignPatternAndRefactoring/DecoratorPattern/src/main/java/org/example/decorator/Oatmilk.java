package org.example.decorator;

import org.example.Beverage;

public class Oatmilk extends CondimentDecorator{
    private float price = 0.25f;
    public Oatmilk(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription(){
        return beverage.getDescription() + ", Oatmilk";
    }

    @Override
    public float getCost(){
        return price + beverage.getCost();
    }
}
