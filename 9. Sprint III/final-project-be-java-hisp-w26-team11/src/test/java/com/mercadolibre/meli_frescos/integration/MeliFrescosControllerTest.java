package com.mercadolibre.meli_frescos.integration;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.meli_frescos.dto.frescos.*;
import com.mercadolibre.meli_frescos.repository.IBatchRepository;
import com.mercadolibre.meli_frescos.repository.IInboundOrderRepository;
import com.mercadolibre.meli_frescos.repository.IUserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.meli_frescos.dto.frescos.PurchaseOrderDTO;
import com.mercadolibre.meli_frescos.dto.frescos.PurchaseRequestDTO;
import com.mercadolibre.meli_frescos.dto.frescos.PurchasedProductDTO;
import com.mercadolibre.meli_frescos.dto.frescos.StatusDTO;
import com.mercadolibre.meli_frescos.repository.IProductRepository;
import com.mercadolibre.meli_frescos.repository.ISectionRepository;
import com.mercadolibre.meli_frescos.repository.IWarehouseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import com.mercadolibre.meli_frescos.dto.auth.AuthResponseDto;
import com.mercadolibre.meli_frescos.dto.auth.LoginRequestDto;
import com.mercadolibre.meli_frescos.service.AuthServiceImpl;
import org.junit.jupiter.api.Test;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class MeliFrescosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    AuthServiceImpl authService;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IBatchRepository batchRepository;

    @Autowired
    private ISectionRepository sectionRepository;

    @Autowired
    private IWarehouseRepository warehouseRepository;

    @Autowired
    private IInboundOrderRepository inboundOrderRepository;

    @Autowired
    private IUserRepository userRepository;

    InboundOrderRequestDTO inboundOrderRequestDTO;
    InboundOrderDTO inboundOrderDTO;
    SectionDTO sectionDTO;
    BatchStockRequestDTO batchStockRequestDTO;

    InboundOrderResponseDTO inboundOrderResponseDTO;
    BatchStockResponseDTO batchStockResponseDTO;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        inboundOrderRequestDTO = new InboundOrderRequestDTO();
        inboundOrderDTO = new InboundOrderDTO();
        sectionDTO = new SectionDTO();
        batchStockRequestDTO = new BatchStockRequestDTO();

        batchStockRequestDTO.setProductId(1);
        batchStockRequestDTO.setBatchNumber(3);
        batchStockRequestDTO.setCurrentQuantity(10);
        batchStockRequestDTO.setInitialQuantity(10);
        batchStockRequestDTO.setCurrentTemperature(10.00);
        batchStockRequestDTO.setMinimumTemperature(10.00);

        sectionDTO.setWarehouseCode(2);
        sectionDTO.setSectionCode(7);

        inboundOrderDTO.setSection(sectionDTO);
        inboundOrderDTO.setOrderNumber(9);
        inboundOrderDTO.setBatchStock(List.of(batchStockRequestDTO));

        inboundOrderRequestDTO.setInboundOrder(inboundOrderDTO);

        // Update data
        batchStockResponseDTO = BatchStockResponseDTO.builder()
                .productId(1)
                .batchNumber(2)
                .currentQuantity(10)
                .initialQuantity(10)
                .currentTemperature(10.00)
                .minimumTemperature(10.00)
                .build();

        inboundOrderResponseDTO = InboundOrderResponseDTO.builder()
                .batchStock(List.of(batchStockResponseDTO))
                .build();
    }

    @Test
    @DisplayName("Prueba de integración: Obtener lotes ordenados por fecha de vencimiento")
    public void testListOrderedDueDateProducts_Integration() throws Exception {

        AuthResponseDto authResponseDto = authService.login(new LoginRequestDto("rep_user1", "password1"));

        // Realizar solicitud y capturar la respuesta
        mockMvc.perform(get("/api/v1/fresh-products/batch/list/due-date/10")
                        .header("Authorization", "Bearer " + authResponseDto.getToken())
                        .param("order", "date_asc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

//        // Imprimir la respuesta JSON real
//        String jsonResponse = result.getResponse().getContentAsString();
//        System.out.println(jsonResponse);
//
//        // Realizar las verificaciones de la respuesta
//        mockMvc.perform(get("/api/v1/fresh-products/batch/list/due-date/10")
//                        .param("order", "date_asc")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.batch_stock_extended_dtolist[0].due_date").value(currentDate.plusDays(5).toString()))
//                .andExpect(jsonPath("$.batch_stock_extended_dtolist[1].due_date").value(currentDate.plusDays(7).toString()));
    }

    @Test
    @DisplayName("Testeando el registro de una orden de compra 200 con un batch echado a perder")
    void registerOrder() throws Exception {
        AuthResponseDto authResponseDto = authService.login(new LoginRequestDto("buyer_user1", "password1"));

        PurchaseOrderDTO purchaseOrder = new PurchaseOrderDTO(LocalDate.of(2024, 6, 17), 5,
                new StatusDTO("Carrito"),
                List.of(new PurchasedProductDTO(1, 7))
        );
        PurchaseRequestDTO purchaseRequestDTO = new PurchaseRequestDTO(purchaseOrder);

        String purchaseJson = objectMapper.writeValueAsString(purchaseRequestDTO);

        mockMvc.perform(post("/api/v1/fresh-products/orders")
                        .header("Authorization", "Bearer " + authResponseDto.getToken())
                        .contentType("application/json")
                        .content(purchaseJson))
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json("{'total_cost': 70}"));

    }

    @Test
    @DisplayName("Testeando el registro de una orden sin payload 400")
    void registerOrder400() throws Exception {
        AuthResponseDto authResponseDto = authService.login(new LoginRequestDto("buyer_user1", "password1"));

        mockMvc.perform(post("/api/v1/fresh-products/orders")
                        .header("Authorization", "Bearer " + authResponseDto.getToken())
                        .content("{}")
                        .contentType("application/json"))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("Testeando la actualizacion de una orden sin payload 400")
    void updateOrder400() throws Exception {
        AuthResponseDto authResponseDto = authService.login(new LoginRequestDto("buyer_user1", "password1"));

        mockMvc.perform(put("/api/v1/fresh-products/orders")
                        .header("Authorization", "Bearer " + authResponseDto.getToken())
                        .content("{}")
                        .contentType("application/json"))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("Testeando el registro de una orden de compra ya existe 400")
    void registerOrder400OrdenDuplicada() throws Exception {
        AuthResponseDto authResponseDto = authService.login(new LoginRequestDto("buyer_user1", "password1"));
        PurchaseOrderDTO purchaseOrder = new PurchaseOrderDTO(LocalDate.of(2024, 6, 17), 4,
                new StatusDTO("Carrito"),
                List.of(new PurchasedProductDTO(1, 7),
                        new PurchasedProductDTO(3, 100))
        );
        PurchaseRequestDTO purchaseRequestDTO = new PurchaseRequestDTO(purchaseOrder);

        String purchaseJson = objectMapper.writeValueAsString(purchaseRequestDTO);

        mockMvc.perform(post("/api/v1/fresh-products/orders")
                        .header("Authorization", "Bearer " + authResponseDto.getToken())
                        .contentType("application/json")
                        .content(purchaseJson))
                .andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("Testeando la actualización de una orden de compra 200")
    void updateOrder() throws Exception {
        AuthResponseDto authResponseDto = authService.login(new LoginRequestDto("buyer_user1", "password1"));

        PurchaseOrderDTO purchaseOrder = new PurchaseOrderDTO(LocalDate.of(2024, 6, 17), 3,
                new StatusDTO("Carrito"),
                List.of(new PurchasedProductDTO(1, 5))
        );
        PurchaseRequestDTO purchaseRequestDTO = new PurchaseRequestDTO(purchaseOrder);
        String purchaseJson = objectMapper.writeValueAsString(purchaseRequestDTO);

        mockMvc.perform(put("/api/v1/fresh-products/orders")
                        .header("Authorization", "Bearer " + authResponseDto.getToken())
                        .contentType("application/json")
                        .content(purchaseJson))
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json("{'total_cost': 50}"));
    }

    @Test
    void listProductStockByWarehouse_returnsCorrectResponse() throws Exception {
        // Arrange
        Integer productId = 1;
        AuthResponseDto authResponseDto = authService.login(new LoginRequestDto("rep_user1", "password1"));

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/" + productId + "/warehouse/list")
                        .header("Authorization", "Bearer " + authResponseDto.getToken()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(productId));
    }

    @Test
    @DisplayName("Testeando la actualización de una orden de compra no existente existe 404")
    void updateOrder404() throws Exception {
        AuthResponseDto authResponseDto = authService.login(new LoginRequestDto("buyer_user1", "password1"));

        PurchaseOrderDTO purchaseOrder = new PurchaseOrderDTO();
        purchaseOrder.setBuyerId(10);

        PurchaseRequestDTO purchaseRequestDTO = new PurchaseRequestDTO(purchaseOrder);
        String purchaseJson = objectMapper.writeValueAsString(purchaseRequestDTO);

        mockMvc.perform(post("/api/v1/fresh-products/orders")
                        .header("Authorization", "Bearer " + authResponseDto.getToken())
                        .contentType("application/json")
                        .content(purchaseJson))
                .andExpect(status().isNotFound());
    }

    @Test
    void listProductsOk() throws Exception {
        AuthResponseDto authresponseDto = authService.login(new LoginRequestDto("buyer_user1", "password1"));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products/list")
                        .header("Authorization", "Bearer " + authresponseDto.getToken()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$").isArray()
                );
    }

    @Test
    void listProductStockByWarehouse_returnsNotFoundForNonExistingProduct() throws Exception {
        // Arrange
        Integer nonExistingProductId = 9999;
        AuthResponseDto authResponseDto = authService.login(new LoginRequestDto("rep_user1", "password1"));

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/" + nonExistingProductId + "/warehouse/list")
                        .header("Authorization", "Bearer " + authResponseDto.getToken()))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

    @Test
    void listProductsWithValidParam() throws Exception {
        AuthResponseDto authresponseDto = authService.login(new LoginRequestDto("buyer_user1", "password1"));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products/list?acronym=FS")
                        .contentType("application/json")
                        .header("Authorization", "Bearer " + authresponseDto.getToken())
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty()
                );
    }

    @Test
    void listProductsWithInvalidParam() throws Exception {
        AuthResponseDto authresponseDto = authService.login(new LoginRequestDto("buyer_user1", "password1"));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products/list?acronym=AC")
                        .contentType("application/json")
                        .header("Authorization", "Bearer " + authresponseDto.getToken()))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.message").value("404 we can't find the products")
                );
    }

    @Test
    void listOrderProductsOK() throws Exception {
        AuthResponseDto authresponseDto = authService.login(new LoginRequestDto("buyer_user1", "password1"));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/orders/{orderId}", 1)
                        .contentType("application/json")
                        .header("Authorization", "Bearer " + authresponseDto.getToken()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$").isArray()
                );
    }

    @Test
    void listOrderProductsNoOk() throws Exception {
        AuthResponseDto authresponseDto = authService.login(new LoginRequestDto("buyer_user1", "password1"));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/orders/1001")
                        .contentType("application/json")
                        .header("Authorization", "Bearer " + authresponseDto.getToken()))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.message").value("Purchase Order not found")
                );
    }

    /**
     * Este caso de prueba está diseñado para probar la creación de una orden de entrada en el sistema.
     * Utiliza el ObjectWriter para convertir el objeto inboundOrderRequestDTO en una cadena de texto JSON.
     * Esta cadena de texto se envía al endpoint "/api/v1/inbound-order" utilizando una solicitud POST.
     * El test verifica que el estado de la respuesta sea 200 OK, indicando que la orden de entrada fue creada exitosamente.
     *
     */
    @Test
    @DisplayName("crear inbound order service ok")
    public void createInboundOrderTest() throws Exception {
        batchStockRequestDTO.setBatchNumber(5);
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();


        String payload = writer.writeValueAsString(inboundOrderRequestDTO);

        urlGetIsOk("/api/v1/fresh-products/inboundorder", payload);

    }

    /**
     * Este caso de prueba está diseñado para probar la creación de una orden de entrada que ya existe en el sistema.
     * Configura el número de orden a 1, que ya existe en el sistema.
     * Utiliza el ObjectWriter para convertir el objeto inboundOrderRequestDTO en una cadena de texto JSON.
     * Esta cadena de texto se envía al endpoint "/api/v1/inbound-order" utilizando una solicitud POST.
     * El test verifica que el estado de la respuesta no sea 200 OK, indicando que la orden de entrada ya existe.
     *
     */
    @Test
    @DisplayName("crear inbound order existe error")
    public void createInboundOrderExistTest() throws Exception {
        inboundOrderDTO.setOrderNumber(1);
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();


        String payload = writer.writeValueAsString(inboundOrderRequestDTO);
        urlGetIsNoOk("/api/v1/fresh-products/inboundorder", payload, "Inbound Order ya existe");
    }

    /**
     * Este caso de prueba está diseñado para probar la creación de una orden de entrada con un almacén que no existe en el sistema.
     * Configura el código del almacén a 100, que no existe en el sistema.
     * Utiliza el ObjectWriter para convertir el objeto inboundOrderRequestDTO en una cadena de texto JSON.
     * Esta cadena de texto se envía al endpoint "/api/v1/inbound-order" utilizando una solicitud POST.
     * El test verifica que el estado de la respuesta no sea 200 OK, indicando que el almacén no existe.
     *
     */
    @Test
    @DisplayName("crear inbound order warehouse no existe error")
    public void createInboundOrderWarehouseNoExistTest() throws Exception {
        sectionDTO.setWarehouseCode(100);
        inboundOrderDTO.setOrderNumber(10);
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();


        String payload = writer.writeValueAsString(inboundOrderRequestDTO);
        urlGetIsNoOk("/api/v1/fresh-products/inboundorder", payload, "Warehouse no existe");
    }

    /**
     * Este caso de prueba está diseñado para probar la creación de una orden de entrada con una sección que no existe en el sistema.
     * Configura el código de la sección a 100, que no existe en el sistema.
     * Utiliza el ObjectWriter para convertir el objeto inboundOrderRequestDTO en una cadena de texto JSON.
     * Esta cadena de texto se envía al endpoint "/api/v1/inbound-order" utilizando una solicitud POST.
     * El test verifica que el estado de la respuesta no sea 200 OK, indicando que la sección no existe.
     *
     */
    @Test
    @DisplayName("crear inbound order section no existe error")
    public void createInboundOrderSectionNoExistTest() throws Exception {
        sectionDTO.setSectionCode(100);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();


        String payload = writer.writeValueAsString(inboundOrderRequestDTO);
        urlGetIsNoOk("/api/v1/fresh-products/inboundorder", payload, "Section no existe");
    }

    /**
     * Este caso de prueba está diseñado para probar la actualización de una orden de entrada en el sistema con datos correctos.
     * Configura el número de orden a 1 y el número de lote a 2.
     * Utiliza el ObjectMapper para convertir el objeto inboundOrderRequestDTO en una cadena de texto JSON.
     * Esta cadena de texto se envía al endpoint "/api/v1/fresh-products/inboundorder" utilizando una solicitud PUT.
     * El test verifica que el estado de la respuesta sea 201 CREATED, indicando que la orden de entrada fue actualizada exitosamente.
     *
     */
    @Test
    @DisplayName("Actualizar inbound order con datos correctos")
    public void updateInboundOrderTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        inboundOrderDTO.setOrderNumber(1);
        batchStockRequestDTO.setBatchNumber(2);

        String content = mapper.writeValueAsString(inboundOrderRequestDTO);

        String expectedResponse = mapper.writeValueAsString(inboundOrderResponseDTO);

        AuthResponseDto authResponseDto = authService.login(new LoginRequestDto("rep_user1", "password1"));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/fresh-products/inboundorder")
                        .contentType("application/json")
                        .header("Authorization", "Bearer " + authResponseDto.getToken())
                        .content(content))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

        Assertions.assertEquals(expectedResponse, result.getResponse().getContentAsString());
    }

    /**
     * Este caso de prueba está diseñado para probar la actualización de una orden de entrada que no existe en el sistema.
     * Configura el número de orden a 100, que no existe en el sistema.
     * El test verifica que el estado de la respuesta no sea 201 CREATED, indicando que la orden de entrada no existe.
     *
     */
    @Test
    @DisplayName("Actualizar inbound order no existente")
    public void updateInboundOrderNoExistTest() throws Exception {
        inboundOrderDTO.setOrderNumber(100);

        updateSomethingNoExist("Inbound Order not found");
    }

    /**
     * Este caso de prueba está diseñado para probar la actualización de una orden de entrada con un almacén que no existe en el sistema.
     * Configura el código del almacén a 100, que no existe en el sistema.
     * El test verifica que el estado de la respuesta no sea 201 CREATED, indicando que el almacén no existe.
     *
     */
    @Test
    @DisplayName("Actualizar inbound order, pero el warehouse no existe")
    public void updateWarehouseNoExistTest() throws Exception {
        inboundOrderDTO.setOrderNumber(1);
        sectionDTO.setWarehouseCode(100);

        updateSomethingNoExist("Warehouse not found");
    }

    /**
     * Este caso de prueba está diseñado para probar la actualización de una orden de entrada con una sección que no existe en el sistema.
     * Configura el código de la sección a 100, que no existe en el sistema.
     * El test verifica que el estado de la respuesta no sea 201 CREATED, indicando que la sección no existe.
     *
     */
    @Test
    @DisplayName("Actualizar inbound order, pero section no existe")
    public void updateSectionNoExistTest() throws Exception {
        inboundOrderDTO.setOrderNumber(1);
        sectionDTO.setSectionCode(100);

        updateSomethingNoExist("Section not found");
    }

    /**
     * Este caso de prueba está diseñado para probar la actualización de una orden de entrada con un lote que no existe en el sistema.
     * Configura el número de lote a 100, que no existe en el sistema.
     * El test verifica que el estado de la respuesta no sea 201 CREATED, indicando que el lote no existe.
     *
     */
    @Test
    @DisplayName("Actualizar inbound order, pero el batch no existe")
    public void updateBatchNoExistTest() throws Exception {
        inboundOrderDTO.setOrderNumber(1);
        batchStockRequestDTO.setBatchNumber(100);

        updateSomethingNoExist("Batch not found");
    }

    /**
     * Este caso de prueba está diseñado para probar la actualización de una orden de entrada donde la capacidad de la sección se supera.
     * Configura la cantidad actual del lote a 1000, superando la capacidad de la sección.
     * El test verifica que el estado de la respuesta no sea 201 CREATED, indicando que la capacidad de la sección se ha superado.
     *
     */
    @Test
    @DisplayName("Actualizar inbound order, pero la capacidad de la sección fue superada")
    public void sectionCapacityExceededTest() throws Exception {
        inboundOrderDTO.setOrderNumber(1);
        batchStockRequestDTO.setCurrentQuantity(1000);

        updateSomethingNoExist("Section capacity exceeded");
    }

    private void urlGetIsOk(String url, String payload) throws Exception {
        AuthResponseDto authResponseDto = authService.login(new LoginRequestDto("rep_user1", "password1"));
        this.mockMvc.perform(MockMvcRequestBuilders.post(url).contentType("application/json")
                        .header("Authorization", "Bearer " + authResponseDto.getToken())
                        .content(payload))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    private void urlGetIsNoOk(String url, String payload, String expectedValue) throws Exception {
        AuthResponseDto authResponseDto = authService.login(new LoginRequestDto("rep_user1", "password1"));
        this.mockMvc.perform(MockMvcRequestBuilders.post(url).contentType("application/json")
                        .header("Authorization", "Bearer " + authResponseDto.getToken())
                        .content(payload))
                .andDo(print())
                .andExpect(status().isBadRequest()).andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error").value(expectedValue));
    }

    private void updateSomethingNoExist (String errorExpected) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String content = mapper.writeValueAsString(inboundOrderRequestDTO);
        AuthResponseDto authResponseDto = authService.login(new LoginRequestDto("rep_user1", "password1"));

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/fresh-products/inboundorder")
                        .contentType("application/json")
                        .header("Authorization", "Bearer " + authResponseDto.getToken())
                        .content(content))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error").value(errorExpected));
    }


    @Test
    @DisplayName("RE 3: Should return product batches successfully")
    public void testListBatchesOfProduct_Success() throws Exception {
        // Arrange
        Integer productId = 3;
        // Act & Assert
        AuthResponseDto authResponseDto = authService.login(new LoginRequestDto("rep_user1", "password1"));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/" + productId + "/batch/list")
                        .header("Authorization", "Bearer " + authResponseDto.getToken())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(productId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.batch_stock").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.batch_stock.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.section.section_code").value(7))
                .andExpect(MockMvcResultMatchers.jsonPath("$.section.warehouse_code").value(1002));
    }

    @Test
    @DisplayName("RE 3: Should return 404 when product not found")
    public void testListBatchesOfProduct_ProductNotFound() throws Exception {
        // Arrange
        Integer productId = 9999;


        // Act & Assert
        AuthResponseDto authResponseDto = authService.login(new LoginRequestDto("rep_user1", "password1"));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/" + productId + "/batch/list")
                        .header("Authorization", "Bearer " + authResponseDto.getToken())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("Product not found"));
    }

    @Test
    @DisplayName("RE 3: Should return 404 when no batches found")
    public void testListBatchesOfProduct_NoBatchesFound() throws Exception {
        // Arrange
        Integer productId = 5;

        // Act & Assert
        AuthResponseDto authResponseDto = authService.login(new LoginRequestDto("rep_user1", "password1"));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/" + productId + "/batch/list")
                        .header("Authorization", "Bearer " + authResponseDto.getToken())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("No batches found for product"));
    }

    @Test
    @DisplayName("RE 3: Product must appear in different batches")
    public void testListBatchesOfProduct_DifferentBatches() throws Exception {
        // Arrange
        Integer productId = 1;


        // Act & Assert
        AuthResponseDto authResponseDto = authService.login(new LoginRequestDto("rep_user1", "password1"));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/fresh-products/" + productId + "/batch/list")
                        .header("Authorization", "Bearer " + authResponseDto.getToken())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("Product must appear in different batches"));
    }


}
