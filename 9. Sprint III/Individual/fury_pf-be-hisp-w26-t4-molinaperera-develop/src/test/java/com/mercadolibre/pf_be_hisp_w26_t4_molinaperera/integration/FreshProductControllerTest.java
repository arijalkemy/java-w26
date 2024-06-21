package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.BatchDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.SectionDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.request.InboundOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.request.PurchaseOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.exceptions.ProductNotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.exceptions.UserIdNotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.jwt.JwtService;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model.Role;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model.User;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
                .andExpect(jsonPath("$.size()").value(9));

    }

    @Test
    @DisplayName("Get order by id with valid id")
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
    @DisplayName("Update order with valid id")
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
    @DisplayName("Create order with valid data")
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
    @DisplayName("Create order with invalid product id")
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
    @DisplayName("Create order with invalid product id")
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
                //.andExpect(jsonPath("$.message").value("The User by id 99 not exist in db"))
                .andExpect(result -> assertInstanceOf(UserIdNotFoundException.class, result.getResolvedException()));
    }

    @Test
    @DisplayName("Set promo product with valid product id")
    void setProductPromo() throws Exception {
        Long idProduct = 3L;
        Double porcentage = 10.0;
        String token = jwtService.getToken(User.builder()
                .username("seller")
                .password("seller")
                .role(Role.SELLER)
                .build());

        mockMvc.perform(get("/api/v1/fresh_products/product/{id}/promo/{porcentage}", idProduct, porcentage)
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.product_id").value(3L));
    }

    @Test
    @DisplayName("Set promo product with invalid product id")
    void setProductPromoWithInvalidProductId() throws Exception {
        Long idProduct = 99L;
        Double porcentage = 10.0;
        String token = jwtService.getToken(User.builder()
                .username("seller")
                .password("seller")
                .role(Role.SELLER)
                .build());

        mockMvc.perform(get("/api/v1/fresh_products/product/{id}/promo/{porcentage}", idProduct, porcentage)
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Product not found"))
                .andExpect(result -> assertInstanceOf(ProductNotFoundException.class, result.getResolvedException()));

    }

    @Test
    @DisplayName("Get product promo list")
    void getProductPromoList() throws Exception {
        String token = jwtService.getToken(User.builder()
                .username("buyer")
                .password("buyer")
                .role(Role.BUYER)
                .build());

        mockMvc.perform(get("/api/v1/fresh_products/product_promo/list")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(6));

    }
}