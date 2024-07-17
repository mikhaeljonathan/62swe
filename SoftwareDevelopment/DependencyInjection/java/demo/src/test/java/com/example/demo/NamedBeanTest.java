package com.example.demo;

import com.example.demo.model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NamedBeanTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void testPrimaryBean() {
        applicationContext = new AnnotationConfigApplicationContext(NamedBeanConfiguration.class);
    }

    @Test
    void testNamedBean() {
        Car car = applicationContext.getBean(Car.class);
        Car car1 = applicationContext.getBean("first car", Car.class);
        Car car2 = applicationContext.getBean("second car", Car.class);

        Assertions.assertSame(car, car1);
        Assertions.assertNotSame(car, car2);
        Assertions.assertNotSame(car1, car2);
    }
}
