package com.example.demo.service;

import com.example.demo.repository.ProductRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//@Lazy
@Component
public class ProductService {

    @Getter
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductService(ProductRepository productRepository, String name) {
    }
}
