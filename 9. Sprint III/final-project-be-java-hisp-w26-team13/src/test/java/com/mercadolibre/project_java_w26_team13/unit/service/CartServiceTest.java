package com.mercadolibre.project_java_w26_team13.unit.service;

import com.mercadolibre.project_java_w26_team13.dtos.CartProductDto;
import com.mercadolibre.project_java_w26_team13.dtos.CartRequestDto;
import com.mercadolibre.project_java_w26_team13.dtos.OrderStatusDto;
import com.mercadolibre.project_java_w26_team13.dtos.PurchaseOrderDto;
import com.mercadolibre.project_java_w26_team13.entity.Cart;
import com.mercadolibre.project_java_w26_team13.entity.CartDetail;
import com.mercadolibre.project_java_w26_team13.entity.Product;
import com.mercadolibre.project_java_w26_team13.exceptions.ApiException;
import com.mercadolibre.project_java_w26_team13.exceptions.ExceptionsFactory;
import com.mercadolibre.project_java_w26_team13.repository.ICartRepository;
import com.mercadolibre.project_java_w26_team13.service.CartService;
import com.mercadolibre.project_java_w26_team13.util.JWTClaims;
import com.mercadolibre.project_java_w26_team13.util.Roles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {

    @Mock
    private ICartRepository cartRepository;

    @Mock
    private JWTClaims jwtClaims;

    @InjectMocks
    private CartService cartService;

    @Test
    public void searchCartTest() {
        // Arrange
        Long orderId = 1L;
        Cart cart = Cart.builder()
                .id(orderId)
                .buyerId(1)
                .date(LocalDate.of(2024, 6, 17))
                .status("Carrito")
                .totalPrice(20.0)
                .cartDetails(List.of(
                        CartDetail.builder()
                                .product(Product.builder().id(1L).name("Producto A").price(20.0).build())
                                .unitPrice(20.0)
                                .quantity(10)
                                .id(1L)
                                .cart(
                                    Cart.builder()
                                        .id(1L)
                                        .buyerId(1)
                                        .status("Carrito")
                                        .date(LocalDate.of(2024, 6, 17))
                                        .totalPrice(200.0)
                                        .build()
                        ).build()
                )).build();

        // Mock JWTClaims
        Mockito.doNothing().when(jwtClaims).validateHeader("authorizationHeader", Roles.BUYER.getRole());

        // Mock Repository
        when(cartRepository.findById(orderId)).thenReturn(Optional.ofNullable(cart));

        // Act
        CartRequestDto got = cartService.searchCart("authorizationHeader", orderId);
        // Assert
        CartRequestDto expectedResponse = CartRequestDto.builder()
                .purchaseOrderDto(PurchaseOrderDto.builder()
                        .date("2024-06-17")
                        .buyerId(1)
                        .orderStatusDto(OrderStatusDto.builder().statusCode("Carrito").build())
                        .products(List.of(
                                CartProductDto.builder().productId(1L).quantity(10).build()
                        )).build())
                .build();
        Assertions.assertEquals(expectedResponse, got);
    }

    @Test
    public void searchNonExistingCartTest() {
        // Arrange
        Long orderId = -500L;

        // Mock JWTClaims
        Mockito.doNothing().when(jwtClaims).validateHeader("authorizationHeader", Roles.BUYER.getRole());

        // Mock Repository
        when(cartRepository.findById(orderId)).thenReturn(Optional.empty());

        // Act & Assert
        String expectedExceptionMessage = "Cart with id " + orderId + " not found.";
        ApiException thrownException = Assertions.assertThrows(ApiException.class, () -> cartService.searchCart("authorizationHeader", orderId));
        Assertions.assertEquals(expectedExceptionMessage, thrownException.getMessage());
    }

    @Test
    public void searchCartUnauthorizedTest() {
        // Arrange
        Long orderId = 1L;
        String header = "authorizationHeader";

        // Act & Assert
        String expectedExceptionMessage = "User is not authorized";
        lenient().doThrow(ExceptionsFactory.unauthorizedException("User is not authorized"))
                .when(jwtClaims).validateHeader(header, Roles.BUYER.getRole());
        ApiException thrownException = Assertions.assertThrows(ApiException.class, () -> cartService.searchCart(header, orderId));
        Assertions.assertEquals(expectedExceptionMessage, thrownException.getMessage());
    }
}
