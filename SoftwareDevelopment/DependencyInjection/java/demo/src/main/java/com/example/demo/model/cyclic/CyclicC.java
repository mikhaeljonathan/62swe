package com.example.demo.model.cyclic;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;

@AllArgsConstructor
@Data
public class CyclicC {
    private CyclicA cyclicA;
}
