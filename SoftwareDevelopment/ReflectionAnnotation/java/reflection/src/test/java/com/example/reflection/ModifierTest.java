package com.example.reflection;

import com.example.reflection.data.Car;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

public class ModifierTest {

    @Test
    void testModifier() {
        Class<Car> carClass = Car.class;

        System.out.println(Modifier.isPublic(carClass.getModifiers()));
        System.out.println(Modifier.isFinal(carClass.getModifiers()));
        System.out.println(Modifier.isAbstract(carClass.getModifiers()));
        System.out.println(Modifier.isStatic(carClass.getModifiers()));
    }
}
