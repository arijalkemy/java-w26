package com.mercadolibre.pf_be_hisp_w26_t1_cassini.unit.controller;

import com.mercadolibre.pf_be_hisp_w26_t1_cassini.authentication.AuthenticationService;

import com.mercadolibre.pf_be_hisp_w26_t1_cassini.controller.ProductController;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.BatchWrongTemperatureRespDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.enums.BatchOrderType;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces.IBatchService;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces.IProductService;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.utils.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    private IProductService productService;

    @InjectMocks
    private ProductController productController;


    @Test
    void getAllPRoducts(){
        when(productService.getAll()).thenReturn(TestUtil.getProductList());


        ResponseEntity<List<ProductResponseDTO>> result = productController.getAllProducts();

        //Assertions
        Assertions.assertEquals(200, result.getStatusCode().value());

    }




}
