package org.example;

import java.util.Iterator;

import org.example.composite.MenuComponent;
import org.example.composite.MenuItem;

public class Waitress {
    private MenuComponent allMenu;

    public Waitress(MenuComponent allMenu) {
        this.allMenu = allMenu;
    }

    public void printMenu() {
        Iterator<MenuComponent> iterator = allMenu.createIterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            menuComponent.print();
        }
    }

//    private void printMenu(Iterator iterator) {
//        while (iterator.hasNext()) {
//            MenuItem menuItem = (MenuItem) iterator.next();
//            System.out.println(menuItem.getName() + ", " + menuItem.getPrice() + " -- " + menuItem.getDescription());
//        }
//    }

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
