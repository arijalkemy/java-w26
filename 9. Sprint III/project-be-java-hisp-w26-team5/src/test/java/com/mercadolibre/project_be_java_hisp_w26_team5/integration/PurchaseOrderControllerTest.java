package com.mercadolibre.project_be_java_hisp_w26_team5.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.exception.ExceptionDetails;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.OrderStatusRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.ProductRequestPurchaseOrderDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.PurchaseOrderDataRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.PurchaseOrderRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.ProductDetailResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.ProductOfPurchaseOrderResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.PurchaseOrderCreatedResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.enums.TypeProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.mercadolibre.project_be_java_hisp_w26_team5.utils.TestUtils.getPurchaseOrderRequestDTO;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PurchaseOrderControllerTest {
    @Autowired
    MockMvc mockMvc;

    // these fields are created from data-test.sql
    private final Integer BUYER_ID = 102;
    private final Integer SELLER_ID = 100;
    private final Double PRICE_PRODUCT_ID_100 = 300d;
    private final Double PRICE_PRODUCT_ID_101 = 300d;

    ObjectMapper objectMapper = new ObjectMapper();

    ObjectWriter objectWriter;

    public PurchaseOrderControllerTest() {
        objectMapper.registerModule(new JavaTimeModule());
        objectWriter = objectMapper
                .configure(
                        SerializationFeature.WRAP_ROOT_VALUE,
                        false
                )
                .writer();
    }

    @Test
    @WithMockUser(roles = "BUYER")
    @DisplayName("Should create a purchase order with buyer user successfully")
    void createPurchaseOrderSuccessfully() throws Exception {
        // arrange
        final Integer PRODUCT_100_QUANTITY = 10;
        final Integer PRODUCT_101_QUANTITY = 5;

        List<ProductRequestPurchaseOrderDTO> products = getProductsRequest(PRODUCT_100_QUANTITY, PRODUCT_101_QUANTITY);

        PurchaseOrderRequestDTO purchaseOrderRequest = getPurchaseOrderRequestDTO(
                BUYER_ID,
                products
        );

        PurchaseOrderCreatedResponseDTO expected = new PurchaseOrderCreatedResponseDTO();
        expected.setTotalPrice(PRODUCT_100_QUANTITY * PRICE_PRODUCT_ID_100 + PRODUCT_101_QUANTITY * PRICE_PRODUCT_ID_101);
        expected.setId(1);

        //act
        MvcResult mvcResult = this.mockMvc
                .perform(post("/api/v1/purchase-orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(purchaseOrderRequest)))
                .andDo(print())
                .andReturn();

        PurchaseOrderCreatedResponseDTO purchaseOrderCreatedResponseDTO = objectMapper.readValue(
                mvcResult
                        .getResponse()
                        .getContentAsString(),
                PurchaseOrderCreatedResponseDTO.class
        );

        //assert
        Assertions.assertEquals(
                HttpStatus.CREATED.value(),
                mvcResult
                        .getResponse()
                        .getStatus()
        );
        Assertions.assertEquals(
                expected,
                purchaseOrderCreatedResponseDTO
        );
    }

    @Test
    @WithMockUser(roles = "BUYER")
    @DisplayName("Should create a purchase order with seller user fail")
    void createPurchaseOrderFail() throws Exception {
        // arrange
        final Integer PRODUCT_100_QUANTITY = 10;

        ProductRequestPurchaseOrderDTO product1 = new ProductRequestPurchaseOrderDTO();
        product1.setProductId(100);
        product1.setQuantity(PRODUCT_100_QUANTITY);

        PurchaseOrderRequestDTO purchaseOrderRequest = getPurchaseOrderRequestDTO(
                SELLER_ID,
                List.of(product1)
        );

        //act
        MvcResult mvcResult = this.mockMvc
                .perform(post("/api/v1/purchase-orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(purchaseOrderRequest)))
                .andDo(print())
                .andReturn();

        ExceptionDetails exception = objectMapper.readValue(
                mvcResult
                        .getResponse()
                        .getContentAsString(),
                ExceptionDetails.class
        );

        //assert
        String EXCEPTION_USER_ROLE_MISMATCH = "Expected user with role: BUYER";
        Assertions.assertEquals(
                EXCEPTION_USER_ROLE_MISMATCH,
                exception.getMessage()
        );
        Assertions.assertEquals(
                HttpStatus.BAD_REQUEST.value(),
                mvcResult
                        .getResponse()
                        .getStatus()
        );
    }

    @Test
    @WithMockUser(roles = "BUYER")
    @DisplayName("Should create a purchase order successfully but has a product without stock")
    void createPurchaseOrderSuccessfullyButHasAProductWithoutStock() throws Exception {
        // arrange
        final Integer PRODUCT_100_QUANTITY = 10000;
        final Integer PRODUCT_101_QUANTITY = 5;

        List<ProductRequestPurchaseOrderDTO> products = getProductsRequest(PRODUCT_100_QUANTITY, PRODUCT_101_QUANTITY);

        PurchaseOrderRequestDTO purchaseOrderRequest = getPurchaseOrderRequestDTO(
                BUYER_ID,
                products
        );

        PurchaseOrderCreatedResponseDTO expected = new PurchaseOrderCreatedResponseDTO();
        // only product 101 because of product 100 has not stock
        expected.setTotalPrice(PRODUCT_101_QUANTITY * PRICE_PRODUCT_ID_101);
        expected.setId(1);
        expected.setProductsWithoutStock(List.of(getMessageProductHasNotStock(100)));

        //act
        MvcResult mvcResult = this.mockMvc
                .perform(post("/api/v1/purchase-orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(purchaseOrderRequest)))
                .andDo(print())
                .andReturn();

        PurchaseOrderCreatedResponseDTO purchaseOrderCreatedResponseDTO = objectMapper.readValue(
                mvcResult
                        .getResponse()
                        .getContentAsString(),
                PurchaseOrderCreatedResponseDTO.class
        );

        //assert
        Assertions.assertEquals(
                HttpStatus.CREATED.value(),
                mvcResult
                        .getResponse()
                        .getStatus()
        );
        Assertions.assertEquals(
                expected,
                purchaseOrderCreatedResponseDTO
        );
    }

    @Test
    @WithMockUser(roles = "BUYER")
    @DisplayName("Should create a purchase order successfully but has a products without stock")
    void createPurchaseOrderSuccessfullyButHasProductsWithoutStock() throws Exception {
        // arrange
        final Integer PRODUCT_100_QUANTITY = 10000;
        final Integer PRODUCT_101_QUANTITY = 50000;

        List<ProductRequestPurchaseOrderDTO> products = getProductsRequest(PRODUCT_100_QUANTITY, PRODUCT_101_QUANTITY);

        PurchaseOrderRequestDTO purchaseOrderRequest = getPurchaseOrderRequestDTO(
                BUYER_ID,
                products
        );

        PurchaseOrderCreatedResponseDTO expected = new PurchaseOrderCreatedResponseDTO();
        // 0 because of product 100 and product 101 has not stock
        expected.setTotalPrice(0d);
        expected.setId(1);

        //act
        MvcResult mvcResult = this.mockMvc
                .perform(post("/api/v1/purchase-orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(purchaseOrderRequest)))
                .andDo(print())
                .andReturn();

        PurchaseOrderCreatedResponseDTO purchaseOrderCreatedResponseDTO = objectMapper.readValue(
                mvcResult
                        .getResponse()
                        .getContentAsString(),
                PurchaseOrderCreatedResponseDTO.class
        );

        //assert
        Assertions.assertEquals(
                HttpStatus.CREATED.value(),
                mvcResult
                        .getResponse()
                        .getStatus()
        );
        Assertions.assertEquals(
                expected.getTotalPrice(),
                purchaseOrderCreatedResponseDTO.getTotalPrice()
        );
        Assertions.assertEquals(
                expected.getId(),
                purchaseOrderCreatedResponseDTO.getId()
        );
        Assertions.assertEquals(
                2,
                purchaseOrderCreatedResponseDTO
                        .getProductsWithoutStock()
                        .size()
        );
    }

    @Test
    @WithMockUser(roles = "BUYER")
    @DisplayName("Get a order by id successfully")
    void getPurchaserOrderByIdSuccessfully() throws Exception {
        // arrange
        List<ProductOfPurchaseOrderResponseDTO> productsExpected = getAStoragePurchaseOrderProducts();

        //act
        MvcResult mvcResult = this.mockMvc
                .perform(get("/api/v1/purchase-orders/{idOrder}/products",
                        101).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();

        List<ProductOfPurchaseOrderResponseDTO> result = objectMapper.readValue(
                mvcResult
                        .getResponse()
                        .getContentAsString(),
                new TypeReference<List<ProductOfPurchaseOrderResponseDTO>>() {
                }
        ).stream().sorted(Comparator.comparing(p -> p.getProduct().getId())).toList();

        //assert
        Assertions.assertEquals(
                HttpStatus.OK.value(),
                mvcResult
                        .getResponse()
                        .getStatus()
        );
        Assertions.assertEquals(
                productsExpected,
                result
        );

    }

    @Test
    @WithMockUser(roles = "BUYER")
    @DisplayName("Get a order by id fail")
    void getPurchaserOrderByIdFail() throws Exception {
        MvcResult mvcResult = this.mockMvc
                .perform(get("/api/v1/purchase-orders/{idOrder}/products",
                        400).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    @WithMockUser(roles = "BUYER")
    @DisplayName("Should update a purchase order successfully")
    void updatePurchaseOrderSuccessfully() throws Exception {

        // arrange
        final Integer PRODUCT_100_QUANTITY = 10;
        final Integer PRODUCT_101_QUANTITY = 5;

        List<ProductRequestPurchaseOrderDTO> products = getProductsRequest(PRODUCT_100_QUANTITY, PRODUCT_101_QUANTITY);

        PurchaseOrderRequestDTO purchaseOrderRequest = getPurchaseOrderRequestDTO(
                BUYER_ID,
                products
        );

        PurchaseOrderCreatedResponseDTO expected = new PurchaseOrderCreatedResponseDTO();
        expected.setTotalPrice(PRODUCT_100_QUANTITY * PRICE_PRODUCT_ID_100 + PRODUCT_101_QUANTITY * PRICE_PRODUCT_ID_101);
        expected.setId(101);

        //act
        MvcResult mvcResult = this.mockMvc
                .perform(put("/api/v1/purchase-orders/{idOrder}",
                        101).contentType(MediaType.APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(purchaseOrderRequest)))
                .andDo(print())
                .andReturn();

        PurchaseOrderCreatedResponseDTO purchaseOrderCreatedResponseDTO = objectMapper.readValue(
                mvcResult
                        .getResponse()
                        .getContentAsString(),
                PurchaseOrderCreatedResponseDTO.class
        );

        //assert
        Assertions.assertEquals(
                HttpStatus.OK.value(),
                mvcResult
                        .getResponse()
                        .getStatus()
        );
        Assertions.assertEquals(
                expected,
                purchaseOrderCreatedResponseDTO
        );
    }

    private List<ProductRequestPurchaseOrderDTO> getProductsRequest(Integer quantityProd1, Integer quantityProd2){
        ProductRequestPurchaseOrderDTO product1 = new ProductRequestPurchaseOrderDTO();
        product1.setProductId(100);
        product1.setQuantity(quantityProd1);

        ProductRequestPurchaseOrderDTO product2 = new ProductRequestPurchaseOrderDTO();
        product2.setProductId(101);
        product2.setQuantity(quantityProd2);

        return Arrays.asList(product1, product2);
    }

    private static List<ProductOfPurchaseOrderResponseDTO> getAStoragePurchaseOrderProducts() {
        ProductOfPurchaseOrderResponseDTO productDetail1 = new ProductOfPurchaseOrderResponseDTO();
        ProductOfPurchaseOrderResponseDTO productDetail2 = new ProductOfPurchaseOrderResponseDTO();
        productDetail1.setQuantity(20);
        productDetail2.setQuantity(10);
        ProductDetailResponseDto product1 = new ProductDetailResponseDto();
        ProductDetailResponseDto product2 = new ProductDetailResponseDto();
        product1.setId(100);
        product1.setName("Milk");
        product1.setDescription("Fresh milk");
        product1.setType(TypeProduct.FS);
        String strDate = "2022-01-02 00:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(strDate, formatter);
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        product1.setCreationDate(instant);

        product2.setId(101);
        product2.setName("Apple");
        product2.setDescription("Apple");
        product2.setType(TypeProduct.FS);
        product2.setCreationDate(instant);

        productDetail1.setProduct(product1);
        productDetail2.setProduct(product2);

        List<ProductOfPurchaseOrderResponseDTO> productsExpected = List.of(
                productDetail1,
                productDetail2
        );
        return productsExpected;
    }

    private String getMessageProductHasNotStock(Integer productId) {
        String EXCEPTION_PRODUCT_WITHOUT_STOCK = "There is not enough stock of the product with id: ";
        return EXCEPTION_PRODUCT_WITHOUT_STOCK + productId;
    }

}
