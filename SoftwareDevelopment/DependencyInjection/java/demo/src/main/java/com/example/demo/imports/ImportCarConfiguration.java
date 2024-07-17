package com.example.demo.imports;

import com.example.demo.model.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImportCarConfiguration {

    @Bean
    public Car car() {
        return new Car();
    }
}
