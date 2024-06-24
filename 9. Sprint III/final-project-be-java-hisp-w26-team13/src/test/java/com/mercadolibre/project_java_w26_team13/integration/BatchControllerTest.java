package com.mercadolibre.project_java_w26_team13.integration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.project_java_w26_team13.dtos.ProductStockDto;
import com.mercadolibre.project_java_w26_team13.dtos.WarehouseProductDto;
import com.mercadolibre.project_java_w26_team13.entity.Role;
import com.mercadolibre.project_java_w26_team13.entity.User;
import com.mercadolibre.project_java_w26_team13.jwt.JwtService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.mercadolibre.project_java_w26_team13.dtos.BatchesByProductDTO;
import com.mercadolibre.project_java_w26_team13.dtos.MinimumBatchDTO;
import com.mercadolibre.project_java_w26_team13.dtos.SectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BatchControllerTest extends IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private ObjectWriter writer;

    @Autowired
    JwtService jwtService;

    private static ObjectMapper objectMapper;

    @BeforeEach
    public void setUp(){
        this.writer = new ObjectMapper()
                .writer();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void getProductStockByWarehouseTest() throws Exception {
        List<WarehouseProductDto> warehouseProductDtoList = List.of(new WarehouseProductDto(2013, 100));
        ProductStockDto productStockDto = new ProductStockDto(1, warehouseProductDtoList);
        String expected = writer.writeValueAsString(productStockDto);

        User user = new User(1L, "user1",
                                "$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK",
                                new Role(1L, "representante"));
        String token = jwtService.getToken(user);
        String url = "/api/v1/fresh-products/1/warehouse/list";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(url)
                                    .header("Authorization", "Bearer " + token))
                                    .andExpect(status().isOk())
                                    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                                    .andExpect(jsonPath("product_id").value(1))
                                    .andExpect(jsonPath("$.warehouses").isNotEmpty())
                                    .andReturn();


    }

    @Test
    public void getProductStockByWarehouseBatchListEmptyTest() throws Exception {
        String message = "Batch list for product with id 0 not found.";
        User user = new User(1L, "user1",
                "$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK",
                new Role(1L, "representante"));
        String token = jwtService.getToken(user);

        String url = "/api/v1/fresh-products/0/warehouse/list";

        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .header("Authorization", "Bearer " + token))
                        .andExpect(status().isNotFound())
                        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                        .andExpect(jsonPath("message").value(message));
    }

    @Test
    public void getProductStockByWarehouseNotLoggedInTest() throws Exception {
        String url = "/api/v1/fresh-products/1/warehouse/list";

        mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(status().isForbidden());
    }

    @Test
    public void getBatchesByProductTest() throws Exception {
        Long productId = 1L;

        User user = new User(1L, "user1",
                "$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK",
                new Role(1L, "representante"));

        String token = jwtService.getToken(user);

        var result = this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/api/v1/fresh-products/{idProduct}/batch/list", productId
        ).header("Authorization", "Bearer " + token));

        List<MinimumBatchDTO> batchStock = new ArrayList<>();
        batchStock.add(new MinimumBatchDTO("B001", 100,
                LocalDate.of(2024, 8, 10)));

        BatchesByProductDTO expectedResponse = new BatchesByProductDTO(
                new SectionDTO(1L,1L),
                1L,
                batchStock
        );

        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("product_id").value(1))
                .andExpect(jsonPath("batch_stock[0].batch_number").value("B001"))
                .andExpect(jsonPath("batch_stock[0].current_quantity").value(100))
                .andExpect(jsonPath("batch_stock[0].due_date").value("2024-08-10"))
                .andExpect(jsonPath("section.section_code").value(1))
                .andExpect(jsonPath("section.warehouse_code").value(1));
    }

    @Test
    public void getBatchesByProductOrderedByBatchTest() throws Exception {
        Long productId = 4L;

        User user = new User(1L, "user1",
                "$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK",
                new Role(1L, "representante"));

        String token = jwtService.getToken(user);

        var result = this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/api/v1/fresh-products/{idProduct}/batch/list?order=L", productId
        ).header("Authorization", "Bearer " + token));


        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("product_id").value(productId))
                .andExpect(jsonPath("$.batch_stock.length()").value(3))
                .andExpect(jsonPath("batch_stock[0].batch_number").value("B004"))
                .andExpect(jsonPath("batch_stock[0].current_quantity").value(100))
                .andExpect(jsonPath("batch_stock[0].due_date").value("2024-08-10"))
                .andExpect(jsonPath("batch_stock[1].batch_number").value("B005"))
                .andExpect(jsonPath("batch_stock[1].current_quantity").value(80))
                .andExpect(jsonPath("batch_stock[1].due_date").value("2024-08-09"))
                .andExpect(jsonPath("batch_stock[2].batch_number").value("B006"))
                .andExpect(jsonPath("batch_stock[2].current_quantity").value(60))
                .andExpect(jsonPath("batch_stock[2].due_date").value("2024-08-08"))
                .andExpect(jsonPath("section.section_code").value(1))
                .andExpect(jsonPath("section.warehouse_code").value(1));
    }

    @Test
    public void getBatchesByProductOrderedByQuantityTest() throws Exception {
        Long productId = 4L;

        User user = new User(1L, "user1",
                "$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK",
                new Role(1L, "representante"));

        String token = jwtService.getToken(user);

        var result = this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/api/v1/fresh-products/{idProduct}/batch/list?order=C", productId
        ).header("Authorization", "Bearer " + token));


        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("product_id").value(productId))
                .andExpect(jsonPath("$.batch_stock.length()").value(3))
                .andExpect(jsonPath("batch_stock[0].batch_number").value("B004"))
                .andExpect(jsonPath("batch_stock[0].current_quantity").value(100))
                .andExpect(jsonPath("batch_stock[0].due_date").value("2024-08-10"))
                .andExpect(jsonPath("batch_stock[1].batch_number").value("B005"))
                .andExpect(jsonPath("batch_stock[1].current_quantity").value(80))
                .andExpect(jsonPath("batch_stock[1].due_date").value("2024-08-09"))
                .andExpect(jsonPath("batch_stock[2].batch_number").value("B006"))
                .andExpect(jsonPath("batch_stock[2].current_quantity").value(60))
                .andExpect(jsonPath("batch_stock[2].due_date").value("2024-08-08"))
                .andExpect(jsonPath("section.section_code").value(1))
                .andExpect(jsonPath("section.warehouse_code").value(1));
    }

    @Test
    public void getBatchesByProductOrderedByDateTest() throws Exception {
        Long productId = 4L;

        User user = new User(1L, "user1",
                "$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK",
                new Role(1L, "representante"));

        String token = jwtService.getToken(user);

        var result = this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/api/v1/fresh-products/{idProduct}/batch/list?order=F", productId
        ).header("Authorization", "Bearer " + token));


        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("product_id").value(productId))
                .andExpect(jsonPath("$.batch_stock.length()").value(3))
                .andExpect(jsonPath("batch_stock[0].batch_number").value("B004"))
                .andExpect(jsonPath("batch_stock[0].current_quantity").value(100))
                .andExpect(jsonPath("batch_stock[0].due_date").value("2024-08-10"))
                .andExpect(jsonPath("batch_stock[1].batch_number").value("B005"))
                .andExpect(jsonPath("batch_stock[1].current_quantity").value(80))
                .andExpect(jsonPath("batch_stock[1].due_date").value("2024-08-09"))
                .andExpect(jsonPath("batch_stock[2].batch_number").value("B006"))
                .andExpect(jsonPath("batch_stock[2].current_quantity").value(60))
                .andExpect(jsonPath("batch_stock[2].due_date").value("2024-08-08"))
                .andExpect(jsonPath("section.section_code").value(1))
                .andExpect(jsonPath("section.warehouse_code").value(1));
    }

    @Test
    public void getBatchesByProductInvalidOrderParameter() throws Exception{
        Long productId = 4L;

        User user = new User(1L, "user1",
                "$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK",
                new Role(1L, "representante"));

        String token = jwtService.getToken(user);

        var result = this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/api/v1/fresh-products/{idProduct}/batch/list?order=A", productId
        ).header("Authorization", "Bearer " + token));

        result.andExpect(status().isBadRequest())
              .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
              .andExpect(jsonPath("message").value("Invalid order parameter."));
    }

    @Test
    public void getBatchesByProductNotLoggedInTest() throws Exception {
        Long productId = 1L;

        var result = this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/api/v1/fresh-products/{idProduct}/batch/list", productId
        ));

        result.andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    public void getProductStockByWarehouseInvalidRoleTest() throws Exception{
        String message = "User is not authorized";

        User user = new User(3L, "mia",
                "$2a$10$NzCTdQaQu73yvM7a0Xpzru7KF.Sd.Ff5h8bHNLQVW7lOVRtEAO.Rq",
                new Role(2L, "default"));
        String token = jwtService.getToken(user);

        String url = "/api/v1/fresh-products/1/warehouse/list";

        mockMvc.perform(MockMvcRequestBuilders.get(url)
                .header("Authorization", "Bearer " + token))
                .andExpect(status().isUnauthorized())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("message").value(message));
    }
    @Test
    public void getBatchesByProductInvalidRoleTest() throws Exception {
        Long productId = 1L;

        User user = new User(1L, "mia",
                "$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK",
                new Role(2L, "buyer"));

        String token = jwtService.getToken(user);

        var result = this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/api/v1/fresh-products/{idProduct}/batch/list", productId
        ).header("Authorization", "Bearer " + token));

        result.andDo(print())
                .andExpect(status().isUnauthorized())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("message").value("User is not authorized"));
    }

    @Test
    public void getBatchesByProductNotFoundTest() throws Exception {
        Long productId = 3595L;

        User user = new User(1L, "user1",
                "$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK",
                new Role(1L, "representante"));

        String token = jwtService.getToken(user);

        var result = this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/api/v1/fresh-products/{idProduct}/batch/list", productId
        ).header("Authorization", "Bearer " + token));

        result.andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("message").value("Batch list for product with id "+productId+" not found."));
    }

    @Test
    public void getBatchesByProductInvalidDueDateTest() throws Exception {
        Long productId = 2000L;

        User user = new User(1L, "user1",
                "$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK",
                new Role(1L, "representante"));

        String token = jwtService.getToken(user);

        var result = this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/api/v1/fresh-products/{idProduct}/batch/list", productId
        ).header("Authorization", "Bearer " + token));

        result.andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("message").value("Batch list for product with id "+productId+" not found."));

    }

    @DisplayName("Obtener lista de bacth Ok Integration Test")
    @Test
    public void getBatchDueDateOk() throws Exception {

        User user = new User(1L, "user1",
                "$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK",
                new Role(1L, "representante"));

        String token = jwtService.getToken(user);

        String cantDays = "8";

        var result = this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/api/v1/fresh-products/batch/list/due-date/{cantDays}", cantDays
        ).header("Authorization", "Bearer " + token));



        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("batch_stock[0].batch_number").value("B002"));

    }

    @DisplayName("Obtener lista ordernada asc y filtrada por categoria de bacth Ok Integration Test")
    @Test
    public void getBatchDueDateOkByFilterAndOrderAsc() throws Exception {

        User user = new User(1L, "user1",
                "$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK",
                new Role(1L, "representante"));

        String token = jwtService.getToken(user);

        String cantDays = "8";

        var result = this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/api/v1/fresh-products/batch/list/due-date/{cantDays}", cantDays
        ).header("Authorization", "Bearer " + token)
                .queryParam("category", "FF")
                .queryParam("order", "date_asc"));



        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("batch_stock[0].batch_number").value("B002"));

    }


    @DisplayName("Obtener lista ordernada desc y filtrada por categoria de bacth Ok Integration Test")
    @Test
    public void getBatchDueDateOkByFilterAndOrderdesc() throws Exception {

        User user = new User(1L, "user1",
                "$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK",
                new Role(1L, "representante"));

        String token = jwtService.getToken(user);

        String cantDays = "8";

        var result = this.mockMvc.perform(MockMvcRequestBuilders.get(
                        "/api/v1/fresh-products/batch/list/due-date/{cantDays}", cantDays
                ).header("Authorization", "Bearer " + token)
                .queryParam("category", "FF")
                .queryParam("order", "date_desc"));



        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("batch_stock[0].batch_number").value("B003"));

    }

    @Test
    @DisplayName("Invalid Role En obtener Batch Integration")
    public void getBatchDueDateinvalidRoleTest() throws Exception {

        User user = new User(1L, "mia",
                "$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK",
                new Role(2L, "buyer"));

        String token = jwtService.getToken(user);
        String cantDays = "4";

        var result = this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/api/v1/fresh-products/batch/list/due-date/{cantDays}", cantDays
        ).header("Authorization", "Bearer " + token));

        result.andDo(print())
                .andExpect(status().isUnauthorized())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("message").value("Invalid user role"));
    }

    @Test
    @DisplayName("Invalid Categoria En obtener Batch test Integration")
    public void getBatchDueDateinvalidCategoryTest() throws Exception {

        User user = new User(1L, "user1",
                "$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK",
                new Role(1L, "representante"));

        String token = jwtService.getToken(user);
        String cantDays = "4";
        String invalidCategory = "ss";
        var result = this.mockMvc.perform(MockMvcRequestBuilders.get(
                        "/api/v1/fresh-products/batch/list/due-date/{cantDays}", cantDays
                ).header("Authorization", "Bearer " + token)
                .queryParam("category", invalidCategory)
                .queryParam("order", "date_desc"));

        result.andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("message").value("Invalid category: "+ invalidCategory));
    }
}
