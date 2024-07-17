package com.example.reflection;

import com.example.reflection.data.Car;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InterfaceTest {

    @Test
    void testClass() {
        Class<Drivable> drivableClass = Drivable.class;
        System.out.println(drivableClass.getName());
        System.out.println(drivableClass.isInterface());
        System.out.println(drivableClass.getSuperclass());
        System.out.println(Arrays.toString(drivableClass.getInterfaces()));
        System.out.println(Arrays.toString(drivableClass.getDeclaredFields()));
        System.out.println(Arrays.toString(drivableClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(drivableClass.getDeclaredConstructors()));
    }

    @Test
    void testSuperInterface() {
        Class<Car> carClass = Car.class;
        System.out.println(Arrays.toString(carClass.getInterfaces()));
    }
}
