package com.example.demo;

import com.example.demo.model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DuplicateTest {

    @Test
    void testErrorDuplicateBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);
        // the log will be printed here even though we haven't called the method yet

        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            Car car = context.getBean(Car.class);
        });
    }

    @Test
    void testDuplicateBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);

        Car car1 = context.getBean("car1", Car.class);
        Car car2 = context.getBean("car2", Car.class);
        Assertions.assertNotSame(car1, car2);
    }
}
