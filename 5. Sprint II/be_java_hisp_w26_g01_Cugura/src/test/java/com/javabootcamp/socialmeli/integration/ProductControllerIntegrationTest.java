package com.javabootcamp.socialmeli.integration;

import java.time.LocalDate;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.javabootcamp.socialmeli.dto.request.PostDto;
import com.javabootcamp.socialmeli.dto.request.ProductDto;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter WRITER;

    @BeforeAll
    static void init() {
        WRITER = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

    }

    @Test
    void whenTryToPostPublicationProduct() throws JsonProcessingException, Exception{
        PostDto postDto = new PostDto(
            1,
            LocalDate.of(2024, 5, 8),
            new ProductDto(
                1,
                "Manzanas",
                "Comida",
                "Barata",
                "Verde",
                "Muy rica"
            ),
            1,
            10.0
        );

        this.mockMvc
            .perform(
                MockMvcRequestBuilders.post("/products/post")
                .content(WRITER.writeValueAsString(postDto))
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
            )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
