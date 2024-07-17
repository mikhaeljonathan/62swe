package com.example.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.example.demo.imports"
})
public class ComponentScanConfiguration {
}
