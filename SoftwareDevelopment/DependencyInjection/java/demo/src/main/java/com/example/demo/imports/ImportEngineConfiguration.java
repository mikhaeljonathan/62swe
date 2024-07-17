package com.example.demo.imports;

import com.example.demo.model.Engine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImportEngineConfiguration {
    @Bean
    public Engine engine() {
        return new Engine();
    }
}
