package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CyclicTest {

    @Test
    public void testCyclic() {
        Assertions.assertThrows(UnsatisfiedDependencyException.class, () -> {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CyclicConfiguration.class);
        });

    }
}
