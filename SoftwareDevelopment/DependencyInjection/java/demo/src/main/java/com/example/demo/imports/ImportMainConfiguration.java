package com.example.demo.imports;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        ImportCarConfiguration.class,
        ImportEngineConfiguration.class,
        ImportFactoryConfiguration.class
})
public class ImportMainConfiguration {
}
