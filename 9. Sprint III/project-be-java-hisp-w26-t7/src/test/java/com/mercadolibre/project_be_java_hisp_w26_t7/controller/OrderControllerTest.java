package com.mercadolibre.project_be_java_hisp_w26_t7.controller;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.ProductResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.OrderServiceImpl;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.DataUtils;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @Mock
    private OrderServiceImpl orderService;

    @InjectMocks
    private OrderController orderController;

    @Test
    @DisplayName("Test - get products by order with id 1")
    void getProductsByOrderWithId1Test() {
        // Arrange
        Long id = 1L;
        List<ProductResponseDTO> productResponseDTOS = DataUtils.getProductsResponseDTO();
        when(orderService.findProductsByOrder(id)).thenReturn(productResponseDTOS);
        // Act
        ResponseEntity<List<ProductResponseDTO>> result = orderController.getProductsByOrder(id);
        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(productResponseDTOS, result.getBody());
    }

}
