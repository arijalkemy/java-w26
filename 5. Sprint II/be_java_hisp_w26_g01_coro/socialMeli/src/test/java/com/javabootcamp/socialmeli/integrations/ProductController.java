package com.javabootcamp.socialmeli.integrations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabootcamp.socialmeli.dto.request.PostDto;
import com.javabootcamp.socialmeli.dto.request.ProductDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductController {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private PostDto newPost;
    private ProductDto productToPost;

    @Test
    @DisplayName("Post se debe subir correctamente")
    void happyPath() throws Exception {
        productToPost = new ProductDto(1,"nombre","silla",
                "tesla", "rojo", "es muy lindo");
        newPost= new PostDto(1, LocalDate.now(),productToPost,12,120.5);
        this.performTestOk(newPost);
    }


    private void performTestOk(PostDto newPost) throws Exception {
        String requestBody = objectMapper.writeValueAsString(newPost);
        ResultActions result = mockMvc.perform(post("/products/post")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }
}
