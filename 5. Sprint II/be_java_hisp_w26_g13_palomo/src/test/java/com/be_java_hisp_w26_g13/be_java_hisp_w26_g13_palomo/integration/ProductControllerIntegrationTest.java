package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.integration;


import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto.PostDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;


    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    public void createProductTestOk() throws Exception {
        PostDTO postDTO = PostDTO.builder()
                .userId(1)
                .date(LocalDate.now())
                .product(ProductDTO.builder()
                        .productId(1)
                        .productName("Silla Gamer")
                        .type("Gamer")
                        .brand("Racer")
                        .color("RedBlack")
                        .notes("Special Edition")
                        .build())
                .category(100)
                .price(1500.50)
                .build();

        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postDTO)));

        System.console().printf(resultActions.andReturn().getResponse().getContentAsString());

        resultActions
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("The post has been successfully created"));


    }
}
