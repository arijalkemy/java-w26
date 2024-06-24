package com.mercadolibre.final_project_java_hisp_w26_t6.integration.controller;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.LoginRequestDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.LoginResponseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.ProductDto.ProductsResponseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.SectionDto.ListProductsBatchDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.WarehouseDto.ProductByWarehouseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.integration.ControllerTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductControllerTest extends ControllerTest {

    private final HttpHeaders buyerHeaders = new HttpHeaders();
    private final HttpHeaders supervisorHeaders = new HttpHeaders();

    @BeforeEach
    void setUp() {
        buyerHeaders.setBearerAuth(getAccessToken("bob"));
        supervisorHeaders.setBearerAuth(getAccessToken("charlie"));
    }

    @Test
    @DisplayName("Get all product list correctly")
    void testListProducts(){
        RequestEntity<?> requestEntity = new RequestEntity<>(buyerHeaders, HttpMethod.GET, null );

        ResponseEntity<ProductsResponseDto> responseEntity =
                this.testRestTemplate.exchange(
                        "/api/v1/fresh-products/list", HttpMethod.GET, requestEntity, ProductsResponseDto.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(30, responseEntity.getBody().getProducts().size());
    }

    @Test
    @DisplayName("Error on Get all product list uf user supervisor")
    void testListProductsError(){
        RequestEntity<?> requestEntity = new RequestEntity<>(supervisorHeaders, HttpMethod.GET, null );

        ResponseEntity<ProductsResponseDto> responseEntity =
                this.testRestTemplate.exchange(
                        "/api/v1/fresh-products/list", HttpMethod.GET, requestEntity, ProductsResponseDto.class);

        assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
    }

    @Test
    @DisplayName("Check product location in warehouse of product id 1")
    void listProductsOfBatches(){
        RequestEntity<?> requestEntity = new RequestEntity<>(supervisorHeaders, HttpMethod.GET, null );
        ResponseEntity<ListProductsBatchDto> responseEntity =
                this.testRestTemplate.exchange(
                        "/api/v1/fresh-products/1/batch/list",
                        HttpMethod.GET, requestEntity, ListProductsBatchDto.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    @DisplayName("Check product location in warehouse of unknown product id")
    void listProductsOfBatchesError(){
        RequestEntity<?> requestEntity = new RequestEntity<>(supervisorHeaders, HttpMethod.GET, null );

        ResponseEntity<ProductsResponseDto> responseEntity =
                this.testRestTemplate.exchange(
                        "/api/v1/fresh-products/10000/batch/list", HttpMethod.GET, requestEntity, ProductsResponseDto.class);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    @DisplayName("List Product Quantities For All Warehouses initial situation")
    void listProductQuantitiesForAllWarehouses(){
        RequestEntity<?> requestEntity = new RequestEntity<>(supervisorHeaders, HttpMethod.GET, null );
        ResponseEntity<ProductByWarehouseDto> responseEntity =
                this.testRestTemplate.exchange(
                        "/api/v1/fresh-products/1/warehouse/list",
                        HttpMethod.GET, requestEntity, ProductByWarehouseDto.class);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    // -------------
    private String getAccessToken(String username) {

        LoginRequestDto requestDto = new LoginRequestDto(username, "12345");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RequestEntity<LoginRequestDto> requestEntity = new RequestEntity<>(requestDto, headers, HttpMethod.POST, null );

        ResponseEntity<LoginResponseDto> responseEntity =
                this.testRestTemplate.exchange(
                        "/auth/login", HttpMethod.POST,
                        requestEntity,
                        LoginResponseDto.class
                );
        return responseEntity.getBody().getAccessToken();
    }
}
