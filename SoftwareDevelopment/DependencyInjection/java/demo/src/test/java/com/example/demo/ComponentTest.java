package com.example.demo;

import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
    }


    @Test
    void testComponent() {
        ProductService productService1 = applicationContext.getBean(ProductService.class);
        ProductService productService2 = applicationContext.getBean("productService", ProductService.class);

        Assertions.assertNotNull(productService1);
        Assertions.assertNotNull(productService2);
        Assertions.assertSame(productService1, productService2);
    }

    @Test
    void testConstructorDI() {
        ProductService productService = applicationContext.getBean(ProductService.class);
        ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);

        Assertions.assertSame(productService.getProductRepository(), productRepository);
    }

    @Test
    void testSetterDI() {
        CategoryService categoryService = applicationContext.getBean(CategoryService.class);
        CategoryRepository categoryRepository = applicationContext.getBean(CategoryRepository.class);

        Assertions.assertSame(categoryService.getCategoryRepository(), categoryRepository);
    }

    @Test
    void testFieldDI () {
        CustomerService customerService = applicationContext.getBean(CustomerService.class);
        CustomerRepository customerRepository = applicationContext.getBean(CustomerRepository.class);

        Assertions.assertSame(customerService.getCustomerRepository(), customerRepository);
    }
}
