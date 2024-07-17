package com.example.reflection;

import com.example.reflection.data.Car;
import com.example.reflection.validation.Validator;
import org.junit.jupiter.api.Test;

public class AnnotationTest {
    @Test
    void testValidateUsingAnnotation() {
        Car car = new Car("BMW", "X5", 2020);
        Validator.validateNotBlank(car);
    }
}
