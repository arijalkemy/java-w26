package com.mercadolibre.pf_be_hisp_w26_t4_aquino.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.BatchDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.SectionDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.request.InboundOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.request.PurchaseOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.exceptions.ProductNotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.exceptions.UserIdNotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.jwt.JwtService;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.Role;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.model.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {"SCOPE_SUFFIX = integration_test"})
class FreshProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtService jwtService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("test endpoint correct path for updating an inboundOrder")
    void addInboundOrderTest() throws Exception {
        String token = jwtService.getToken(User.builder()
                .username("manager")
                .password("manager")
                .role(Role.MANAGER)
                .build());

        List<BatchDTO> batches = new ArrayList<>() {{
            add(BatchDTO.builder()
                    .id(51L)
                    .productId(1L)
                    .currentTemperature(25.0)
                    .minimumTemperature(20.0)
                    .initialQuantity(100)
                    .currentQuantity(100)
                    .manufacturingDate(LocalDate.now())
                    .manufacturingTime(LocalDateTime.now())
                    .dueDate(LocalDate.now().plusDays(7))
                    .build()
            );
        }};

        SectionDTO sectionDTO = SectionDTO.builder()
                .id(1L)
                .warehouseCode(1L)
                .build();

        InboundOrderRequestDTO inboundOrderDTO = InboundOrderRequestDTO.builder()
                .orderDate(LocalDate.of(2023, 6, 1))
                .id(50L)
                .batchList(batches)
                .section(sectionDTO)
                .build();

        String payload = objectMapper.writeValueAsString(inboundOrderDTO);

        mockMvc.perform(post("/api/v1/fresh_products/inboundorder")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("test endpoint correct path for updating an inboundOrder")
    void updateInboundOrderTest() throws Exception {
        String token = jwtService.getToken(User.builder()
                .username("manager")
                .password("manager")
                .role(Role.MANAGER)
                .build());

        List<BatchDTO> batches = new ArrayList<>() {{
            add(BatchDTO.builder()
                    .id(1L)
                    .productId(1L)
                    .currentTemperature(25.0)
                    .minimumTemperature(20.0)
                    .initialQuantity(100)
                    .currentQuantity(100)
                    .manufacturingDate(LocalDate.now())
                    .manufacturingTime(LocalDateTime.now())
                    .dueDate(LocalDate.now().plusDays(7))
                    .build()
            );
        }};

        SectionDTO sectionDTO = SectionDTO.builder()
                .id(1L)
                .warehouseCode(1L)
                .build();

        InboundOrderRequestDTO inboundOrderDTO = InboundOrderRequestDTO.builder()
                .orderDate(LocalDate.of(2023, 6, 1))
                .id(1001L)
                .batchList(batches)
                .section(sectionDTO)
                .build();

        String payload = objectMapper.writeValueAsString(inboundOrderDTO);

        mockMvc.perform(put("/api/v1/fresh_products/inboundorder")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("test endpoint for creating a batch that correspond to another order")
    void addInboundOrderTestWithBatchOfAnotherOrder() throws Exception {
        String token = jwtService.getToken(User.builder()
                .username("manager")
                .password("manager")
                .role(Role.MANAGER)
                .build());

        List<BatchDTO> batches = new ArrayList<>() {{
            add(BatchDTO.builder()
                    .id(1L)
                    .productId(1L)
                    .currentTemperature(25.0)
                    .minimumTemperature(20.0)
                    .initialQuantity(100)
                    .currentQuantity(100)
                    .manufacturingDate(LocalDate.now())
                    .manufacturingTime(LocalDateTime.now())
                    .dueDate(LocalDate.now().plusDays(7))
                    .build()
            );
        }};

        SectionDTO sectionDTO = SectionDTO.builder()
                .id(1L)
                .warehouseCode(1L)
                .build();

        InboundOrderRequestDTO inboundOrderDTO = InboundOrderRequestDTO.builder()
                .orderDate(LocalDate.of(2023, 6, 1))
                .id(50L)
                .batchList(batches)
                .section(sectionDTO)
                .build();

        String payload = objectMapper.writeValueAsString(inboundOrderDTO);

        mockMvc.perform(post("/api/v1/fresh_products/inboundorder")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string("The batch 1 correspond to another order"));
    }

    @Disabled // Rcordar quitar este disabled
    @Test
    @DisplayName("Get warehouse product stock")
    void getWarehouseProductStock() throws Exception {
        String token = jwtService.getToken(User.builder()
                .username("manager")
                .password("manager")
                .role(Role.MANAGER)
                .build());

        mockMvc.perform(get("/api/v1/fresh_products/1/warehouse/list")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Not found warehouse product stock")
    void notFoundWarehouseProductStock() throws Exception {
        String token = jwtService.getToken(User.builder()
                .username("manager")
                .password("manager")
                .role(Role.MANAGER)
                .build());

        mockMvc.perform(get("/api/v1/fresh_products/15/warehouse/list")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().json("{\"message\":\"Product not found\"}"));
    }

    @Test
    @DisplayName("Obtener todos los productos")
    void getAllProducts() throws Exception {
        String token = jwtService.getToken(User.builder()
                .username("buyer")
                .password("buyer")
                .role(Role.BUYER)
                .build());

        mockMvc.perform(get("/api/v1/fresh_products/list")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect( jsonPath("$.size()").value(9));

    }

    @Test
    @DisplayName("Obtener un pedido con un id valido")
    void findOrderById_withValidId() throws Exception {
        Long idOrder = 1L;
        String token = jwtService.getToken(User.builder()
                .username("buyer")
                .password("buyer")
                .role(Role.BUYER)
                .build());

        mockMvc.perform(get("/api/v1/fresh_products/orders/" + idOrder)
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").isNotEmpty());
    }

    @Test
    @DisplayName("Actualizar un pedido con un id valido")
    void updateOrder_withValidId() throws Exception {
        Long idOrder = 1L;
        String token = jwtService.getToken(User.builder()
                .username("buyer")
                .password("buyer")
                .role(Role.BUYER)
                .build());

        PurchaseOrderRequestDTO requestDTO = new PurchaseOrderRequestDTO();
        Map<String, PurchaseOrderRequestDTO> requestBody = new HashMap<>();
        requestBody.put("purchase_order", requestDTO);
        String jsonContent = """
                {
                    "purchase_order": {
                        "date": "02-02-2000",
                        "buyer_id": 2,
                        "order_status": {
                            "status_code": "carrito"
                        },
                        "products": [
                            {
                                "product_id": 1,
                                "quantity": 2
                            },
                            {
                                "product_id": 4,
                                "quantity": 50000
                            }
                        ]
                    }
                }
                """;
        mockMvc.perform(put("/api/v1/fresh_products/orders/{idOrder}", idOrder)
                        .header("Authorization", "Bearer " + token)
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Crear una orden valida")
    void postOrder() throws Exception {
        Long idOrder = 1L;
        String token = jwtService.getToken(User.builder()
                .username("buyer")
                .password("buyer")
                .role(Role.BUYER)
                .build());

        String jsonContent = """
                {
                    "purchase_order": {
                        "date": "02-02-2000",
                        "buyer_id": 2,
                        "order_status": {
                            "status_code": "carrito"
                        },
                        "products": [
                            {
                                "product_id": 1,
                                "quantity": 2
                            },
                            {
                                "product_id": 3,
                                "quantity": 2
                            }
                        ]
                    }
                }
                """;
        mockMvc.perform(post("/api/v1/fresh_products/orders", idOrder)
                        .header("Authorization", "Bearer " + token)
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json("""
                        {
                            "total_price": 5.4
                        }
                        """));
    }

    @Test
    @DisplayName("Crear una orden con un producto invalido")
    void postOrderWithInvalidProduct() throws Exception {
        Long idOrder = 1L;
        String token = jwtService.getToken(User.builder()
                .username("buyer")
                .password("buyer")
                .role(Role.BUYER)
                .build());

        String jsonContent = """
                {
                    "purchase_order": {
                        "date": "02-02-2000",
                        "buyer_id": 2,
                        "order_status": {
                            "status_code": "carrito"
                        },
                        "products": [
                            {
                                "product_id": 1,
                                "quantity": 2
                            },
                            {
                                "product_id": 20,
                                "quantity": 2
                            }
                        ]
                    }
                }
                """;
        mockMvc.perform(post("/api/v1/fresh_products/orders", idOrder)
                        .header("Authorization", "Bearer " + token)
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Product not found"))
                .andExpect(result -> assertInstanceOf(ProductNotFoundException.class, result.getResolvedException()));
    }

    @Test
    @DisplayName("Crear una orden con un buyer invalido")
    void postOrderWithInvalidBuyer() throws Exception {
        Long idOrder = 1L;
        String token = jwtService.getToken(User.builder()
                .username("buyer")
                .password("buyer")
                .role(Role.BUYER)
                .build());

        String jsonContent = """
                {
                    "purchase_order": {
                        "date": "02-02-2000",
                        "buyer_id": 99,
                        "order_status": {
                            "status_code": "carrito"
                        },
                        "products": [
                            {
                                "product_id": 1,
                                "quantity": 2
                            },
                            {
                                "product_id": 20,
                                "quantity": 2
                            }
                        ]
                    }
                }
                """;
        mockMvc.perform(post("/api/v1/fresh_products/orders", idOrder)
                        .header("Authorization", "Bearer " + token)
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("The User by id 99 not exist in db"))
                .andExpect(result -> assertInstanceOf(UserIdNotFoundException.class, result.getResolvedException()));
    }
 }
