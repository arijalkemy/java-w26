package org.example.social_meli.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.example.social_meli.dto.PostDTO;
import org.example.social_meli.dto.ProductDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper objectMapper;

    private static ObjectWriter objectWriter;

    private static Integer userId = 153;

    @BeforeAll
    public static void setUp(){
        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        objectMapper = new ObjectMapper();
    }


    @Test
    void postProductPost() throws Exception {

        String url = String.format("/products/post");

        ProductDTO product = new ProductDTO(2, "product", "C", "Test", "red", "something");
        LocalDate date = LocalDate.of(2024, 5, 9);
        @Positive(message = "El id debe ser mayor a 0") @NotNull(message = "El id no puede ser vacío")
        PostDTO postDto = new PostDTO(userId, 2, date, product, 1, 150000D);

        ResultActions results = mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(postDto)))
                    .andExpect(MockMvcResultMatchers.status().isOk()
                );

        String resultString = results.andReturn().getResponse().getContentAsString();
        String expectedString = objectMapper.writeValueAsString(postDto);

        Assertions.assertEquals(expectedString, resultString);
    }
}