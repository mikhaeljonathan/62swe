package com.example.demo;

import com.example.demo.model.Car;
import com.example.demo.model.Engine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

@Slf4j
@Configuration
public class LazyBeanConfiguration {

    @Bean
    @DependsOn({"engine"})
    @Lazy
    public Car car() {
        log.info("Creating car bean");
        return new Car();
    }

    @Bean
    public Engine engine() {
        log.info("Creating engine bean");
        return new Engine();
    }

}
