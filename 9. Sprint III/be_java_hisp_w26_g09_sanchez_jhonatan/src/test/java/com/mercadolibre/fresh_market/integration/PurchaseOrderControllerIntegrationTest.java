package com.mercadolibre.fresh_market.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.fresh_market.config.security.JwtService;
import com.mercadolibre.fresh_market.dtos.product.ProductDTO;
import com.mercadolibre.fresh_market.dtos.ProjectionPurchaseOrder;
import com.mercadolibre.fresh_market.dtos.PurchaseOrderDTO;
import com.mercadolibre.fresh_market.model.*;
import com.mercadolibre.fresh_market.model.enums.Category;
import com.mercadolibre.fresh_market.model.enums.OrderStatus;
import com.mercadolibre.fresh_market.model.enums.Role;
import com.mercadolibre.fresh_market.repository.*;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class PurchaseOrderControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IPurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IInboundOrderRepository iInboundOrderRepository;

    @Autowired
    private IBatchRepository iBatchRepository;

    @Autowired
    private ISectionRepository sectionRepository;

    @Autowired
    private JwtService jwtTokenService;

    @Autowired
    private IWarehouseRepository warehouseRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ICartDetailRepository cartDetailRepository;
    private PurchaseOrderDTO savedOrder;



    @Test
    @DisplayName("Modify the existence of a purchase order - Failed by authentication")
    public void testModifyOrderExistence_FailedByAuthentication() throws Exception {

        Long orderId = 1L;
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        purchaseOrderDTO.setDate(LocalDate.of(2022, 12, 1));
        purchaseOrderDTO.setBuyerId(1L);
        purchaseOrderDTO.setOrder_status(OrderStatus.SHOPPING_CART);
        purchaseOrderDTO.setProducts(Set.of(
                new ProductDTO(1L, 2),
                new ProductDTO(2L, 3)
        ));

        // Act
        ResultActions result = mockMvc.perform(put("/api/v1/fresh-products/orders/{orderId}", orderId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(purchaseOrderDTO)));

        // Assert
        result.andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "BUYER")
    public void testModifyOrderExistence_Success() throws Exception {
        // Create a test user
        User user = new User();
        user.setFirstName("testUser");
        user.setEmail("test29934342@test.com");
        user.setPassword("password");
        user.setRole(Role.BUYER);
        userRepository.save(user);

        // Generate token with an additional claim "role"
        HashMap<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role", "BUYER");
        String token = jwtTokenService.generateToken(extraClaims, user);

        // Create a purchase order and save it
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setOrderStatus(OrderStatus.SHOPPING_CART);
        purchaseOrder.setDate(LocalDate.now());
        purchaseOrder.setBuyer(user);
        purchaseOrderRepository.save(purchaseOrder);

        // Create a product to associate with the batch and save it
        Product product = new Product();
        product.setId(1L);
        product.setDescription("Test Product");
        product.setPrice(500.00);
        product.setSeller(user);
        productRepository.save(product);

        // Create a warehouseman user for the InboundOrder and save it
        User warehouseman = new User();
        warehouseman.setFirstName("Warehouseman3");
        warehouseman.setEmail("warehouseman339893@test.com");
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

        // Save the Batch after ensuring the InboundOrder is managed
        iBatchRepository.save(batch);

        // Prepare PurchaseOrderDTO for the test
        Long orderId = purchaseOrder.getId();  // Get the ID of the created purchase order
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        purchaseOrderDTO.setDate(LocalDate.of(2022, 12, 1));
        purchaseOrderDTO.setBuyerId(user.getId());  // Buyer ID
        purchaseOrderDTO.setOrder_status(OrderStatus.SHOPPING_CART);
        purchaseOrderDTO.setProducts(Set.of(
                new ProductDTO(product.getId(), 2)  // Product ID and quantity
        ));

        // Make the API call with the authorization token
        ResultActions result = mockMvc.perform(put("/api/v1/fresh-products/orders/{orderId}", orderId)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .content(objectMapper.writeValueAsString(purchaseOrderDTO)));

        result.andDo(print());

        // Verify the expected response status
        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Updated successfully"))
                .andExpect(jsonPath("$.total_price").value(1000.0));

    }

        @Test
    @DisplayName("Test to verify endpoint /api/v1/fresh-products/orders")
    @WithMockUser(roles = "BUYER", username = "test10@test.com")
    void testCreatePurchaseOrder() throws Exception {
        
        //Inserction data

        String endpoint = "/api/v1/fresh-products/orders";
        Long idBuyer = 1L;
        Double priceProduct = 100D;
        Integer quantity = 99;

        // Create a test user
        User user = new User();
        user.setId(idBuyer);
        user.setFirstName("testUser1");
        user.setEmail("test10@test.com");
        user.setPassword("password");
        user.setRole(Role.BUYER);
        userRepository.save(user);
        
        // Generate token with an additional claim "role"
        HashMap<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role", "BUYER");
        String token = jwtTokenService.generateToken(extraClaims, user);
        
        // Create a product to associate with the batch and save it
        Product product = new Product();
        product.setDescription("Test Product");
        product.setPrice(priceProduct);
        product.setSeller(user);
        productRepository.save(product);
       

        PurchaseOrderDTO purchaseOrderDTO = PurchaseOrderDTO.builder()
                .buyerId(idBuyer)
                .date(LocalDate.now())
                .order_status(OrderStatus.SHOPPING_CART)
                .products(
                        Set.of(
                                ProductDTO.builder().productId(product.getId()).quantity(quantity).build())
                                )
                .build();
        
        // Create a warehouseman user for the InboundOrder and save it
        User warehouseman = new User();
        warehouseman.setFirstName("Warehouseman1");
        warehouseman.setEmail("warehouseman32439@test.com");
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
        batch.setDueDate(LocalDate.now());
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
        

        //Arrange
        
        String body = this.objectMapper.writeValueAsString(purchaseOrderDTO);
        MockHttpServletRequestBuilder request = post(endpoint)
                                                .content(body)
                                                .header("Authorization", "Bearer " + token)
                                                .contentType(MediaType.APPLICATION_JSON);
        
        //Act
        ResultActions result = this.mockMvc.perform(request);

        result.andDo(print());

        //Assertion
        result.andExpect(status().isCreated());
        result.andExpect(content().contentType(MediaType.APPLICATION_JSON));
        result.andExpect(jsonPath("$.result.total_price").value(priceProduct*quantity));
    }

    @Test
    @DisplayName("Test to verify endpoint /api/v1/fresh-products/orders")
    @WithMockUser(roles = "BUYER", username = "test9@test.com")
    void testGetProducts() throws Exception {
        
        String endpoint = "/api/v1/fresh-products/orders/{idOrder}";
        Double priceProduct = 100D;
        Integer quantity = 99;

        // Create a test user
        User user = new User();
        user.setFirstName("testUser");
        user.setEmail("test333344@test.com");
        user.setPassword("password");
        user.setRole(Role.BUYER);
        userRepository.save(user);

        // Generate token with an additional claim "role"
        HashMap<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role", "BUYER");
        String token = jwtTokenService.generateToken(extraClaims, user);

        // Create a purchase order and save it
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setOrderStatus(OrderStatus.SHOPPING_CART);
        purchaseOrder.setDate(LocalDate.now());
        purchaseOrder.setBuyer(user);
        purchaseOrderRepository.save(purchaseOrder);

        // Create a product to associate with the batch and save it
        Product product = new Product();
        product.setDescription("Test Product");
        product.setPrice(priceProduct);
        product.setSeller(user);
        productRepository.save(product);

        // Create a warehouseman user for the InboundOrder and save it
        User warehouseman = new User();
        warehouseman.setFirstName("Warehouseman3");
        warehouseman.setEmail("warehouseman36789@test.com");
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

        // Save the Batch after ensuring the InboundOrder is managed
        iBatchRepository.save(batch);

        // Prepare PurchaseOrderDTO for the test
        Long idOrder = purchaseOrder.getId();  // Get the ID of the created purchase order
        
        ShoppingCartKey id = new ShoppingCartKey(idOrder, product.getId());
        CartDetail cartDetail = new CartDetail(id, purchaseOrder, product, quantity);
        cartDetailRepository.save(cartDetail);

        purchaseOrder.setCartDetails(List.of(cartDetail));
        purchaseOrderRepository.save(purchaseOrder);

        //Arrange
        
        MockHttpServletRequestBuilder request = get(endpoint, idOrder)
                                                .header("Authorization", "Bearer " + token)
                                                .contentType(MediaType.APPLICATION_JSON);
        
        ProjectionPurchaseOrder purchaseExpected = objectMapper.convertValue(purchaseOrder, ProjectionPurchaseOrder.class);
                                                //Act
        ResultActions result = this.mockMvc.perform(request);
        MvcResult mvcResult = result.andReturn();
        String content = mvcResult.getResponse().getContentAsString(Charset.forName("utf-8"));
        
        ProjectionPurchaseOrder purchaseResult = objectMapper.readValue(content, ProjectionPurchaseOrder.class);
        result.andDo(print());

        //Assertion
        result.andExpect(status().isOk());
        result.andExpect(content().contentType(MediaType.APPLICATION_JSON));
        assertEquals(purchaseExpected, purchaseResult);
    }
}
