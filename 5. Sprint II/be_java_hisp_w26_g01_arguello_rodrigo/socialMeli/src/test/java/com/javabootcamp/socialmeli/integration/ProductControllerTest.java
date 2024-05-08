package com.javabootcamp.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.javabootcamp.socialmeli.dto.request.PostDto;
import com.javabootcamp.socialmeli.dto.request.ProductDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Cuando se ingresa un post devuelve 200")
    public void postPostExitoTest() throws Exception {
        PostDto postDto = new PostDto();
        ProductDto productDto = new ProductDto();
        productDto.setId(1);
        productDto.setBrand("Brand");
        productDto.setType("Type");
        productDto.setName("Name");
        productDto.setColor("Color");
        postDto.setProduct(productDto);
        postDto.setCategory(100);
        postDto.setDate(LocalDate.now());
        postDto.setIdUser(1);
        postDto.setPrice(100.0);

        ObjectWriter objectWriter = new ObjectMapper()
                                    .registerModule(new JavaTimeModule())
                                    .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                                    .writer()
                                    .withDefaultPrettyPrinter();

        String payloadJson = objectWriter.writeValueAsString(postDto);


        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content(payloadJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @DisplayName("Cuando se ingresa un post con producto vacio devuelve 400")
    public void postPostErrorTest() throws Exception{
        PostDto postDto = new PostDto();
        postDto.setCategory(100);
        postDto.setDate(LocalDate.now());
        postDto.setIdUser(1);
        postDto.setPrice(100.0);

        ObjectWriter objectWriter = new ObjectMapper().registerModule(new JavaTimeModule())
                                                      .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                                                      .writer()
                                                      .withDefaultPrettyPrinter();

        String payloadJson = objectWriter.writeValueAsString(postDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content(payloadJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }
}
