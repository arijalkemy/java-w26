package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.integration;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PostDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PostsByFollowedUsersDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTests {
    @Autowired
    private MockMvc mockMvc;

    private ObjectWriter writer;

    @BeforeEach
    public void setup() {
        this.writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer()
                .withDefaultPrettyPrinter();
    }

    @Test
    public void createPostTest() throws Exception {
        ProductDTO existingProduct = new ProductDTO(12, "PlayStation 5",
                "Console", "Sony", "White", "Supports ray tracing");
        PostDTO postDTO = new PostDTO(1000, 1, LocalDate.now(), existingProduct, 1, 400.0);
        String payloadJSON = writer.writeValueAsString(postDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.message")
                        .value("The post has been successfully created"));
    }

    @Test
    public void followedVendorsLastPosts() throws Exception {
        int userId = 2;
        ProductDTO product = new ProductDTO(1000,
                "HyperX Cloud II",
                "Headset",
                "HyperX",
                "Red",
                "Excellent noise canceling");
        List<PostDTO> expectedPosts = List.of(
                new PostDTO(2001, 1, LocalDate.now(), product, 1,2000.0),
                new PostDTO(2002, 1, LocalDate.now(), product, 1,2000.0)
        );
        PostsByFollowedUsersDTO expectedResponse = new PostsByFollowedUsersDTO(2, expectedPosts);
        var result = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId)
        );

        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse)));
    }
}
