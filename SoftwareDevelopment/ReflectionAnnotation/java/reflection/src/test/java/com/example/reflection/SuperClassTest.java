package com.example.reflection;

import com.example.reflection.data.Car;
import org.junit.jupiter.api.Test;

public class SuperClassTest {
    @Test
    void testGetSuperClass() {
        Class<Car> carClass = Car.class;
        System.out.println(carClass);

        Class<? super Car> objectClass = carClass.getSuperclass();
        System.out.println(objectClass);

        Class<? super Car> nullClass = objectClass.getSuperclass();
        System.out.println(nullClass);
    }
}
