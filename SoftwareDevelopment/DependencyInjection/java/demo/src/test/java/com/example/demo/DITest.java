package com.example.demo;

import com.example.demo.model.Car;
import com.example.demo.model.Engine;
import com.example.demo.model.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DITest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(DIConfiguration.class);
    }

    @Test
    void testNoDI() {
        Car car = new Car();
        Engine engine = new Engine();

        Factory factory = new Factory(car, engine);

        Assertions.assertSame(car, factory.getCar());
        Assertions.assertSame(engine, factory.getEngine());
    }

    @Test
    void testDI() {
        Factory factory = applicationContext.getBean(Factory.class);
        Car car = applicationContext.getBean(Car.class);
        Engine engine = applicationContext.getBean(Engine.class);

        Assertions.assertSame(car, factory.getCar());
        Assertions.assertSame(engine, factory.getEngine());
    }

    @Test
    void testDIWithQualifier() {
        Car firstCar = applicationContext.getBean(Car.class);
        Car secondCar = applicationContext.getBean("secondCar", Car.class);
        Engine engine = applicationContext.getBean(Engine.class);
        Factory factory = applicationContext.getBean(Factory.class);

        Assertions.assertSame(secondCar, factory.getCar());
        Assertions.assertSame(engine, factory.getEngine());
        Assertions.assertNotSame(firstCar, factory.getCar());
    }
}
