package com.example.reflection;

import com.example.reflection.data.Car;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class FieldTest {
    @Test
    void testGetFields() {
        Class<Car> carClass = Car.class;

        Field[] fields = carClass.getDeclaredFields();
        for(Field field : fields) {
            System.out.println(field.getName() + " - " + field.getType().getSimpleName());
        }
    }

    @Test
    void testGetFieldValue() throws NoSuchFieldException, IllegalAccessException {
        Class<Car> carClass = Car.class;
        Field carBrand = carClass.getDeclaredField("brand");
        carBrand.setAccessible(true);

        Car car1 = new Car("BMW", "X5", 2020);
        String result = (String) carBrand.get(car1);
        System.out.println(result);

        Car car2 = new Car("Audi", "Q7", 2021);
        String result2 = (String) carBrand.get(car2);
        System.out.println(result2);
    }

    @Test
    void testSetFieldValue() throws NoSuchFieldException, IllegalAccessException {
        Class<Car> carClass = Car.class;
        Field carBrand = carClass.getDeclaredField("brand");
        carBrand.setAccessible(true);

        Car car1 = new Car("BMW", "X5", 2020);
        carBrand.set(car1, "Mercedes");
        System.out.println(car1.getBrand());

        Car car2 = new Car("Audi", "Q7", 2021);
        carBrand.set(car2, "Volkswagen");
        System.out.println(car2.getBrand());
    }
}
