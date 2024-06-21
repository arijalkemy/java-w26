package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.controller;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.product.LocationForProductDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.product.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.warehouse.SectionResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.warehouse.StockQuantityResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.service.interfaces.IProductService;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.DataUtils;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.TestDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {


    @Mock
    private IProductService productService;

    @InjectMocks
    private ProductController productController;

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

    @Test
    @DisplayName("Test getBatchListByProduct - Happy Path")
    void testGetBatchListByProduct_HappyPath() {

        Long idProduct = 1L;
        String order = null;

        LocationForProductDTO expectedResponse = new LocationForProductDTO();
        expectedResponse.setProductId(idProduct);
        SectionResponseDTO section = new SectionResponseDTO();
        section.setSectionCode(1);
        section.setWarehouseCode(1);
        expectedResponse.setSection(section);
        expectedResponse.setBatchStock(Collections.emptyList());

        when(productService.checkLocationForProduct(idProduct, order)).thenReturn(expectedResponse);

        ResponseEntity<LocationForProductDTO> output = productController.getBatchListByProduct(idProduct, order);
        assertEquals(HttpStatus.OK, output.getStatusCode());
        assertEquals(expectedResponse, output.getBody());
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
        Assertions.assertFalse(response_stockQuantityResponseDto.getWarehouses().isEmpty());

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

    @Test
    @DisplayName("Test getBatchListByProduct - Not Found")
    void testGetBatchListByProduct_NotFound() {
        // Arrange
        Long idProduct = 1989L;
        String order = null;
        when(productService.checkLocationForProduct(idProduct, order)).thenThrow(new NotFoundException("The product was not found in any of the batches"));
        // Act - Assert
        NotFoundException exception = assertThrows(NotFoundException.class, () -> productController.getBatchListByProduct(idProduct, order));
        assertEquals("The product was not found in any of the batches", exception.getMessage());
    }
}
