package com.meli.be_java_hisp_w26_g10.controller;

import com.api.socialmeli.entity.Post;
import com.api.socialmeli.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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

@SpringBootTest(classes = {com.api.socialmeli.BeJavaHispW26G10Application.class})
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test de Integracion - Obtener post de los seguidos")
    public void getPostsByFollowedIntegrationTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/1/list"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @DisplayName("Test de Integracion - Obtener post de los seguidos - usuario no existe")
    public void getPostsByFollowedIntegrationTestFailed() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/100/list"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Test de Integracion - Creacion Post")
    public void newPostIntegrationTest() throws Exception{
        Product product = new Product(20, "Medias", "Adidas", "Calzado", "Negras", "Sin Notas");
        Post post = new Post(100, LocalDate.now(), 2, 20.0, 1, product,false, 0.0);


        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(post)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
