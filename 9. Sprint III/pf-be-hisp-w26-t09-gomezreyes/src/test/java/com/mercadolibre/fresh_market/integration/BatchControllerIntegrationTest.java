package com.mercadolibre.fresh_market.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.fresh_market.config.ProductNotFoundException;
import com.mercadolibre.fresh_market.config.security.JwtService;
import com.mercadolibre.fresh_market.model.*;
import com.mercadolibre.fresh_market.model.enums.Category;
import com.mercadolibre.fresh_market.model.enums.Role;
import com.mercadolibre.fresh_market.repository.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.util.NestedServletException;

import java.time.LocalDate;
import java.util.HashMap;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BatchControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JwtService jwtTokenService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IWarehouseRepository warehouseRepository;

    @Autowired
    private IBatchRepository batchRepository;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IInboundOrderRepository inboundOrderRepository;

    @Autowired
    private ISectionRepository sectionRepository;

    @Test
    @DisplayName("Test forbidden access to getBatchesExpiringSoon")
    public void testGetBatchesExpiringSoonWithoutPermissions() throws Exception {
        mockMvc.perform(get("/api/v1/fesh-products/batch/list/due-date/{cantDays}", 10))
                .andExpect(status().isForbidden());
    }

    private Product product;
    private String token;
    private Section section;
    private InboundOrder inboundOrder;

    @BeforeAll
    public void setup() {
        // Create a warehouseman user
        User warehouseman = new User();
        warehouseman.setFirstName("Warehouseman");
        warehouseman.setEmail("warehouseman@test.com");
        warehouseman.setPassword("password");
        warehouseman.setRole(Role.WAREHOUSEMAN);
        userRepository.save(warehouseman);

        // Create a warehouse
        Warehouse warehouse = new Warehouse();
        warehouse.setAddress("123 Test St");
        warehouse.setCountry("Test Country");
        warehouse.setWarehouseman(warehouseman);
        warehouseRepository.save(warehouse);


        // Create a product
        product = new Product();
        product.setDescription("Test Product");
        product.setPrice(100.0);
        product.setSeller(warehouseman);
        productRepository.save(product);

        // Create a section
        section = new Section();
        section.setTemperature(20.0);
        section.setCaracteristics("Test Characteristics");
        section.setSectorSize(100L);
        section.setCurrentAvailability(100L);
        section.setCategory(Category.FF);
        section.setWarehouse(warehouse);
        sectionRepository.save(section);


        inboundOrder = new InboundOrder();
        inboundOrder.setOrderNumber(1);
        inboundOrder.setOrderDate(LocalDate.now());
        inboundOrder.setWarehouseman(warehouseman);
        inboundOrderRepository.save(inboundOrder);

        // Create a batch
        Batch batch = new Batch();
        batch.setInitialQuantity(100);
        batch.setCurrentQuantity(100);
        batch.setDueDate(LocalDate.now().plusDays(5));
        batch.setManufacturingDate(LocalDate.now().minusDays(5));
        batch.setBatchNumber(1);
        batch.setCurrentTemperature(20.0);
        batch.setMinimumTemperature(20.0);
        batch.setProduct(product);
        batch.setSection(section);
        batch.setInboundOrder(inboundOrder);
        batchRepository.save(batch);

        // Generate token with an additional claim "role"
        HashMap<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role", "WAREHOUSEMAN");
        token = jwtTokenService.generateToken(extraClaims, warehouseman);

    }


    @Test
    public void testGetBatchesExpiringSoon() throws Exception {
        // Perform the request and assert the response
        mockMvc.perform(get("/api/v1/fresh-products/batch/list/due-date/{cantDays}", 10)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.batch_stock[0].batch_number").value(1))
                .andExpect(jsonPath("$.batch_stock[0].product_type_id").value(1))
                .andExpect(jsonPath("$.batch_stock[0].due_date").value(LocalDate.now().plusDays(5).toString()))
                .andExpect(jsonPath("$.batch_stock[0].current_quantity").value(100));

    }

    @Test
    public void testGetBatchesExpiringSoonByCategoryAndOrder() throws Exception {
        mockMvc.perform(get("/api/v1/fresh-products/batch/list/due-date/{cantDays}?category=FF&order=date_asc", 10)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.batch_stock[0].batch_number").value(1))
                .andExpect(jsonPath("$.batch_stock[0].product_type_id").value(1))
                .andExpect(jsonPath("$.batch_stock[0].due_date").value(LocalDate.now().plusDays(5).toString()))
                .andExpect(jsonPath("$.batch_stock[0].current_quantity").value(100));
    }

    @Test
    @WithMockUser(roles = "SELLER")
    public void testGetBatchByProductIdUnauthorized() throws Exception {
        // Perform the request and assert the response
        mockMvc.perform(get("/api/v1/fresh-products/{idProduct}/batch/list", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testGetBatchesByProductId() throws Exception {
        // Create a batch for this specific test
        Batch testBatch = new Batch();
        testBatch.setInitialQuantity(100);
        testBatch.setCurrentQuantity(100);
        testBatch.setDueDate(LocalDate.now().plusWeeks(4));
        testBatch.setManufacturingDate(LocalDate.now().minusDays(5));
        testBatch.setBatchNumber(2); // Use a different batch number
        testBatch.setCurrentTemperature(20.0);
        testBatch.setMinimumTemperature(20.0);
        testBatch.setProduct(product);
        testBatch.setSection(section);
        testBatch.setInboundOrder(inboundOrder);
        batchRepository.save(testBatch);
        // Perform the request and assert the response
        mockMvc.perform(get("/api/v1/fresh-products/{idProduct}/batch/list", product.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetBatchByProductNotAvailability() throws Exception {
        // Perform the request and assert the response
        mockMvc.perform(get("/api/v1/fresh-products/{idProduct}/batch/list", 688L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof ProductNotFoundException))
                .andExpect(result -> assertEquals("Product is not available", result.getResolvedException().getMessage()));
    }

    @Test
    public void testGetBatchByProductIdOrdered() throws Exception {
        // Create a batch for this specific test
        Batch testBatch = new Batch();
        testBatch.setInitialQuantity(100);
        testBatch.setCurrentQuantity(100);
        testBatch.setDueDate(LocalDate.now().plusWeeks(4));
        testBatch.setManufacturingDate(LocalDate.now().minusDays(5));
        testBatch.setBatchNumber(2);
        testBatch.setCurrentTemperature(20.0);
        testBatch.setMinimumTemperature(20.0);
        testBatch.setProduct(product);
        testBatch.setSection(section);
        testBatch.setInboundOrder(inboundOrder);
        batchRepository.save(testBatch);

        // Perform the request and assert the response
        mockMvc.perform(get("/api/v1/fresh-products/{idProduct}/batch/list?date_asc", product.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }
}


