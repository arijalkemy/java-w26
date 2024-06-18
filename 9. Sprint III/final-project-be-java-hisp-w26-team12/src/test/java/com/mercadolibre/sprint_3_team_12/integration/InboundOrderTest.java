package com.mercadolibre.sprint_3_team_12.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.sprint_3_team_12.dto.SectionDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.BatchDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.InboundDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.InboundOrderDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.LoginRequestDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.InboundResponseDTO;
import com.mercadolibre.sprint_3_team_12.exceptions.ApiError;
import com.mercadolibre.sprint_3_team_12.utils.UtilAutenticationTest;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests for InboundOrder operations.
 */
@ActiveProfiles("test")
@SpringBootTest()
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InboundOrderTest {
    private String token;
    InboundDTO inboundDTO;
    InboundOrderDTO inboundOrderDTO;
    SectionDTO sectionDTO;
    BatchDTO batchDTO;
    InboundResponseDTO inboundResponseDTO;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    Date orderDate;
    Date manufacturingDate;
    Date manufacturingTime;
    Date dueDate;

    @Autowired
    private MockMvc mockMvc;
    ObjectWriter writer;

    /**
     * Set up the test environment.
     *
     * @throws Exception
     */
    @BeforeEach
    public void setUp() throws Exception {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        orderDate = dateFormat.parse("01-01-2023");
        manufacturingDate = dateFormat.parse("01-01-2023");
        manufacturingTime = dateTimeFormat.parse("01-01-2023 10:00:00");
        dueDate = dateFormat.parse("18-08-2025");
        batchDTO = new BatchDTO(
                5,
                4,
                25.0,
                15.0,
                1,
                1,
                manufacturingDate,
                manufacturingTime,
                dueDate
        );

        sectionDTO = new SectionDTO(7, 3);

        inboundOrderDTO = new InboundOrderDTO(
                126,
                orderDate,
                sectionDTO,
                Collections.singletonList(batchDTO)
        );

        inboundDTO = new InboundDTO(inboundOrderDTO);
        inboundResponseDTO = new InboundResponseDTO(
                Collections.singletonList(batchDTO)
        );

        UtilAutenticationTest utilAutenticationTest = new UtilAutenticationTest();
        token = utilAutenticationTest.getTokenAdmin(mockMvc); // Get the token
    }

    /** TO REG 1
     * Test case for creating a new inbound order.
     * This test case should pass if the inbound order is created successfully.
     */
    @Test
    @DisplayName("Create Inbound Order")
    @Order(1)
    public void createInboundOrder() throws Exception {
        String requestJSON = writer.writeValueAsString(inboundDTO);
        String expectedResponseJSON = writer.writeValueAsString(inboundResponseDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fresh-products/inboundorder")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().json(expectedResponseJSON));

    }

    /** TO REG 1
     * Test case for updating an existing inbound order.
     * This test case should pass if the inbound order is updated successfully.
     */
    @Test
    @Order(2)
    @DisplayName("Update Inbound Order")
    public void updateInboundOrder() throws Exception {
        inboundDTO.getInboundOrder().getBatchDTOList().get(0).setCurrentQuantity(2);
        String requestJSON = writer.writeValueAsString(inboundDTO);
        String expectedResponseJSON = writer.writeValueAsString(inboundResponseDTO);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/fresh-products/inboundorder")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().json(expectedResponseJSON));

    }

    /** TO REG 1
     * Test case for creating an inbound order with an invalid section.
     * This test case should pass if the inbound order is not created and an error message is returned.
     */
    @Test
    @Order(3)
    @DisplayName("Create Inbound Order with invalid section")
    public void createInboundOrderWithInvalidSection() throws Exception {
        inboundDTO.getInboundOrder().getSectionDTO().setSectionCode(100);
        String requestJSON = writer.writeValueAsString(inboundDTO);
        ApiError apiError = new ApiError(
                "Section not found",
                "Section with id " + inboundDTO.getInboundOrder().getSectionDTO().getSectionCode() +
                        " not found in warehouse with id " + inboundDTO.getInboundOrder().getSectionDTO().getWarehouseCode(),
                HttpStatus.NOT_FOUND.value());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fresh-products/inboundorder")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON)
                )
                .andExpect(status().isNotFound())
                .andExpect(content().json(writer.writeValueAsString(apiError)));

    }

    /** TO REG 1
     * Test case for creating an inbound order with an invalid warehouse.
     * This test case should pass if the inbound order is not created and an error message is returned.
     */
    @Test
    @Order(4)
    @DisplayName("Create Inbound Order with invalid warehouse")
    public void createInboundOrderWithInvalidWarehouse() throws Exception {
        inboundDTO.getInboundOrder().getSectionDTO().setWarehouseCode(100);
        String requestJSON = writer.writeValueAsString(inboundDTO);
        ApiError apiError = new ApiError(
                "Warehouse not found",
                "Warehouse with id " + inboundDTO.getInboundOrder().getSectionDTO().getWarehouseCode() +
                        " not found or user does not have access",
                HttpStatus.NOT_FOUND.value());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fresh-products/inboundorder")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON)
                )
                .andExpect(status().isNotFound())
                .andExpect(content().json(writer.writeValueAsString(apiError)));

    }

    /** TO REG 1
     * Test case for updating an inbound order with an invalid batch.
     * This test case should pass if the inbound order is not updated and an error message is returned.
     */
    @Test
    @Order(5)
    @DisplayName("Update Inbound Order with invalid batch")
    public void updateInboundOrderWithInvalidBatch() throws Exception {
        inboundDTO.getInboundOrder().getBatchDTOList().get(0).setIdProduct(100);
        String requestJSON = writer.writeValueAsString(inboundDTO);
        ApiError apiError = new ApiError(
                "Product not found",
                "Product with id " + inboundDTO.getInboundOrder().getBatchDTOList().get(0).getIdProduct() +
                        " in batch number " + inboundDTO.getInboundOrder().getBatchDTOList().get(0).getIdBatch() +
                        " not found",
                HttpStatus.NOT_FOUND.value());
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/fresh-products/inboundorder")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON)
                )
                .andExpect(status().isNotFound())
                .andExpect(content().json(writer.writeValueAsString(apiError)));
    }

    /** TO REG 1
     * Test case for creating an inbound order with an invalid batch quantity.
     * This test case should pass if the inbound order is not created and an error message is returned.
     */
    @Test
    @Order(6)
    @DisplayName("Create Inbound Order with invalid batch quantity")
    public void createInboundOrderWithInvalidBatchQuantity() throws Exception {
        inboundDTO.getInboundOrder().setOrderId(127);
        inboundDTO.getInboundOrder().getBatchDTOList().get(0).setCurrentQuantity(100);
        String requestJSON = writer.writeValueAsString(inboundDTO);
        ApiError apiError = new ApiError(
                "Insufficient capacity",
                "Section with id " + inboundDTO.getInboundOrder().getSectionDTO().getSectionCode() +
                        " does not have enough capacity to store the requested products",
                HttpStatus.BAD_REQUEST.value());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fresh-products/inboundorder")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON)
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().json(writer.writeValueAsString(apiError)));
    }

    /** TO REG 1
     * Test case for creating an inbound order with the same id.
     * This test case should pass if the inbound order is not created and an error message is returned.
     */
    @Test
    @Order(7)
    @DisplayName("Create Inbound Order with same id")
    public void createInboundOrderWithSameId() throws Exception {
        String requestJSON = writer.writeValueAsString(inboundDTO);
        ApiError apiError = new ApiError(
                "Inbound order already exists",
                "Inbound order with id " + inboundDTO.getInboundOrder().getOrderId() +
                        " already exists for your user, if you want to update it, please set the correct endpoint",
                HttpStatus.CONFLICT.value());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fresh-products/inboundorder")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON)
                )
                .andExpect(status().isConflict())
                .andExpect(content().json(writer.writeValueAsString(apiError)));
    }

    /** TO REG 1
     * Test case for updating an inbound order with an invalid id.
     * This test case should pass if the inbound order is not updated and an error message is returned.
     */
    @Test
    @Order(8)
    @DisplayName("Update Inbound Order with not found id")
    public void updateInboundOrderWithNotFoundId() throws Exception {
        inboundDTO.getInboundOrder().setOrderId(100);
        String requestJSON = writer.writeValueAsString(inboundDTO);
        ApiError apiError = new ApiError(
                "Inbound order not found",
                "Inbound order with id " + inboundDTO.getInboundOrder().getOrderId() +
                        " not found for your user",
                HttpStatus.NOT_FOUND.value());
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/fresh-products/inboundorder")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON)
                )
                .andExpect(status().isNotFound())
                .andExpect(content().json(writer.writeValueAsString(apiError)));
    }

    /** TO REG 1
     * Test case for updating an inbound order with an invalid product category.
     * This test case should pass if the inbound order is not updated and an error message is returned.
     */
    @Test
    @Order(9)
    @DisplayName("Update Inbound Order with invalid product category")
    public void updateInboundOrderWithInvalidProductCategory() throws Exception {
        inboundDTO.getInboundOrder().getSectionDTO().setSectionCode(8);
        String requestJSON = writer.writeValueAsString(inboundDTO);
        ApiError apiError = new ApiError(
                "Invalid product category",
                "Product with id " + inboundDTO.getInboundOrder().getBatchDTOList().get(0).getIdProduct() +
                        " does not match the expected category in the selected section with category RF",
                HttpStatus.BAD_REQUEST.value());
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/fresh-products/inboundorder")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON)
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().json(writer.writeValueAsString(apiError)));
    }

    /** TO REG 1
     * Test case for creating an inbound order with an invalid due date.
     * This test case should pass if the inbound order is not created and an error message is returned.
     */
    @Test
    @Order(10)
    @DisplayName("Create Inbound Order with invalid due date")
    public void createInboundOrderWithInvalidDueDate() throws Exception {
        dueDate = dateFormat.parse("18-08-2023");
        inboundDTO.getInboundOrder().setOrderId(128);
        inboundDTO.getInboundOrder().getBatchDTOList().get(0).setDueDate(dueDate);
        String requestJSON = writer.writeValueAsString(inboundDTO);
        ApiError apiError = new ApiError(
                "Invalid due date",
                "Due date for product with id " + inboundDTO.getInboundOrder().getBatchDTOList().get(0).getIdProduct() +
                        " in batch number " + inboundDTO.getInboundOrder().getBatchDTOList().get(0).getIdBatch() +
                        " is in the past",
                HttpStatus.BAD_REQUEST.value());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fresh-products/inboundorder")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON)
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().json(writer.writeValueAsString(apiError)));
    }

    /** TO REG 1
     * Test case for creating an inbound order with an invalid manufacturing date.
     * This test case should pass if the inbound order is not created and an error message is returned.
     */
    @Test
    @Order(11)
    @DisplayName("Create Inbound Order with invalid manufacturing date")
    public void createInboundOrderWithInvalidManufacturingDate() throws Exception {
        manufacturingDate = dateFormat.parse("18-08-2026");
        dueDate = dateFormat.parse("18-08-2025");
        inboundDTO.getInboundOrder().setOrderId(129);
        inboundDTO.getInboundOrder().getBatchDTOList().get(0).setManufacturingDate(manufacturingDate);
        inboundDTO.getInboundOrder().getBatchDTOList().get(0).setDueDate(dueDate);
        String requestJSON = writer.writeValueAsString(inboundDTO);
        ApiError apiError = new ApiError(
                "Invalid manufacturing date",
                "Manufacturing date for product with id " + inboundDTO.getInboundOrder().getBatchDTOList().get(0).getIdProduct() +
                        " in batch number " + inboundDTO.getInboundOrder().getBatchDTOList().get(0).getIdBatch() +
                        " is in the past of the due date",
                HttpStatus.BAD_REQUEST.value());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fresh-products/inboundorder")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON)
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().json(writer.writeValueAsString(apiError)));
    }
}