package com.example.demo;

import com.example.demo.model.Car;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LazyBeanTest {
    @Test
    public void testLazyBean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(LazyBeanConfiguration.class);
    }
}
