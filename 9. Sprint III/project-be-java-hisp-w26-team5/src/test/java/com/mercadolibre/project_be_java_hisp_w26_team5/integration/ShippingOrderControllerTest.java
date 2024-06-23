package com.mercadolibre.project_be_java_hisp_w26_team5.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.ShippingOrderChangeStateRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.ShippingOrderResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ShippingOrderControllerTest {
    @Autowired
    MockMvc mockMvc;
    ObjectMapper objectMapper;
    ObjectWriter objectWriter;

    public ShippingOrderControllerTest() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        objectWriter = objectMapper
                .configure(
                        SerializationFeature.WRAP_ROOT_VALUE,
                        false
                )
                .writer();
    }

    @Test
    @WithMockUser
    @DisplayName("Should create a shipping order when is called with a valid idPurchaseOrder")
    void shouldReturnAShippingOrderWhenGenerateShippingOrderIsCalledWithAValidIdPurchaseOrder() throws Exception {
        // Arrange
        Integer idPurchaseOrder = 101;

        // Act
        mockMvc
                .perform(post(
                        "/api/v1/shipping-orders/{idPurchaseOrder}",
                        idPurchaseOrder
                ).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    @WithMockUser
    @DisplayName("Should return a shipping order when is called with a valid idShippingOrder")
    void shouldReturnAShippingOrderWhenGetShippingOrderIsCalledWithAValidIdShippingOrder() throws Exception {
        // Arrange
        Integer idShippingOrder = 100;

        // Act
        MvcResult result = mockMvc
                .perform(get(
                        "/api/v1/shipping-orders/{idShippingOrder}",
                        idShippingOrder
                ).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        String response = result
                .getResponse()
                .getContentAsString();
        ShippingOrderResponseDTO shippingOrderResponseDTO = objectMapper.readValue(
                response,
                ShippingOrderResponseDTO.class
        );

        Assertions.assertEquals(
                idShippingOrder,
                shippingOrderResponseDTO.getId()
        );
    }

    @Test
    @WithMockUser
    @DisplayName("Should return a pending shipping order")
    void shouldReturnAPendingShippingOrder() throws Exception {
        // Act
        MvcResult result = mockMvc
                .perform(get("/api/v1/shipping-orders/pending").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        List<ShippingOrderResponseDTO> shippingOrderResponseDTOList = objectMapper.readValue(
                result
                        .getResponse()
                        .getContentAsString(),
                new TypeReference<List<ShippingOrderResponseDTO>>() {
                }
        );

        // Assert
        Assertions.assertEquals(
                1,
                shippingOrderResponseDTOList.size()
        );
        Assertions.assertTrue(shippingOrderResponseDTOList
                .stream()
                .allMatch(shippingOrderResponseDTO -> shippingOrderResponseDTO
                        .getState()
                        .equals("PENDING")));

    }

    @Test
    @WithMockUser
    @DisplayName("Should update the state of a shipping order with a valid idShippingOrder and state")
    void shouldUpdateTheStateOfAShippingOrderWithAValidIdShippingOrderAndState() throws Exception {
        // Arrange
        Integer idShippingOrder = 100;
        String state = "COMPLETED";
        ShippingOrderChangeStateRequestDTO shippingOrderChangeStateRequestDTO = new ShippingOrderChangeStateRequestDTO(state);

        // Act
        MvcResult result = mockMvc
                .perform(post(
                        "/api/v1/shipping-orders/update-state/{idShippingOrder}",
                        idShippingOrder
                ).contentType(MediaType.APPLICATION_JSON)
                .content(objectWriter.writeValueAsString(shippingOrderChangeStateRequestDTO)))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        String response = result
                .getResponse()
                .getContentAsString();

        ShippingOrderResponseDTO shippingOrderResponseDTO = objectMapper.readValue(
                response,
                ShippingOrderResponseDTO.class
        );

        Assertions.assertEquals(
                idShippingOrder,
                shippingOrderResponseDTO.getId()
        );
        Assertions.assertEquals(
                state,
                shippingOrderResponseDTO.getState()
        );
    }


}
