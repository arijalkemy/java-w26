package org.example.be_java_hisp_w26_g04.service.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.be_java_hisp_w26_g04.dto.PostRequestDTO;
import org.example.be_java_hisp_w26_g04.dto.PostResponseDTO;
import org.example.be_java_hisp_w26_g04.dto.ProductDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    @DisplayName("Se devuelve los posts de los sellers a lo que el usuario sigue correctamente.")
    public void getPostsFromFollowerTest() throws Exception {
        //Arrange

        String json = "[{\"post_id\":5,\"user_id\":234,\"date\":\"28-05-2024\",\"category\":2,\"price\":65.0,\"product\":{\"product_id\":4,\"product_name\":\"Product4\",\"type\":\"TypeD\",\"brand\":\"BrandW\",\"color\":\"Yellow\",\"notes\":\"Some notes about Product4\"}},{\"post_id\":2,\"user_id\":123,\"date\":\"08-05-2024\",\"category\":2,\"price\":75.0,\"product\":{\"product_id\":2,\"product_name\":\"Product2\",\"type\":\"TypeB\",\"brand\":\"BrandY\",\"color\":\"Red\",\"notes\":\"Some notes about Product2\"}}]";
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        List<PostResponseDTO> posts = mapper.readValue(json, new TypeReference<List<PostResponseDTO>>() {});
        String expectedJson = mapper.writeValueAsString(posts);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 456))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }

    @Test
    @Order(2)
    @DisplayName("Se crea un post correctamente.")
    public void createPostTest() throws Exception {
        //Arrange
        String json = "{\"user_id\":123,\"date\":\"20-04-2024\",\"product\":{\"product_id\":5,\"product_name\":\"Silla Gamer\",\"type\":\"Gamer\",\"brand\":\"Racer\",\"color\":\"Red and Black\",\"notes\":\"Special Edition\"},\"category\":100,\"price\":1500.50,\"has_promo\":true,\"discount\":0.25}";

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

}
