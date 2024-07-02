package org.example;

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton);
        System.out.println(singleton2);
        singleton.doSomething();

        NoSingleton noSingleton = new NoSingleton();
        NoSingleton noSingleton2 = new NoSingleton();
        System.out.println(noSingleton);
        System.out.println(noSingleton2);
    }
}