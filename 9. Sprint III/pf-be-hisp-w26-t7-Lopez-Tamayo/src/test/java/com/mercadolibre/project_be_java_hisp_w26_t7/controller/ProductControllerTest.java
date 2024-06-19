package com.mercadolibre.project_be_java_hisp_w26_t7.controller;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.ProductResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.warehouse.StockQuantityResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.exceptions.NotFoundException;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.ProductServiceImpl;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.DataUtils;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.TestDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductServiceImpl productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Debería retornar un ResponseEntity con estado 200 y con ProductResponseDTO de todas las categorías")
    void getAllProductsWithCategoryNullTest() {
        // Arrange
        List<ProductResponseDTO> expected = DataUtils.getProductsResponseDTO();
        when(productService.getProducts(null)).thenReturn(expected);

        // Act
        ResponseEntity<List<ProductResponseDTO>> output = productController.getAllProducts(null);

        // Assert
        assertEquals(HttpStatus.OK, output.getStatusCode());
        assertEquals(expected, output.getBody());

    }

    @Test
    @DisplayName("Debería retornar un ResponseEntity con estado 200 y con ProductResponseDTO de una sola categoría")
    void getAllProductsWithCategoryTest() {
        // Arrange
        String category = "FS";
        List<ProductResponseDTO> expected = DataUtils.getProductsFreshDTO();
        when(productService.getProducts(category)).thenReturn(expected);

        // Act
        ResponseEntity<List<ProductResponseDTO>> output = productController.getAllProducts(category);

        // Assert
        assertEquals(HttpStatus.OK, output.getStatusCode());
        assertEquals(expected, output.getBody());

    }

//    @Test
//    void getBatchListByProductTest() {
//        // Arrange
//        when(productService.findBatchListByProduct(null, null)).thenReturn(null);
//        // Act
//        productController.getBatchListByProduct(null, null);
//        // Assert
//
//    }
    @Test
    void getAllProductsTest() {
        // Arrange
        when(productService.getProducts(null)).thenReturn(null);
        // Act
        productController.getAllProducts(null);
        // Assert

    }

    @Test
    void getBatchListByProductTest() {
        // Arrange
        when(productService.findBatchListByProduct(null, null)).thenReturn(null);
        // Act
        productController.getBatchListByProduct(null, null);
        // Assert

    }

    @Test
    @DisplayName("Test - Verification of the response for a product seller with ID 1")
    void getStockQuantityForEachWarehouseTest() {
        // Arrange
        Long id = 1L;
        StockQuantityResponseDto stockQuantityResponseDto = TestDataGenerator.getStockQuantityResponseDto();

        when(productService.findStockQuantityForEachWarehouse(id)).thenReturn(stockQuantityResponseDto);
        // Act
        ResponseEntity response = productController.getStockQuantityForEachWarehouse(id);

        StockQuantityResponseDto response_stockQuantityResponseDto =
                (StockQuantityResponseDto) response.getBody();

        // Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertInstanceOf(StockQuantityResponseDto.class, response_stockQuantityResponseDto);
        Assertions.assertNotNull(response_stockQuantityResponseDto);

        Assertions.assertNotNull(response_stockQuantityResponseDto.getWarehouses());
        Assertions.assertInstanceOf(List.class, response_stockQuantityResponseDto.getWarehouses());
        Assertions.assertTrue(!response_stockQuantityResponseDto.getWarehouses().isEmpty());

        Assertions.assertEquals(stockQuantityResponseDto.toString(), response_stockQuantityResponseDto.toString());

    }

    @Test
    @DisplayName("Test - Verification of the exception response for a product seller with ID 1000")
    void getStockQuantityForEachWarehouseTestException() {
        // Arrange
        Long id = 1000L;

        when(productService.findStockQuantityForEachWarehouse(id)).thenThrow(NotFoundException.class);
        // Act-Assert
        Assertions.assertThrows(NotFoundException.class, () -> productController.getStockQuantityForEachWarehouse(id));
    }

}