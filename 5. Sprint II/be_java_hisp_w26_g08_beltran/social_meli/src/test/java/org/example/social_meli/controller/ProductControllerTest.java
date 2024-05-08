package org.example.social_meli.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.social_meli.dto.PostDTO;
import org.example.social_meli.dto.ProductDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Deberia crear un post de un producto correctamente")
    void postProductPost() throws Exception {
        PostDTO postDTO = PostDTO.builder()
                .post_id(new Random().nextInt(150, 4000))
                .user_id(2)
                .date(LocalDate.now())
                .product(ProductDTO.builder()
                        .product_id(1)
                        .product_name("Producto 1")
                        .type("Tipo 1")
                        .brand("Marca 1")
                        .color("Color 1")
                        .notes("Notas 1")
                        .build())
                .category(1)
                .price(100.0)
                .build();


        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .content(objectMapper.writeValueAsString(postDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(postDTO)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(2));
    }
}