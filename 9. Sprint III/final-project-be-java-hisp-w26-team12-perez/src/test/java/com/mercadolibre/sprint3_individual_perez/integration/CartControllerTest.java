package com.mercadolibre.sprint3_individual_perez.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.sprint3_individual_perez.dto.request.CartDTO;
import com.mercadolibre.sprint3_individual_perez.dto.request.OrderStatusDTO;
import com.mercadolibre.sprint3_individual_perez.dto.request.ProductDTO;
import com.mercadolibre.sprint3_individual_perez.dto.request.PurchaseOrderDTO;
import com.mercadolibre.sprint3_individual_perez.enums.OrderStatus;
import com.mercadolibre.sprint3_individual_perez.utils.UtilAutenticationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerTest {


    @Autowired
    private MockMvc mockMvc;

    CartDTO expectedCart;
    String token;
    ObjectWriter writer;

    // Setup the variables for the test
    @BeforeEach
    void setup() throws Exception {
        // Writer configuration
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        // Create two products
        ProductDTO product1 = new ProductDTO(1, 2);
        ProductDTO product2 = new ProductDTO(10, 10);
        // Create the OrderStatusDTO
        OrderStatusDTO orderStatusDTO = new OrderStatusDTO(OrderStatus.CARRITO.toString());
        // Create the PurchaseOrderDTO
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse("11-01-2025", formatter);
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        purchaseOrderDTO.setDate(sqlDate);
        purchaseOrderDTO.setProductDTO(List.of(product1, product2));
        purchaseOrderDTO.setIdBuyer(4);
        purchaseOrderDTO.setOrderStatus(orderStatusDTO);
        expectedCart = new CartDTO(purchaseOrderDTO);
        UtilAutenticationTest utilAutenticationTest = new UtilAutenticationTest();
        token = utilAutenticationTest.getTokenUser(mockMvc);
    }

    /**
     * Test the getCart method from CartController to retrieve all products in the cart.
     * @throws Exception if the cart is not found.
     */
    @Test
    @DisplayName("Get all products in the cart")
    void getCart() throws Exception {
        // Arrange
        String responseExpected = writer.writeValueAsString(expectedCart);
        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/orders/2")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(content().json(responseExpected));
    }

    /**
     * Test the getCart method from CartController to retrieve all products in the cart. But the cart is not found.
     * @throws Exception if the cart is not found.
     */
    @Test
    @DisplayName("Get all products in the cart. Cart not found.")
    void getCartNotFound() throws Exception {
        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/orders/5")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token))
                .andExpect(status().isNotFound());
    }

}
