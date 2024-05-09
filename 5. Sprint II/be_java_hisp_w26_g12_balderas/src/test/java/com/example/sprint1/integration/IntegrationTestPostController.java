package com.example.sprint1.integration;

import com.example.sprint1.dto.PostDto;
import com.example.sprint1.dto.ProductDto;
import com.example.sprint1.model.Post;
import com.example.sprint1.repository.IPostRepository;
import com.example.sprint1.service.IPostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestPostController {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    IPostRepository postRepository;

    @Autowired
    IPostService postService;


    /**
     * Integration test that adds a post
     * @throws Exception
     */
    @Test
    public void testAddPost() throws Exception{
        ProductDto productDto = new ProductDto(
                9, "Product 9", "Type 9", "Brand whatever", "Yellow", "This's prodcut 9"
        );

        PostDto postDto = new PostDto(
                9, 3, "20-09-2023", 1, 900.01, productDto
        );

        MvcResult result = mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(postDto)))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        String jsonResponse = result.getResponse().getContentAsString();

        PostDto responsePostDto = new ObjectMapper().readValue(jsonResponse, PostDto.class);

        //System.out.println(responsePostDto);

        Post post = postRepository.findById(9);

        assertEquals(post.getId(),9);

    }

}
