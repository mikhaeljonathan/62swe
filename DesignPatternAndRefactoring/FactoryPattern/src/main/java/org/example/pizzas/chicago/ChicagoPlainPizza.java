package org.example.pizzas.chicago;

import org.example.pizzas.Pizza;

public class ChicagoPlainPizza extends Pizza {

        @Override
        public void bake() {
            System.out.println("Baking Chicago Plain Pizza");
        }

        @Override
        public void cut() {
            System.out.println("Cutting Chicago Plain Pizza");
        }

        @Override
        public void box() {
            System.out.println("Boxing Chicago Plain Pizza");
        }

        @Override
        public String getName() {
            return "Chicago Plain Pizza";
        }
}
