package com.meli.be_java_hisp_w26_g09.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w26_g09.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductRepositoryImplTest {
    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private ProductRepositoryImpl productRepository;

    @BeforeEach
    public void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);
        productRepository = new ProductRepositoryImpl();

        File file = ResourceUtils.getFile("classpath:products_generated.json");
        List<Product> products = new ArrayList<>();
        when(objectMapper.readValue(file, new TypeReference<List<Product>>() {})).thenReturn(products);
    }

    @Test
    @DisplayName("Test isCreated")
    void testIsCreated() {
        Product product = new Product();
        product.setProductId(1);
        product.setProductName("Sample Product");

        assertFalse(productRepository.isCreated(product));

        productRepository.createProduct(product);

        assertTrue(productRepository.isCreated(product));
    }
}