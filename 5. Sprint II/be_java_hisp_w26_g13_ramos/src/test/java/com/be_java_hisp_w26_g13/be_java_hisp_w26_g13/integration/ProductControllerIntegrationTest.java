package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.integration;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PostDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ProductDTO;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static JsonMapper writer;

    @BeforeAll
    public static void setup() {
        writer = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .build();
    }

    @Test
    @DisplayName("Perform test to verify the creation of a post")
    public void createPostTest() throws Exception {

        PostDTO postDTO = PostDTO.builder()
                .userId(1)
                .date(LocalDate.now())
                .product(ProductDTO.builder()
                        .productId(1)
                        .productName("Silla Gamer")
                        .type("Gamer")
                        .brand("Racer")
                        .color("Red")
                        .notes("Special Edition")
                        .build())
                .category(100)
                .price(2500.0)
                .build();

        ResultActions resultActions = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postDTO))
        );

        resultActions.andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message")
                        .value("The post has been successfully created"));

    }


    @Test
    @DisplayName("Perform test to verify the creation of a post with a user that does not exist")
    public void createPostUserNotFoundTest() throws Exception {

        PostDTO postDTO = PostDTO.builder()
                .userId(200)
                .date(LocalDate.now())
                .product(ProductDTO.builder()
                        .productId(1)
                        .productName("Silla Gamer")
                        .type("Gamer")
                        .brand("Racer")
                        .color("Red")
                        .notes("Special Edition")
                        .build())
                .category(100)
                .price(2500.0)
                .build();

        ResultActions resultActions = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postDTO))
        );

        resultActions.andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("User with id 200 does not exist."));

    }

}
