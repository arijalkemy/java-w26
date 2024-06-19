package com.mercadolibre.pf_be_hisp_w26_t1_cugura.unit.service;

import com.mercadolibre.pf_be_hisp_w26_t1_cugura.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.repository.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.service.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private  IProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    @Test
    void FindById_Ok(){

        //arrange
        Product p = new Product();
        p.setId(1);

        when(productRepository.findById(anyInt())).thenReturn(Optional.of(p));

        //act
        Product result = productService.findById(anyInt());

        //asserts
        Assertions.assertEquals(1,result.getId());

    }

    @Test
    void FindById_NotFound(){

        //arrange
        Product p = new Product();
        p.setId(1);

        when(productRepository.findById(anyInt())).thenReturn(Optional.empty());

        //asserts
        Assertions.assertThrows(ApiException.class, () -> productService.findById(anyInt()));

    }

    @Test
    void ExistById_True(){
        when(productRepository.existsById(anyInt())).thenReturn(true);

        boolean result = productService.exists(anyInt());

        Assertions.assertEquals(true,result);
    }

    
}
