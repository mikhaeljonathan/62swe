package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Factory {
    private Car car;
    private Engine engine;
}
