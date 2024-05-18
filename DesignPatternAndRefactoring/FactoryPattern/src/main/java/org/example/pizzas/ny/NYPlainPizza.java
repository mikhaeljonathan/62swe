package org.example.pizzas.ny;

import org.example.pizzas.Pizza;

public class NYPlainPizza extends Pizza {

        @Override
        public void bake() {
            System.out.println("Baking NY Plain Pizza");
        }

        @Override
        public void cut() {
            System.out.println("Cutting NY Plain Pizza");
        }

        @Override
        public void box() {
            System.out.println("Boxing NY Plain Pizza");
        }

        @Override
        public String getName() {
            return "NY Plain Pizza";
        }
}
