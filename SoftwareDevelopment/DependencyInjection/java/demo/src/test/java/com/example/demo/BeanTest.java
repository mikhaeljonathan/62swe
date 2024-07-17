package com.example.demo;

import com.example.demo.model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {

    @Test
    void testCreateBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        // the log will be printed here even though we haven't called the method yet

        Car car1 = context.getBean(Car.class);
        Car car2 = context.getBean(Car.class);
        Assertions.assertSame(car1, car2);
    }
}
