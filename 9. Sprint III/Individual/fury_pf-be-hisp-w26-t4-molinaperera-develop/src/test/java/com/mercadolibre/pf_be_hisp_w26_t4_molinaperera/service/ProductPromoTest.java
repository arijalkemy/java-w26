package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.service;


import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response.ProductPromoDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.exceptions.ProductNotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model.*;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.repository.IBatchRepository;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.repository.IProductPromoRepository;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.repository.IProductRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductPromoTest {

    @Mock
    private IProductRepository productRepository;

    @Mock
    private IProductPromoRepository productPromoRepository;

    @Mock
    private IBatchRepository batchRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private ProductPromo productPromo;
    private Product product;
    private Batch batch;

    @BeforeEach
    public void setup() {
        productPromo = new ProductPromo();
        productPromo.setId(1L);
        productPromo.setDescription("Producto");
        productPromo.setPriceOriginal(100.0);
        productPromo.setPricePromo(80.0);
        productPromo.setStartDate(LocalDate.now());
        productPromo.setEndDate(LocalDate.now().plusWeeks(3));

         product = new Product();
        product.setId(1L);
        product.setProductType(new ProductType());
        product.setDescription("Producto");
        product.setPrice(100.0);

        batch=new Batch();
        batch.setMinimumTemperature(0.9);
        batch.setCurrentTemperature(5.2);
        batch.setCurrentQuantity(2343);
        batch.setDueDate(LocalDate.now().plusWeeks(8));
        batch.setId(1L);
        batch.setInboundOrder(new InboundOrder());
        batch.setInitialQuantity(34556);
        batch.setManufacturingDate(LocalDate.now());
        batch.setManufacturingTime(LocalDateTime.now());
        batch.setProduct(product);
    }

    @Test
    @DisplayName("Test setProductPromo - Success")
    public void testSetProductPromo() {
        when(productRepository.findById(3L)).thenReturn(Optional.of(product));
        when(productPromoRepository.save(any(ProductPromo.class))).thenReturn(productPromo);
        when(batchRepository.findByProductId(3L)).thenReturn(batch);

        ProductPromoDTO result = productService.setProductPromo(3L, 20.0);

        assertEquals(productPromo.getId(), result.getId());
        assertEquals(productPromo.getDescription(), result.getDescription());
        assertEquals(productPromo.getPriceOriginal(), result.getPriceOriginal());
        assertEquals(productPromo.getPricePromo(), result.getPricePromo());
        assertEquals(productPromo.getStartDate(), result.getStartDate());
        assertEquals(productPromo.getEndDate(), result.getEndDate());

        verify(productRepository, times(1)).findById(3L);
        verify(productPromoRepository, times(1)).save(any(ProductPromo.class));
    }
    @DisplayName("Test setProductPromo - Success")
    @Test
    public void testGetProductPromoList() {
        when(productPromoRepository.findAll()).thenReturn(Arrays.asList(productPromo));

        List<ProductPromoDTO> result = productService.getProductPromoList();


        assertEquals(1, result.size());
        assertEquals(productPromo.getId(), result.get(0).getId());
        assertEquals(productPromo.getProductType(), result.get(0).getProductType());
        assertEquals(productPromo.getDescription(), result.get(0).getDescription());
        assertEquals(productPromo.getPriceOriginal(), result.get(0).getPriceOriginal());
        assertEquals(productPromo.getPricePromo(), result.get(0).getPricePromo());
        assertEquals(productPromo.getStartDate(), result.get(0).getStartDate());
        assertEquals(productPromo.getEndDate(), result.get(0).getEndDate());
    }

    @DisplayName("Test getProductPromoList - ProductNotFoundException")
    @Test
    public void testGetProductPromoList_whenListIsEmpty() {
        when(productPromoRepository.findAll()).thenReturn(List.of());

        assertThrows(ProductNotFoundException.class, () -> {
            productService.getProductPromoList();
        });
    }


}
