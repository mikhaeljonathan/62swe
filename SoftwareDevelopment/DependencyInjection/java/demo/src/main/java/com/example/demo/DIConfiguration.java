package com.example.demo;

import com.example.demo.model.Car;
import com.example.demo.model.Engine;
import com.example.demo.model.Factory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DIConfiguration {

    @Primary
    @Bean
    public Car firstCar() {
        return new Car();
    }

    @Bean
    public Car secondCar() {
        return new Car();
    }

    @Bean
    public Engine engine() {
        return new Engine();
    }

    @Bean
    public Factory factory(@Qualifier("secondCar") Car car, Engine engine) {
        return new Factory(car, engine);
    }

}
