package org.example;

public class Singleton {
    private static Singleton instance = null;
    private Singleton() {}

    public synchronized static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Doing something...");
    }
}
