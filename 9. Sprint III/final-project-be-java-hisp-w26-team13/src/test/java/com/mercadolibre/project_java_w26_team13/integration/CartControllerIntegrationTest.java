package com.mercadolibre.project_java_w26_team13.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.project_java_w26_team13.dtos.*;
import com.mercadolibre.project_java_w26_team13.entity.Role;
import com.mercadolibre.project_java_w26_team13.entity.User;
import com.mercadolibre.project_java_w26_team13.jwt.JwtService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerIntegrationTest extends IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    JwtService jwtService;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void createCartTest() throws Exception {
        CartResponseDto expected = CartResponseDto.builder()
                .totalPrice(352.0)
                .productsWithoutStock(List.of("Producto C"))
                .build();

        CartRequestDto cartRequestDto = CartRequestDto.builder()
                .purchaseOrderDto(PurchaseOrderDto.builder()
                        .date("17-06-2024")
                        .buyerId(3)
                        .orderStatusDto(OrderStatusDto.builder().statusCode("carrito").build())
                        .products(List.of(
                                CartProductDto.builder().productId(1L).quantity(10).build(),
                                CartProductDto.builder().productId(2L).quantity(10).build(),
                                CartProductDto.builder().productId(3L).quantity(40).build()
                        )).build())
                .build();

        User user = new User(3L, "mia",
                "$2a$10$NzCTdQaQu73yvM7a0Xpzru7KF.Sd.Ff5h8bHNLQVW7lOVRtEAO.Rq",
                new Role(2L, "buyer"));

        String token = jwtService.getToken(user);

        ResultActions resultActions = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/fresh-products/orders")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(cartRequestDto))
                        .header("Authorization", "Bearer " + token)
        );

        resultActions.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpect(result -> {
                    String json = result.getResponse().getContentAsString();
                    CartResponseDto got = objectMapper.readValue(json, new TypeReference<>() {
                    });
                    Assertions.assertEquals(expected, got);
                });
    }

    @Test
    public void updateCartTest() throws Exception{
        CartResponseDto expected = CartResponseDto.builder().totalPrice(500.0).build();

        CartRequestDto cartRequestDto = CartRequestDto.builder()
                .purchaseOrderDto(PurchaseOrderDto.builder()
                        .date("17-06-2024")
                        .buyerId(3)
                        .orderStatusDto(OrderStatusDto.builder().statusCode("carrito").build())
                        .products(List.of(
                                CartProductDto.builder().productId(2L).quantity(10).cartDetailId(1L).build(),
                                CartProductDto.builder().productId(2L).quantity(10).build()
                        )).build())
                .build();

        User user = new User(3L, "mia",
                "$2a$10$NzCTdQaQu73yvM7a0Xpzru7KF.Sd.Ff5h8bHNLQVW7lOVRtEAO.Rq",
                new Role(2L, "buyer"));

        String token = jwtService.getToken(user);

        ResultActions resultActions = this.mockMvc.perform(
                MockMvcRequestBuilders.put("/api/v1/fresh-products/orders/1")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(cartRequestDto))
                        .header("Authorization", "Bearer " + token)
        );

        resultActions.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpect(result -> {
                    String json = result.getResponse().getContentAsString();
                    CartResponseDto got = objectMapper.readValue(json, new TypeReference<>() {
                    });
                    Assertions.assertEquals(expected, got);
                });
    }

    @Test
    public void getCartTest() throws Exception {
        User user = new User(3L, "mia",
                "$2a$10$NzCTdQaQu73yvM7a0Xpzru7KF.Sd.Ff5h8bHNLQVW7lOVRtEAO.Rq",
                new Role(2L, "buyer"));

        String token = jwtService.getToken(user);

        Long orderId = 1L;
        var result = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/fresh-products/orders/{idOrder}", orderId)
                        .header("Authorization", "Bearer " + token)
        );

        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("purchase_order.products[0].product_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("purchase_order.products[0].quantity").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("purchase_order.date").value("2024-06-17"))
                .andExpect(MockMvcResultMatchers.jsonPath("purchase_order.buyer_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("purchase_order.order_status.status_code").value("Carrito"));
    }

    @Test
    public void getNonExistingCartTest() throws Exception {
        User user = new User(3L, "mia",
                "$2a$10$NzCTdQaQu73yvM7a0Xpzru7KF.Sd.Ff5h8bHNLQVW7lOVRtEAO.Rq",
                new Role(2L, "buyer"));

        String token = jwtService.getToken(user);

        Long orderId = -10000145L;
        var result = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/fresh-products/orders/{idOrder}", orderId)
                        .header("Authorization", "Bearer " + token)
        );

        result.andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("message")
                        .value("Cart with id " + orderId + " not found.")
                );
    }
}
