package com.mercadolibre.fresh_market.integration;

import com.mercadolibre.fresh_market.config.security.JwtService;
import com.mercadolibre.fresh_market.model.*;
import com.mercadolibre.fresh_market.model.enums.Category;
import com.mercadolibre.fresh_market.model.enums.Role;
import com.mercadolibre.fresh_market.repository.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private JwtService jwtTokenService;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IWarehouseRepository warehouseRepository;

    @Autowired
    private IInboundOrderRepository iInboundOrderRepository;

    @Autowired
    private IBatchRepository iBatchRepository;

    @Autowired
    private ISectionRepository sectionRepository;


    @Test
    @DisplayName("Given a product id, when getStockByProductAndWarehouse is called, then it should return the stock information for the product. - Failed to token validation")
    void modifyOrderExistenceFailed() throws Exception {
        Long idProduct = 1L;

        // Act
        ResultActions result = mockMvc.perform(get("/api/v1/fresh-products/{idProduct}/warehouse/list", idProduct)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        // Assert
        result.andExpect(status().isForbidden());
    }


    @Test
    @DisplayName("Given a product id, when getStockByProductAndWarehouse is called, then it should return the stock information for the product.")
    @WithMockUser(roles = "BUYER")
    void modifyOrderExistence() throws Exception {

        // Create a test user
        User user = new User();
        user.setFirstName("testUser1");
        user.setEmail("test1@test.com");
        user.setPassword("password");
        user.setRole(Role.BUYER);
        userRepository.save(user);

        // Generate token with an additional claim "role"
        HashMap<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role", "BUYER");
        String token = jwtTokenService.generateToken(extraClaims, user);

        // Create a product to associate with the batch and save it
        Product product = new Product();
        product.setId(1L);
        product.setDescription("Test Product");
        product.setPrice(500.00);
        product.setSeller(user);
        productRepository.save(product);


        // Create a warehouseman user for the InboundOrder and save it
        User warehouseman = new User();
        warehouseman.setFirstName("Warehouseman1");
        warehouseman.setEmail("warehouseman1@test.com");
        warehouseman.setPassword("password");
        warehouseman.setRole(Role.WAREHOUSEMAN);
        userRepository.save(warehouseman);

        // Create an InboundOrder object and save it
        InboundOrder inboundOrder = new InboundOrder();
        inboundOrder.setOrderDate(LocalDate.of(2022, 1, 1));
        inboundOrder.setOrderNumber(1);
        inboundOrder.setWarehouseman(warehouseman);
        iInboundOrderRepository.save(inboundOrder);

        // Retrieve the InboundOrder entity from the repository to ensure it is managed
        inboundOrder = iInboundOrderRepository.findById(inboundOrder.getId()).orElseThrow(() -> new RuntimeException("InboundOrder not found"));


        // Create a Warehouse and save it
        Warehouse warehouse = new Warehouse();
        warehouse.setId(1L);
        warehouse.setAddress("123 Main St");
        warehouse.setCountry("USA");
        warehouse.setWarehouseman(warehouseman);
        warehouseRepository.save(warehouse);

        // Create a Section and save it
        Section section = new Section();
        section.setId(1L);
        section.setTemperature(20.0);
        section.setCaracteristics("Some characteristics");
        section.setSectorSize(100L);
        section.setCurrentAvailability(50L);
        section.setCategory(Category.FF); // Assuming Category is an enum with FF as one of its values
        section.setWarehouse(warehouse); // Assuming you have an existing Warehouse object
        sectionRepository.save(section);

        // Create the Batch and associate it with the InboundOrder and Product
        Batch batch = new Batch();
        batch.setInitialQuantity(100);
        batch.setCurrentQuantity(100);
        batch.setDueDate(LocalDate.of(2022, 12, 31));
        batch.setManufacturingDate(LocalDate.of(2022, 1, 1));
        batch.setManufacturingTime(LocalDateTime.of(2022, 1, 1, 0, 0, 0));
        batch.setBatchNumber(2);
        batch.setCurrentTemperature(20.5);
        batch.setMinimumTemperature(15.0);
        batch.setInboundOrder(inboundOrder); // Use the managed entity here
        batch.setProduct(product);
        batch.setSection(section);

        // Save the Batch after ensuring the InboundOrder is managed
        iBatchRepository.save(batch);

        Long idProduct = 1L;
        // Act
        ResultActions result = mockMvc.perform(get("/api/v1/fresh-products/{idProduct}/warehouse/list", idProduct)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .accept(MediaType.APPLICATION_JSON));

        result.andDo(print());

        // Assert
        result.andExpect(status().isOk());

        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andExpect(jsonPath("$.product_id").value(1L))
                        .andExpect(jsonPath("$.warehouse_products[0].warehouse_id").value(1L))
                        .andExpect(jsonPath("$.warehouse_products[0].quantity").value(200));

    }

    @Test
    @DisplayName("Given a category, when getProducts is called, then it should return the product list of this category")
    @WithMockUser(roles = "SELLER")
    void getProductsByCategory() throws Exception {

        // Create a test user
        User user = new User();
        user.setFirstName("testUser2");
        user.setEmail("test2@test.com");
        user.setPassword("password");
        user.setRole(Role.SELLER);
        userRepository.save(user);

        // Generate token with an additional claim "role"
        HashMap<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role", "SELLER");
        String token = jwtTokenService.generateToken(extraClaims, user);

        // Create a product to associate with the batch and save it
        Product product = new Product();
        product.setId(2L);
        product.setDescription("Test Product2");
        product.setPrice(500.00);
        product.setSeller(user);
        productRepository.save(product);


        // Create a warehouseman user for the InboundOrder and save it
        User warehouseman = new User();
        warehouseman.setFirstName("Warehouseman2");
        warehouseman.setEmail("warehouseman2@test.com");
        warehouseman.setPassword("password");
        warehouseman.setRole(Role.WAREHOUSEMAN);
        userRepository.save(warehouseman);

        // Create an InboundOrder object and save it
        InboundOrder inboundOrder = new InboundOrder();
        inboundOrder.setOrderDate(LocalDate.of(2022, 1, 1));
        inboundOrder.setOrderNumber(2);
        inboundOrder.setWarehouseman(warehouseman);
        iInboundOrderRepository.save(inboundOrder);

        // Retrieve the InboundOrder entity from the repository to ensure it is managed
        inboundOrder = iInboundOrderRepository.findById(inboundOrder.getId()).orElseThrow(() -> new RuntimeException("InboundOrder not found"));


        // Create a Warehouse and save it
        Warehouse warehouse = new Warehouse();
        warehouse.setId(2L);
        warehouse.setAddress("123 Main St");
        warehouse.setCountry("USA");
        warehouse.setWarehouseman(warehouseman);
        warehouseRepository.save(warehouse);

        // Create a Section and save it
        Section section = new Section();
        section.setId(2L);
        section.setTemperature(20.0);
        section.setCaracteristics("Some characteristics2");
        section.setSectorSize(100L);
        section.setCurrentAvailability(50L);
        section.setCategory(Category.FF); // Assuming Category is an enum with FF as one of its values
        section.setWarehouse(warehouse); // Assuming you have an existing Warehouse object
        sectionRepository.save(section);

        // Create the Batch and associate it with the InboundOrder and Product
        Batch batch = new Batch();
        batch.setInitialQuantity(100);
        batch.setCurrentQuantity(100);
        batch.setDueDate(LocalDate.of(2022, 12, 31));
        batch.setManufacturingDate(LocalDate.of(2022, 1, 1));
        batch.setManufacturingTime(LocalDateTime.of(2022, 1, 1, 0, 0, 0));
        batch.setBatchNumber(3);
        batch.setCurrentTemperature(20.5);
        batch.setMinimumTemperature(15.0);
        batch.setInboundOrder(inboundOrder); // Use the managed entity here
        batch.setProduct(product);
        batch.setSection(section);

        // Save the Batch after ensuring the InboundOrder is managed
        iBatchRepository.save(batch);

        // Act
        ResultActions result = mockMvc.perform(get("/api/v1/fresh-products/list?category=FF")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .accept(MediaType.APPLICATION_JSON));

        result.andDo(print());

        // Assert
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2));
    }

    @Test
    @DisplayName("When getProducts is called, then it should return the product list")
    @WithMockUser(roles = "SELLER")
    void getAllProducts() throws Exception {

        User user = new User();
        user.setFirstName("testUser2");
        user.setEmail("test2@test.com");
        user.setPassword("password");
        user.setRole(Role.SELLER);

        // Generate token with an additional claim "role"
        HashMap<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role", "SELLER");
        String token = jwtTokenService.generateToken(extraClaims, user);

        // Act
        ResultActions result = mockMvc.perform(get("/api/v1/fresh-products/list")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .accept(MediaType.APPLICATION_JSON));

        result.andDo(print());

        // Assert
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1));
    }
}
