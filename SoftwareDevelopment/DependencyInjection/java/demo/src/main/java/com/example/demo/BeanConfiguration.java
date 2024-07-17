package com.example.demo;

import com.example.demo.model.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class BeanConfiguration {

    @Bean
    public Car car() {
        Car car = new Car();
        log.info("Create new car bean");
        return car;
    }
}
