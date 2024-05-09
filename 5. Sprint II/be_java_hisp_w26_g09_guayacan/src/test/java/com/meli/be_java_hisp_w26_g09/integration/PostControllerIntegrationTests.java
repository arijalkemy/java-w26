package com.meli.be_java_hisp_w26_g09.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w26_g09.dto.PostDTO;
import com.meli.be_java_hisp_w26_g09.dto.PostForListDTO;
import com.meli.be_java_hisp_w26_g09.dto.ProductFollowedListDTO;
import com.meli.be_java_hisp_w26_g09.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;


    @Test
    void findFollowedPostsLastTwoWeeksSorted_invalidOrder() throws Exception {
        // Arrange
        String order = "invalid_order";
        // Act
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/1/list?order=" + order))
                .andExpect(status().isBadRequest())
                .andReturn().getResponse().getContentAsString();


    }

    @Test
    void findFollowedPostsLastTwoWeeksSorted_validOrder() throws Exception {
        // Arrange
        String order = "date_asc";
        int customerId = 1;

        // Act
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/" + customerId + "/list?order=" + order))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.posts").isArray());
    }

    @Test
    void findFollowedPostsLastTwoWeeksSorted_validOrder2() throws Exception {
        // Arrange
        String order = "date_desc";
        int customerId = 1;

        // Act
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/" + customerId + "/list?order=" + order))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.posts").isArray());
    }


    @Test
    void postCreatePost_invalidDatePost() throws Exception {
        String payload = "{\n" +
                "    \"user_id\": 17,\n" +
                "    \"date\": \"2024-04-04\",\n" +
                "  }";

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("The format date is dd-MM-yyyy"));


    }

    @Test
    void postCreatePost_validDatePost() throws Exception {
        String payload =
                "{\n" +
                        "    \"user_id\": 17,\n" +
                        "    \"date\": \"04-04-2024\",\n" +
                        "    \"product\": {\n" +
                        "      \"product_id\": 40,\n" +
                        "      \"product_name\": \"HyperX Cloud II Gaming Headset\",\n" +
                        "      \"type\": \"Headset\",\n" +
                        "      \"brand\": \"HyperX\",\n" +
                        "      \"color\": \"Red\",\n" +
                        "      \"notes\": \" Memory foam ear cushions\"\n" +
                        "    },\n" +
                        "    \"category\": 2,\n" +
                        "    \"price\": 99.99\n" +
                        "  }";
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Post has been created"));


    }


}


