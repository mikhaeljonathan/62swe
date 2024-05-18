package org.example;

import org.example.base.DarkRoast;
import org.example.base.Espresso;
import org.example.base.HouseBlend;
import org.example.decorator.*;

public class Main {
    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription() + " $" + espresso.getCost());

        Beverage latte = new Milk(espresso);
        System.out.println(latte.getDescription() + " $" + latte.getCost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.getCost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Oatmilk(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.getCost());

        Beverage beverage4 = new Oatmilk(new Mocha(new Soy(new HouseBlend())));
        System.out.println(beverage4.getDescription() + " $" + beverage4.getCost());
    }
}