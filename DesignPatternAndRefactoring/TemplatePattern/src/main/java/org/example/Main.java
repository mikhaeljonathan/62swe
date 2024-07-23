package org.example;

import org.example.hook.CoffeeWithHook;

public class Main {
    public static void main(String[] args) {
        CoffeeWithHook coffee = new CoffeeWithHook();
        coffee.prepareRecipe();
    }
}