package com.mercadolibre.project_be_java_hisp_w26_team4.service;

import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.WarehouseProductQuantityDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.WarehouseProductStockDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.exceptions.ProductNotFoundException;
import com.mercadolibre.project_be_java_hisp_w26_team4.repository.IProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IProductServiceTest {

    private final static String PRODUCT_NOT_FOUND = "Product not found";

    @Mock
    private IProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    @DisplayName("Search product stock in warehouses")
    void searchProductStockInWarehouses() {
        // Arrange
        Long productId = 1L;

        List<WarehouseProductQuantityDTO> warehouseProductQuantity = List.of(
                WarehouseProductQuantityDTO.builder()
                        .id(1L)
                        .totalQuantity(10)
                        .build(),
                WarehouseProductQuantityDTO.builder()
                        .id(2L)
                        .totalQuantity(20)
                        .build()
        );

        WarehouseProductStockDTO warehouseProductStock = WarehouseProductStockDTO.builder()
                .productId(productId)
                .warehouseProductQuantity(warehouseProductQuantity)
                .build();

        // Act
        when(productRepository.findProductQuantityInWarehouses(productId)).thenReturn(List.of(new Object[]{1L, 10}, new Object[]{2L, 20}));
        WarehouseProductStockDTO warehouseProductStockDTO = productService.searchProductStockInWarehouses(productId);

        // Assert
        assertNotNull(warehouseProductStockDTO);
        assertEquals(warehouseProductStock.getProductId(), warehouseProductStockDTO.getProductId());
        assertEquals(warehouseProductStock.getWarehouseProductQuantity().size(), warehouseProductStockDTO.getWarehouseProductQuantity().size());
    }

    @Test
    @DisplayName("Search product stock in warehouses - Product not found")
    void searchProductStockInWarehousesProductNotFound() {
        // Arrange
        Long productId = 1L;

        // Act & Assert
        when(productRepository.findProductQuantityInWarehouses(productId)).thenReturn(List.of());
        assertThrows(ProductNotFoundException.class, () -> productService.searchProductStockInWarehouses(productId));
        assertEquals(PRODUCT_NOT_FOUND, assertThrows(ProductNotFoundException.class, () -> productService.searchProductStockInWarehouses(productId)).getMessage());
    }
}