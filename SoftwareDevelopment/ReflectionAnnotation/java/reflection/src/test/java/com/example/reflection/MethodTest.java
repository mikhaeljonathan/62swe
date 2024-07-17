package com.example.reflection;

import com.example.reflection.data.Car;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodTest {

    @Test
    void testGetMethods() {
        Class<Car> carClass = Car.class;

        Method[] methods = carClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(Arrays.toString(method.getParameterTypes()));
            System.out.println(Arrays.toString(method.getExceptionTypes()));
            System.out.println("====================================");
        }
    }

    @Test
    void testGetMethodValue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Car> carClass = Car.class;
        Method getBrand = carClass.getDeclaredMethod("getBrand");

        Car car1 = new Car("BMW", "X5", 2020);
        String carBrand = (String) getBrand.invoke(car1);
        System.out.println(carBrand);
    }
}
