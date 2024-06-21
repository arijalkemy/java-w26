package com.mercadolibre.project_be_java_hisp_w26_t7.unit.controller;

import com.mercadolibre.project_be_java_hisp_w26_t7.controller.OrderController;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.others.TotalPriceResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.PurchaseOrderRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {
    @Mock
    private OrderServiceImpl orderService;
    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Ok create product list")
    void createProductListTest_Ok() {
        // Arrange
        Double mockPrice = 127.22;
        TotalPriceResponseDTO responseDTO = TotalPriceResponseDTO
                .builder()
                .totalPrice(mockPrice)
                .build();
        PurchaseOrderRequestDTO requestDTO = PurchaseOrderRequestDTO.builder().build();
        Mockito.when(orderService.saveProductList(requestDTO)).thenReturn(responseDTO);
        // Act
        ResponseEntity<TotalPriceResponseDTO> controllerResponse = orderController.createProductList(requestDTO);
        // Assert
        Assertions.assertEquals(HttpStatus.CREATED, controllerResponse.getStatusCode());
        Assertions.assertEquals(responseDTO, controllerResponse.getBody());
    }

    @Test
    void getProductsByOrderTest() {
        // Arrange
        Mockito.when(orderService.findProductsByOrder(null)).thenReturn(null);
        // Act
        orderController.getProductsByOrder(null);
        // Assert

    }

    @Test
    void updateProductListTest() {
        // Arrange
        Mockito.when(orderService.updateProductList(null, null)).thenReturn(null);
        // Act
        orderController.updateProductList(null, null);
        // Assert

    }
}
