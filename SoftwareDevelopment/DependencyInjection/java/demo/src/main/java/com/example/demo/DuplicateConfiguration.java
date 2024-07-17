package com.example.demo;

import com.example.demo.model.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DuplicateConfiguration {

    @Bean
    public Car car1() {
        return new Car();
    }

    @Bean
    public Car car2() {
        return new Car();
    }
}
