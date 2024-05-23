package com.javabootcamp.socialmeli.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.javabootcamp.socialmeli.dto.request.PostDto;
import com.javabootcamp.socialmeli.dto.request.ProductDto;
import com.javabootcamp.socialmeli.model.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    public static ObjectWriter writer;

    public static ObjectMapper mapper;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        mapper = new ObjectMapper();
    }

    @Test
    public void postPostTest() throws Exception {
        // preparamos el objeto de prueba
        LocalDate fecha = LocalDate.now();
        ProductDto product = new ProductDto(1,"Vaso","Utileria","Nespresso", "Transparente", "Vaso grande transparente");
        PostDto postDto = new PostDto(1,fecha,product,1,200.0);

        // transformamos el request body a json
        String requestBody = mapper.writeValueAsString(postDto);

        // usamos perform para invocar la API
         ResultActions result = mockMvc.perform(
                        MockMvcRequestBuilders.post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody)
                )
                .andExpect(status().isOk());

         result.andDo(MockMvcResultHandlers.print());

    }


    @Test
    @DisplayName("enviar nombre de producto con caracter especia devuelve badRequest")
    public void postPostErrorTest() throws Exception {
        // preparamos el objeto de prueba
        LocalDate fecha = LocalDate.now();
        ProductDto product = new ProductDto(1,"!Vaso","Utileria","Nespresso", "Transparente", "Vaso grande transparente");
        PostDto postDto = new PostDto(1,fecha,product,1,200.0);

        // transformamos el request body a json
        String requestBody = mapper.writeValueAsString(postDto);

        // usamos perform para invocar la API
        ResultActions result = mockMvc.perform(
                        MockMvcRequestBuilders.post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody)
                )
                .andExpect(status().isBadRequest());


        result.andDo(MockMvcResultHandlers.print());
    }

}
