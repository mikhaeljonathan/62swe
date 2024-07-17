package com.example.demo;

import com.example.demo.model.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class NamedBeanConfiguration {

    @Primary
    @Bean(name = "first car")
    public Car car1() {
        return new Car();
    }

    @Bean(name = "second car")
    public Car car2() {
        return new Car();
    }

}
