package org.example;

import java.util.Iterator;
import org.example.menu.DinerMenu;
import org.example.menu.PancakeHouseMenu;

import java.util.ArrayList;

public class Waitress {
    private Menu dinerMenu;
    private Menu pancakeHouseMenu;
    private Menu cafeMenu;

    public Waitress(Menu dinerMenu, Menu pancakeHouseMenu, Menu cafeMenu) {
        this.dinerMenu = dinerMenu;
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.cafeMenu = cafeMenu;
    }

    public void printMenu() {
        Iterator dinerIterator = dinerMenu.createIterator();
        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator cafeIterator = cafeMenu.createIterator();

        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(dinerIterator);
        System.out.println("\nLUNCH");
        printMenu(pancakeIterator);
        System.out.println("\nDINNER");
        printMenu(cafeIterator);
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getName() + ", " + menuItem.getPrice() + " -- " + menuItem.getDescription());
        }
    }

//    public void printMenuBeforeIterator() {
//        MenuItem[] dinerItems = dinerMenu.getMenuItems();
//        ArrayList<MenuItem> pancakeItems = pancakeHouseMenu.getMenuItems();
//
//        for (MenuItem item : dinerItems) {
//            System.out.println(item.getName() + " " + item.getPrice() + " -- " + item.getDescription());
//        }
//
//        for (MenuItem item : pancakeItems) {
//            System.out.println(item.getName() + " " + item.getPrice() + " -- " + item.getDescription());
//        }
//    }
}
