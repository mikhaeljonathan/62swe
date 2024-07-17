package com.example.demo;

import com.example.demo.model.Car;
import com.example.demo.model.Engine;
import com.example.demo.model.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentScanTest {
    @Test
    void testComponentScan() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanConfiguration.class);

        Car car = applicationContext.getBean(Car.class);
        Engine engine = applicationContext.getBean(Engine.class);
        Factory factory = applicationContext.getBean(Factory.class);

        Assertions.assertNotNull(car);
        Assertions.assertNotNull(engine);
        Assertions.assertNotNull(factory);
    }
}
