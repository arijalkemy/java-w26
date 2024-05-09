package org.example.social_meli.controller;

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

import javax.print.attribute.standard.PrinterMessageFromOperator;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Create a post")
    void postProductPost() throws Exception {
        PostDTO postDTO = PostDTO.builder().post_id(1235).user_id(2).date(LocalDate.now()).product(ProductDTO.builder().product_id(1).product_name("Sol solecito").type("Tipo tipo").brand("Ford").color("Azul").notes("Sol solecito").build()).category(4).price(20.00).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post").content(objectMapper.writeValueAsString(postDTO)).contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(postDTO))).andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(2));
    }
}