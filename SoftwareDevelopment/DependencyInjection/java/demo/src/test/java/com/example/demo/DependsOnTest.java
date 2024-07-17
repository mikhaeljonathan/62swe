package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependsOnTest {

    @Test
    void testDependsOn() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DependsOnConfiguration.class);
    }
}
