package com.example.demo.model.cyclic;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CyclicB {
    private CyclicC cyclicC;
}
