package com.example.demo.service;

import com.example.demo.repository.CustomerRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {

    @Getter
    @Autowired
    private CustomerRepository customerRepository;
}
