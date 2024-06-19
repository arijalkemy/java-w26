package com.mercadolibre.sprint3_individual_perez.unit.service;

import com.mercadolibre.sprint3_individual_perez.dto.request.CartDTO;
import com.mercadolibre.sprint3_individual_perez.dto.request.OrderStatusDTO;
import com.mercadolibre.sprint3_individual_perez.dto.request.ProductDTO;
import com.mercadolibre.sprint3_individual_perez.dto.request.PurchaseOrderDTO;
import com.mercadolibre.sprint3_individual_perez.dto.response.CartWithErrorsResponseDTO;
import com.mercadolibre.sprint3_individual_perez.entity.BatchStock;
import com.mercadolibre.sprint3_individual_perez.entity.Product;
import com.mercadolibre.sprint3_individual_perez.entity.User;
import com.mercadolibre.sprint3_individual_perez.enums.Rol;
import com.mercadolibre.sprint3_individual_perez.exceptions.ApiError;
import com.mercadolibre.sprint3_individual_perez.exceptions.ApiException;
import com.mercadolibre.sprint3_individual_perez.repository.*;
import com.mercadolibre.sprint3_individual_perez.service.InboundOrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InboundorderServiceTest {

    @Mock
    IProductRepository productRepository;

    @Mock
    IBatchStockRepository batchStockRepository;

    @Mock
    ICartRepository cartRepository;

    @Mock
    IUserRepository userRepository;

    @Mock
    IProductInCartRepository productInCartRepository;

    @InjectMocks
    InboundOrderServiceImpl inboundOrderService;

    private static CartDTO cartDTO = new CartDTO();


    @BeforeAll
    static void init() {
        String str = "2015-03-31";
        Date date = Date.valueOf(str);
        ProductDTO productDTO0 = new ProductDTO();
        productDTO0.setIdProduct(1);
        productDTO0.setQuantity(3);
        ProductDTO productDTO1 = new ProductDTO();
        productDTO1.setIdProduct(2);
        productDTO1.setQuantity(5);
        OrderStatusDTO orderStatusDTO = new OrderStatusDTO();
        orderStatusDTO.setStatus_code("CARRITO");
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO(
                date,
                1,
                orderStatusDTO,
                List.of(
                        productDTO0,
                        productDTO1));
        cartDTO.setPurchaseOrder(purchaseOrderDTO);
    }

    /**
     * Test of adding a cart
     */
    @Test
    @DisplayName("Test of adding a cart")
    public void testCreateInBoundOrder(){
        //Arrange
        Product product0 = Product.builder()
                .id(1L)
                .name("Product 1")
                .price(10.0)
                .build();
        BatchStock batchStock0 = new BatchStock();
        batchStock0.setId(1L);
        batchStock0.setCurrentQuantity(10);
        batchStock0.setProduct(product0);
        Product product1 = Product.builder()
                .id(2L)
                .name("Product 2")
                .price(20.0)
                .build();
        BatchStock batchStock1 = new BatchStock();
        batchStock1.setId(2L);
        batchStock1.setCurrentQuantity(20);
        batchStock1.setProduct(product1);
        Rol rol = Rol.USER;
        User user = User.builder()
                .id(1L)
                .role(rol)
                .build();
        //Act
        when(userRepository.findById(1L)).thenReturn(Optional.of((user)));
        when(productRepository.findById(1L)).thenReturn(Optional.of(product0));
        when(productRepository.findById(2L)).thenReturn(Optional.of(product1));
        when(batchStockRepository.getBatchStocksByProductId(1L)).thenReturn(List.of(batchStock0));
        when(batchStockRepository.getBatchStocksByProductId(2L)).thenReturn(List.of(batchStock1));

        CartWithErrorsResponseDTO expectedCartWithErrorsResponseDTO = new CartWithErrorsResponseDTO(130.0);
        CartWithErrorsResponseDTO actualResponse = inboundOrderService.createInBoundOrder(cartDTO);
        //Assert
        Assertions.assertEquals(expectedCartWithErrorsResponseDTO, actualResponse);
    }

    /**
     * Test of product not in stock
     */
    @Test
    @DisplayName("Test of product not in stock")
    public void testProductsNotInStock(){
        //Arrange
        Product product0 = Product.builder()
                .id(1L)
                .name("Product 1")
                .price(10.0)
                .build();
        BatchStock batchStock0 = new BatchStock();
        batchStock0.setId(1L);
        batchStock0.setCurrentQuantity(1);
        batchStock0.setProduct(product0);
        Product product1 = Product.builder()
                .id(2L)
                .name("Product 2")
                .price(20.0)
                .build();
        BatchStock batchStock1 = new BatchStock();
        batchStock1.setId(2L);
        batchStock1.setCurrentQuantity(1);
        batchStock1.setProduct(product1);
        Rol rol = Rol.USER;
        User user = User.builder()
                .id(1L)
                .role(rol)
                .build();
        List<ApiError> errors = List.of(
                new ApiError("Not enough stock", "Not enough stock in the batches with product Product 1, missing 2", 404),
                new ApiError("Not enough stock", "Not enough stock in the batches with product Product 2, missing 4", 404)
        );
        //Act
        when(userRepository.findById(1L)).thenReturn(Optional.of((user)));
        when(productRepository.findById(1L)).thenReturn(Optional.of(product0));
        when(productRepository.findById(2L)).thenReturn(Optional.of(product1));
        when(batchStockRepository.getBatchStocksByProductId(1L)).thenReturn(List.of(batchStock0));
        when(batchStockRepository.getBatchStocksByProductId(2L)).thenReturn(List.of(batchStock1));

        CartWithErrorsResponseDTO expectedCartWithErrorsResponseDTO = new CartWithErrorsResponseDTO(errors);
        CartWithErrorsResponseDTO actualCartWithErrorsResponseDTO = inboundOrderService.createInBoundOrder(cartDTO);
        //Assert
        Assertions.assertNotNull(expectedCartWithErrorsResponseDTO);
        Assertions.assertEquals(expectedCartWithErrorsResponseDTO.getErrors().size()
                ,actualCartWithErrorsResponseDTO.getErrors().size());
        for (int i = 0; i < expectedCartWithErrorsResponseDTO.getErrors().size(); i++) {
            ApiError expectedError = expectedCartWithErrorsResponseDTO.getErrors().get(i);
            ApiError actualError = actualCartWithErrorsResponseDTO.getErrors().get(i);
            Assertions.assertEquals(actualError.getError(),expectedError.getError());
            Assertions.assertEquals(actualError.getMessage(),expectedError.getMessage());
            Assertions.assertEquals(actualError.getStatus(),expectedError.getStatus());
        }
    }


    /**
     * Test of user not found
     */
    @Test
    @DisplayName("Test of user not found")
    public void testUserNotFound(){
        //Act
        when(userRepository.findById(1L)).thenReturn(Optional.empty());
        //Assert
        Assertions.assertThrows(ApiException.class, () -> inboundOrderService.createInBoundOrder(cartDTO));
    }

    /**
     * Test of user not having the role USER
     */
    @Test
    @DisplayName("Test of not being a user")
    public void testOfNotAUser(){
        //Arrange
        Rol rol = Rol.ADMIN;
        User user = User.builder()
                .id(1L)
                .role(rol)
                .build();
        //Act
        when(userRepository.findById(1L)).thenReturn(Optional.of((user)));
        //Assert
        Assertions.assertThrows(ApiException.class, () -> inboundOrderService.createInBoundOrder(cartDTO));
    }

    @Test
    @DisplayName("If the id Product don't exist")
    public void testUpdateWithExceptionByProduct(){
        CartDTO cartDTO = new CartDTO();

        String str = "2024-03-10";
        Date date = Date.valueOf(str);
        ProductDTO productDTO0 = new ProductDTO();
        productDTO0.setIdProduct(9999); //This Drops an Exception
        productDTO0.setQuantity(3);
        OrderStatusDTO orderStatusDTO = new OrderStatusDTO();
        orderStatusDTO.setStatus_code("CARRITO");
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO(
                date,
                1,
                orderStatusDTO,
                List.of(productDTO0));
        cartDTO.setPurchaseOrder(purchaseOrderDTO);
        //Act
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(User.builder()
                .id(1L)
                .role(Rol.USER)
                .build()));
        // Act
        CartWithErrorsResponseDTO response = inboundOrderService.createInBoundOrder(cartDTO);

        // Assert
        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.getErrors().isEmpty());
        Assertions.assertEquals("Product not found", response.getErrors().get(0).getMessage());
    }

    @Test
    @DisplayName("Update function")
    public void TestUpdateFunctionToCarts(){
        //Arrange
        Product product0 = Product.builder()
                .id(1L)
                .name("Product 1")
                .price(10.0)
                .build();
        BatchStock batchStock0 = new BatchStock();
        batchStock0.setId(1L);
        batchStock0.setCurrentQuantity(10);
        batchStock0.setProduct(product0);
        Product product1 = Product.builder()
                .id(2L)
                .name("Product 2")
                .price(20.0)
                .build();
        BatchStock batchStock1 = new BatchStock();
        batchStock1.setId(2L);
        batchStock1.setCurrentQuantity(100);
        batchStock1.setProduct(product1);

        //Act
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(User.builder()
                .id(1L)
                .role(Rol.USER)
                .build()));
        when(productRepository.findById(1L)).thenReturn(Optional.of(product0));
        when(productRepository.findById(2L)).thenReturn(Optional.of(product1));
        when(batchStockRepository.getBatchStocksByProductId(1L)).thenReturn(List.of(batchStock0));
        when(batchStockRepository.getBatchStocksByProductId(2L)).thenReturn(List.of(batchStock1));

        // Act
        CartWithErrorsResponseDTO response = inboundOrderService.updateInBoundOrder(cartDTO,1L);

        // Assert
        Assertions.assertNotNull(response);
        //Total price = (10*3) + (20*5) = 130
        Assertions.assertEquals(130.0d, response.getTotalPrice());
    }



}
