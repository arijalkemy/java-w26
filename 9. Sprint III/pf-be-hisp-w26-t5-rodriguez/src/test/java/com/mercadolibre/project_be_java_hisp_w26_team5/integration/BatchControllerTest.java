package com.mercadolibre.project_be_java_hisp_w26_team5.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.BatchRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.InboundOrderRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.SectionRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.mapper.BatchMapper;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.Batch;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BatchControllerTest {

    @Autowired
    MockMvc mockMvc;
    private final ObjectMapper objectMapper;
    private final ObjectWriter writer;

    public BatchControllerTest() {
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        writer = objectMapper
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    @WithMockUser(roles = {"MANAGER"})
    @DisplayName("Se envia una peticion para registrar un lote con todos sus campos correctos " +
            "y se guarda en el sistema, devuelve su representacion en DTO.")
    public void createInboundOrderSuccesfully() throws Exception {
        // Arrange
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Batch batch = Batch.builder()
                .batchNumber("2303947712")
                .product(Product.builder().id(1).build())
                .currentTemperature(10.2)
                .minimumTemperature(12.0)
                .initialQuantity(20)
                .currentQuantity(20)
                .manufacturingDate(LocalDate.parse("05-10-2024",formatter))
                .manufacturingTime(
                        LocalDateTime.parse(
                                "05-10-2024 10:40:00",
                                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
                        )
                )
                .dueDate(LocalDate.parse("21-12-2024", formatter))
                .build();

        BatchRequestDTO batchRequestDTO = BatchMapper.BatchToBatchRequestDTO(batch);

        SectionRequestDTO sectionRequestDTO = SectionRequestDTO.builder()
                .sectorId(1)
                .warehouseCode(1)
                .build();
        InboundOrderRequestDTO inboundOrderRequestDTO = InboundOrderRequestDTO.builder()
                .orderNumber(1)
                .orderDate(LocalDate.parse("11-10-2024", formatter))
                .section(sectionRequestDTO)
                .batchStock(batchRequestDTO)
                .build();
        String jsonPayload = writer.writeValueAsString(inboundOrderRequestDTO);

        // Act
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/batches/inboundorder")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload))
                .andDo(print());

        // Assert
        resultActions
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    @WithMockUser(roles = {"MANAGER"})
    @DisplayName("Se envia una peticion para actualizar un lote con batch_number que ya existe " +
            "y se guardan los cambios en el sistema, devuelve su representacion en DTO.")
    public void updateInboundOrderSuccesfully() throws Exception {
        // Arrange
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Batch batch = Batch.builder()
                .batchNumber("20240501-123")
                .product(Product.builder().id(1).build())
                .currentTemperature(10.2)
                .minimumTemperature(12.0)
                .initialQuantity(20)
                .currentQuantity(10)
                .manufacturingDate(LocalDate.parse("05-10-2024",formatter))
                .manufacturingTime(
                        LocalDateTime.parse(
                                "05-10-2024 10:40:00",
                                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
                        )
                )
                .dueDate(LocalDate.parse("21-12-2024", formatter))
                .build();

        BatchRequestDTO batchRequestDTO = BatchMapper.BatchToBatchRequestDTO(batch);

        SectionRequestDTO sectionRequestDTO = SectionRequestDTO.builder()
                .sectorId(1)
                .warehouseCode(1)
                .build();
        InboundOrderRequestDTO inboundOrderRequestDTO = InboundOrderRequestDTO.builder()
                .orderNumber(1)
                .orderDate(LocalDate.parse("11-10-2024", formatter))
                .section(sectionRequestDTO)
                .batchStock(batchRequestDTO)
                .build();
        String jsonPayload = writer.writeValueAsString(inboundOrderRequestDTO);

        // Act
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/batches/inboundorder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print());

        // Assert
        resultActions
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }
}
