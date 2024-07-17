package com.example.reflection;

import com.example.reflection.data.Car;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ClassTest {
    @Test
    void testCreateClass() throws ClassNotFoundException {
        Class<Car> carClass1 = Car.class;

        Class<?> carClass2 = Class.forName("com.example.reflection.data.Car");

        Car carClass = new Car("BMW", "X5", 2020);
        Class<? extends Car> carClass3 = carClass.getClass();
    }

    @Test
    void classMethod() throws NoSuchMethodException {
        Class<Car> carClass = Car.class;

        System.out.println(carClass.getSuperclass());
        System.out.println(Arrays.toString(carClass.getInterfaces()));
        System.out.println(Arrays.toString(carClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(carClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(carClass.getDeclaredFields()));
        System.out.println(carClass.getModifiers());
        System.out.println(carClass.getPackage());
        System.out.println(carClass.getName());
        System.out.println(carClass.getSimpleName());
    }
}
