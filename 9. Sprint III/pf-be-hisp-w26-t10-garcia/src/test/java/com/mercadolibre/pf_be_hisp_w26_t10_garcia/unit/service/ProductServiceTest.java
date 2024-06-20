package com.mercadolibre.pf_be_hisp_w26_t10_garcia.unit.service;

import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.repository.*;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.service.implementations.ProductServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.util.EntitiesUtilsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private IProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;


    @DisplayName("Service product not found")
    @Test
    public void productNotFoundTest() {
        //Arrange
        Optional<Product> productOptional = Optional.empty();
        when(productRepository.findById(1000)).thenReturn(productOptional);

        //Act
        //Assert
        Assertions.assertThrows(NotFoundException.class, () -> productService.findById(1000));

    }

    @DisplayName("Service product")
    @Test
    public void productTest() {
        //Arrange
        Optional<Product> productOptional = Optional.of(EntitiesUtilsTest.mazanaProduct());
        Product product;
        when(productRepository.findById(1000)).thenReturn(productOptional);

        //Act
        product = productService.findById(1000);

        //Assert
        Assertions.assertEquals(productOptional.get(),product);

    }




}
