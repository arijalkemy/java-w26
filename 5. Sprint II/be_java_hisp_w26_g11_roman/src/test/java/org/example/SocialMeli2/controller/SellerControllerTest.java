package org.example.SocialMeli2.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.SocialMeli2.dto.ProductDTO;
import org.example.SocialMeli2.dto.RequestPostDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SellerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test add post Status 200 OK")
    public void testAddPostOk() throws Exception {
        // Crear una instancia de ProductDTO
        ProductDTO product = new ProductDTO(1, "Producto", "Tipo", "Marca", "Color", "Notas");

        // Crear una instancia de RequestPostDTO
        RequestPostDTO requestPostDTO = new RequestPostDTO(101, LocalDate.of(2024,04,15), product, 1, 100.0);

        ObjectMapper writer = new ObjectMapper().registerModule(new JavaTimeModule());

        String payloadJson = writer.writeValueAsString(requestPostDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson)).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test add post Status 404 No Product Found")
    public void testAddPost404() throws Exception {

        // Crear una instancia de RequestPostDTO
        RequestPostDTO requestPostDTO = new RequestPostDTO(101, LocalDate.of(2024,04,15), null, 1, 100.0);
        // Crear un Mapper para convertir el objeto a JSON
        ObjectMapper writer = new ObjectMapper().registerModule(new JavaTimeModule());
        String payloadJson = writer.writeValueAsString(requestPostDTO);
        // Realizar la petición POST
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson)).andExpect( status().isBadRequest() );
    }
}
