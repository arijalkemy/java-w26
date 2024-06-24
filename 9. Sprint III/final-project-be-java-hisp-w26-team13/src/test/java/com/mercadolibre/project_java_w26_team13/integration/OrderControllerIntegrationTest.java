package com.mercadolibre.project_java_w26_team13.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.project_java_w26_team13.dtos.request.BatchStockDto;
import com.mercadolibre.project_java_w26_team13.dtos.request.OrderRequestDto;
import com.mercadolibre.project_java_w26_team13.dtos.request.SectionDto;
import com.mercadolibre.project_java_w26_team13.dtos.response.BatcheStockDTO;
import com.mercadolibre.project_java_w26_team13.entity.Role;
import com.mercadolibre.project_java_w26_team13.entity.User;
import com.mercadolibre.project_java_w26_team13.jwt.JwtService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerIntegrationTest extends IntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    JwtService jwtService;

    ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        this.objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());
    }
    @Test
    @DisplayName("Test: Register batch")
    public void registerBatchTest() throws Exception {

        User user = new User(1L, "user1",
                "$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK",
                new Role(1L, "representante"));

        String token = jwtService.getToken(user);

        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setSection(
                new SectionDto(1L,1L)
        );
        orderRequestDto.setOrderDate(LocalDate.now());
        orderRequestDto.setOrderNumber(100);

        List<BatchStockDto> batchStockDtos = List.of(
                new BatchStockDto(
                        "1",
                        1L,
                        -18.5,
                        -20.0,
                        100,
                        50,
                        LocalDate.parse("01-01-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        LocalTime.parse("12:00:00"),
                        LocalDate.parse("31-12-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                ),
                new BatchStockDto(
                        "2",
                        2L,
                        4.0,
                        2.0,
                        200,
                        150,
                        LocalDate.parse("15-02-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        LocalTime.parse("08:30:00"),
                        LocalDate.parse("15-08-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                ));
        orderRequestDto.setBatch(batchStockDtos);

        ResultActions resultActions = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/fresh-products/inboundorder")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(orderRequestDto))
                        .header("Authorization", "Bearer " + token));


        resultActions.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpect(result -> {
                    String json = result.getResponse().getContentAsString();
                    List<BatchStockDto> got = objectMapper.readValue(json, new TypeReference<List<BatchStockDto>>() {});
                    Assertions.assertEquals(batchStockDtos, got);
                });
    }

    @Test
    @DisplayName("Test: Update batch")
    public void updateBatchTest() throws Exception {

        User user = new User(1L, "user1",
                "$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK",
                new Role(1L, "representante"));

        String token = jwtService.getToken(user);

        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setOrderNumber(1);
        orderRequestDto.setOrderDate(LocalDate.now());
        orderRequestDto.setSection(
                new SectionDto(1L,1L)
        );

        List<BatchStockDto> batches = List.of(
                new BatchStockDto(
                        "B010",
                        2L,
                        4.0,
                        2.0,
                        200,
                        150,
                        LocalDate.parse("15-02-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        LocalTime.parse("08:30:00"),
                        LocalDate.parse("15-08-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                ));
        orderRequestDto.setBatch(batches);

        ResultActions resultActions = this.mockMvc.perform(
                MockMvcRequestBuilders.put("/api/v1/fresh-products/inboundorder")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(orderRequestDto))
                        .header("Authorization", "Bearer " + token));

        List<BatchStockDto> batchStockDtos = List.of(
                new BatchStockDto(
                        "B001",
                        1L,
                        4.5,
                        2.0,
                        100,
                        100,
                        LocalDate.parse("10-06-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        LocalTime.parse("08:00:00"),
                        LocalDate.parse("10-08-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                ),
                new BatchStockDto(
                        "B004",
                        4L,
                        4.5,
                        2.0,
                        100,
                        100,
                        LocalDate.parse("2024-06-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        LocalTime.parse("08:00"),
                        LocalDate.parse("2024-08-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                ),
                new BatchStockDto(
                        "B005",
                        4L,
                        3.0,
                        2.0,
                        100,
                        80,
                        LocalDate.parse("2024-06-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        LocalTime.parse("08:00"),
                        LocalDate.parse("2024-08-09", DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                ),
                new BatchStockDto(
                        "B006",
                        4L,
                        2.5,
                        2.0,
                        100,
                        60,
                        LocalDate.parse("2024-06-10", DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        LocalTime.parse("09:00"),
                        LocalDate.parse("2024-08-08", DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                ),
                new BatchStockDto(
                        "B010",
                        2L,
                        4.0,
                        2.0,
                        200,
                        150,
                        LocalDate.parse("15-02-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        LocalTime.parse("08:30:00"),
                        LocalDate.parse("15-08-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                )
        );

        BatcheStockDTO response = new BatcheStockDTO(batchStockDtos);


        resultActions.andDo(print())
                .andExpect(status().isOk()) // Cambia esto según el código de estado esperado para PUT
                .andExpect(content().contentType("application/json"))
                .andExpect(result -> {
                    String json = result.getResponse().getContentAsString();
                    BatcheStockDTO got = objectMapper.readValue(json, BatcheStockDTO.class);
                    Assertions.assertEquals(response, got);
                });
    }

    @Test
    @DisplayName("Test: Failed registration due to existing order number")
    public void registerBatchBadPath() throws Exception {
        String token = jwtService.getToken(new User(1L, "user1", "$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK", new Role(1L, "representante")));

        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setSection(new SectionDto(1L,1L));
        orderRequestDto.setOrderDate(LocalDate.now());
        orderRequestDto.setOrderNumber(1); // This order number already exists

        ResultActions resultActions = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/fresh-products/inboundorder")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(orderRequestDto))
                        .header("Authorization", "Bearer " + token));

        resultActions.andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Test: Failed update due to non-existing order number")
    public void updateBatchBadPath() throws Exception {
        String token = jwtService.getToken(new User(1L, "user1", "$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK", new Role(1L, "representante")));

        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setOrderNumber(9999); // This order number does not exist
        orderRequestDto.setOrderDate(LocalDate.now());
        orderRequestDto.setSection(new SectionDto(1L,1L));

        ResultActions resultActions = this.mockMvc.perform(
                MockMvcRequestBuilders.put("/api/v1/fresh-products/inboundorder")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(orderRequestDto))
                        .header("Authorization", "Bearer " + token));

        resultActions.andDo(print())
                .andExpect(status().isNotFound());
    }
}
