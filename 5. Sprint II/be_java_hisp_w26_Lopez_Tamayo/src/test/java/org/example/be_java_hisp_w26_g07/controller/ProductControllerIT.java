package org.example.be_java_hisp_w26_g07.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.be_java_hisp_w26_g07.dto.products.PostRequestDto;
import org.example.be_java_hisp_w26_g07.dto.products.ProductDto;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.tags.Param;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIT {
@Autowired
private MockMvc mockMvc;


    @Test
    public void testGetLatestPostWithValueUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()")
                        .value(3));

    }

    @Test
    public void testGetLatestPostWithUserNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 11))
                .andDo(print()).andExpect(status().isNotFound());

    }

    @Test
    public void testWhenIsNotSeller() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 11))
                .andDo(print()).andExpect(status().isNotFound());

    }

    @Test
    public void testGetLatestPostWithValueUserWhithoutOrder() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1)
                        .param("order", "noOrder"))
                .andDo(print()).andExpect(status().isBadRequest());

    }

    @Test
    public void testGetWithOutPosts() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 6)
                        .param("order", "noOrder"))
                .andDo(print()).andExpect(status().isBadRequest());

    }

    @Test
    public void testToAddNewPost() throws Exception {
        ProductDto productDto = new ProductDto(
           12, "ventilador", "hola", "samurai", "blanco","solo bajo pedido"
        );
        PostRequestDto postRequestDto = new PostRequestDto(1, LocalDate.now(), productDto, 2, 56.9);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String postRequestJson = writer.writeValueAsString(postRequestDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postRequestJson))
                .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testSearchUserId() throws Exception {
        ProductDto productDto = new ProductDto(
                12, "ventilador", "hola", "samurai", "blanco","solo bajo pedido"
        );
        PostRequestDto postRequestDto = new PostRequestDto(11, LocalDate.now(), productDto, 2, 56.9);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String postRequestJson = writer.writeValueAsString(postRequestDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postRequestJson))
                .andDo(print()).andExpect(status().isBadRequest());

    }






}
