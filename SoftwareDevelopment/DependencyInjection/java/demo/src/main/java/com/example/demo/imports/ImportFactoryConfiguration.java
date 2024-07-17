package com.example.demo.imports;

import com.example.demo.model.Car;
import com.example.demo.model.Engine;
import com.example.demo.model.Factory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImportFactoryConfiguration {
    @Bean
    public Factory factory(Car car, Engine engine) {
        return new Factory(car, engine);
    }
}
