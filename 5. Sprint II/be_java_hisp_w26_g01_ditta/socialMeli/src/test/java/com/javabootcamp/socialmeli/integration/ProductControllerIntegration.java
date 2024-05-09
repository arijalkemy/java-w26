package com.javabootcamp.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.javabootcamp.socialmeli.dto.request.PostDto;
import com.javabootcamp.socialmeli.dto.request.ProductDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Dado un PostDTO correcto devuelve http status 200")
    public void postPostTest() throws Exception {
        PostDto postDtoInput = new PostDto(1, LocalDate.of(2024, 07, 25),
                new ProductDto(1, "Mesa", "mueble", "mueblix", "marron", "moderno"),
                5, 100d);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(postDtoInput);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Dado un usuario CLIENTE que no sigue a nadie devuelve un http status 400")
    public void getPostFromLastTwoWeeksTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/products/followed/{userId}/list", 1))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
