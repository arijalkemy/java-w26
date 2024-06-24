package com.mercadolibre.project_java_w26_team13.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.project_java_w26_team13.dtos.ProductDto;
import com.mercadolibre.project_java_w26_team13.entity.Role;
import com.mercadolibre.project_java_w26_team13.entity.User;
import com.mercadolibre.project_java_w26_team13.jwt.JwtService;
import com.mercadolibre.project_java_w26_team13.repository.IProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest extends IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    JwtService jwtService;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getListTest() throws Exception {

        User user = new User(3L, "mia",
                "$2a$10$NzCTdQaQu73yvM7a0Xpzru7KF.Sd.Ff5h8bHNLQVW7lOVRtEAO.Rq",
                new Role(2L, "buyer"));

        String token = jwtService.getToken(user);

        List<ProductDto> expected = List.of(
                ProductDto.builder().id(1L).name("Producto A").price(10.20).build(),
                ProductDto.builder().id(2L).name("Producto B").price(25.00).build(),
                ProductDto.builder().id(3L).name("Producto C").price(50.25).build(),
                ProductDto.builder().id(4L).name("Producto D").price(10.20).build()
        );

        ResultActions resultActions = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/fresh-products/list")
                        .header("Authorization", "Bearer " + token)
        );

        resultActions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(result -> {
                    String json = result.getResponse().getContentAsString();
                    List<ProductDto> got = objectMapper.readValue(json, new TypeReference<>() {
                    });
                    Assertions.assertEquals(expected, got);
                })
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void getListByCategoryTest() throws Exception {
        User user = new User(3L, "mia",
                "$2a$10$NzCTdQaQu73yvM7a0Xpzru7KF.Sd.Ff5h8bHNLQVW7lOVRtEAO.Rq",
                new Role(2L, "buyer"));

        String token = jwtService.getToken(user);

        List<ProductDto> expected = List.of(
                ProductDto.builder().id(1L).name("Producto A").price(10.20).build()
        );

        ResultActions resultActions = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/fresh-products/list")
                        .header("Authorization", "Bearer " + token)
                        .param("category", "RF")
        );

        resultActions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(content().contentType("application/json"));
    }

}
