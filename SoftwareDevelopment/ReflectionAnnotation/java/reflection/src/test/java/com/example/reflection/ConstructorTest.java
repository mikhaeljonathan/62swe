package com.example.reflection;

import com.example.reflection.data.Car;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ConstructorTest {

    @Test
    void testGetConstructors() {
        Class<Car> carClass = Car.class;

        Constructor<?>[] constructors = carClass.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
            System.out.println(Arrays.toString(constructor.getParameterTypes()));
            System.out.println("====================================");
        }
    }

    @Test
    void testCreateObjectUsingConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Car> carClass = Car.class;
        Constructor<Car> constructor = carClass.getConstructor();
        Constructor<Car> constructorParameters = carClass.getConstructor(String.class, String.class, int.class);

        Car car1 = constructor.newInstance();
        Car car2 = constructorParameters.newInstance("BMW", "X5", 2020);

        System.out.println(car1);
        System.out.println(car2);
    }

}
