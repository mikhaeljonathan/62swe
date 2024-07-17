package com.example.reflection;

import com.example.reflection.data.Car;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParameterTest {

    @Test
    void getGetParameters() {
        Class<Car> carClass = Car.class;
        Method[] methods = carClass.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Parameter Name : " + parameter.getName());
                System.out.println("Parameter Type : " + parameter.getType().getName());
            }
            System.out.println("====================================");
        }
    }

    @Test
    void testInvokeMethodWithParameter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Car> carClass = Car.class;
        Method setBrand = carClass.getDeclaredMethod("setBrand", String.class);

        Car car = new Car("BMW", "X5", 2020);
        setBrand.invoke(car, "Mercedes");

        System.out.println(car.getBrand());
    }
}
