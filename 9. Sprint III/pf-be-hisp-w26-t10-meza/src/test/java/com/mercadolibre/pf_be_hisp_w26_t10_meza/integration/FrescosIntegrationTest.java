package com.mercadolibre.pf_be_hisp_w26_t10_meza.integration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.repository.IUserAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.unit.ShoppingCartUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.dtos.*;
import com.mercadolibre.pf_be_hisp_w26_t10_meza.service.implementations.BatchServiceImpl;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@SpringBootTest(classes = {com.mercadolibre.pf_be_hisp_w26_t10_meza.Application.class})
@AutoConfigureMockMvc
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FrescosIntegrationTest {
    private UploadBatchRequestDto uploadBatchRequestDto;
    private UploadBatchRequestDto updateBatchRequestDto;
    static ObjectWriter writer;

    @Autowired
    IUserAccountRepository userAccountRepository;
    @Autowired
    MockMvc mockMvc;
    @MockBean
    BatchServiceImpl batchServiceImpl;

    @BeforeAll
    public static void setupWriter(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    public void setup(){
        this.uploadBatchRequestDto = new UploadBatchRequestDto();
        this.updateBatchRequestDto = new UploadBatchRequestDto();
        InboundOrderDto inboundOrderDto = new InboundOrderDto();
        InboundOrderDto inboundOrderUpdated = new InboundOrderDto();
        SectionDto sectionDto = new SectionDto();

        sectionDto.setSectionCode(1);
        sectionDto.setWarehouseCode(1);

        inboundOrderDto.setOrderNumber(1020);
        inboundOrderDto.setOrderDate(LocalDate.of(2024, 6, 17));
        inboundOrderDto.setSectionDto(sectionDto);
        inboundOrderDto.setBatchDto(
                Arrays.asList(
                        new BatchDto(
                                1,
                                1,
                                32.1,
                                31.0,
                                4,
                                7,
                                LocalDate.of(2024, 6, 17),
                                LocalTime.of(9,0,0),
                                LocalDate.of(2025, 6, 17))));

        inboundOrderUpdated.setOrderNumber(1020);
        inboundOrderUpdated.setOrderDate(LocalDate.of(2024, 6, 17));
        inboundOrderUpdated.setSectionDto(sectionDto);
        inboundOrderUpdated.setBatchDto(
                Arrays.asList(
                        new BatchDto(
                                1,
                                1,
                                42.1,
                                41.0,
                                4,
                                7,
                                LocalDate.of(2024, 6, 17),
                                LocalTime.of(9,0,0),
                                LocalDate.of(2025, 6, 17))));


        uploadBatchRequestDto.setInboundOrderDto(inboundOrderDto);
        updateBatchRequestDto.setInboundOrderDto(inboundOrderUpdated);

    }

    @Test
    @DisplayName("Integration Test US0001 - Generating the response of a Batch inserted into the stock")
    public void batchInStockSuccessfully() throws Exception{
        String payload = writer.writeValueAsString(uploadBatchRequestDto);

        BatchResponseDto responseDto = new BatchResponseDto();
        responseDto.setBatch_stock(uploadBatchRequestDto.getInboundOrderDto().getBatchDto());
        when(batchServiceImpl.uploadBatchIntoStock(uploadBatchRequestDto)).thenReturn(responseDto);

        String requestAccess = getToken("mluis", "12345");
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fresh-products/inboundorder")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + requestAccess)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(payload)))
                        .andDo(print()).andExpect(status().isCreated())
                        .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        BatchResponseDto responseDto1 = objectMapper.readValue(jsonResponse, BatchResponseDto.class);

        Assertions.assertEquals(responseDto,responseDto1 );
    }


    @Test
    @DisplayName("")
    public void batchInStockUpdatedSuccessfully() throws Exception {
        String payload = writer.writeValueAsString(updateBatchRequestDto);

        BatchResponseDto responseDto = new BatchResponseDto();
        responseDto.setBatch_stock(updateBatchRequestDto.getInboundOrderDto().getBatchDto());
        when(batchServiceImpl.updateBatchInStock(updateBatchRequestDto)).thenReturn(responseDto);

        String requestAccess = getToken("mluis", "12345");
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/fresh-products/inboundorder")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + requestAccess)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(payload)))
                .andDo(print()).andExpect(status().isCreated())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        BatchResponseDto responseDto1 = objectMapper.readValue(jsonResponse, BatchResponseDto.class);

        Assertions.assertEquals(responseDto,responseDto1 );
    }


    private String getToken(String username, String password) throws Exception {

        String jsonBody = "{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(response);

        return jsonNode.get("token").asText();
    }

    @Test
    @DisplayName("US-002-ISSUE-06-Get products from shopping cart Integration test")


    public void getProductsFromShoppingCart() throws Exception {
        String username = "jgonz";
        String password = "12345";

        String token = getToken(username,password);

        Integer idOrder = 3;
        MvcResult mvcResult = mockMvc.perform(get("/api/v1/fresh-products/orders/{idOrder}", idOrder)
                        .header("Authorization","Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].name").value("Yogur Natural"))
                .andReturn();
    }
    @Test
    @DisplayName("US-2-ISSUE-5 create order ok integration test")
    public void createOrderHappyIntegration() throws Exception{

        String username = "jgonz";
        String password = "12345";

        String token = getToken(username,password);

        List<Product> products = List.of(ShoppingCartUtils.getProductOne());

        PurchaseOrderDto order = new PurchaseOrderDto(
                new PurchaseOrderDetailsDto(
                        LocalDate.now().plusWeeks(3),
                        11,
                        new OrderStatusDto("shopping_cart"),
                        List.of(new ProductRequestDto(products.get(0).getId(), 10))
                )
        );

        MvcResult mvcResult = mockMvc.perform(
                        post("/api/v1/fresh-products/orders")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(writer.writeValueAsString(order))
                                .header("Authorization", format("Bearer %s", token)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        PurchaseValueResponseDto expected = new PurchaseValueResponseDto(
                (products.get(0).getPrice() * order.getDetails().getProducts().get(0).getQuantity())
        );

        assertEquals(writer.writeValueAsString(expected).replaceAll("\\s",""), mvcResult.getResponse().getContentAsString());
    }
    @Test
    @DisplayName("US-2-ISSUE-5 Sad Path Creating order without valid products")
    public void sadPathIntegrationOrderCreation() throws Exception{

        String username = "jgonz";
        String password = "12345";

        String token = getToken(username,password);

        Integer invalidProductId = -13;

        PurchaseOrderDto order = new PurchaseOrderDto(
                new PurchaseOrderDetailsDto(
                        LocalDate.now(),
                        1,
                        new OrderStatusDto("shopping_cart"),
                        List.of(new ProductRequestDto(invalidProductId, 10))
                )
        );

        mockMvc.perform(
                        post("/api/v1/fresh-products/orders")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(writer.writeValueAsString(order))
                                .header("Authorization", format("Bearer %s", token)))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No tienes productos validos en el carrito"))
                .andReturn();
    }
}
