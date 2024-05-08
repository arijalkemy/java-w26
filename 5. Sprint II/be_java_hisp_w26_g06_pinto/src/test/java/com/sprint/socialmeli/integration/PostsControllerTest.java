package com.sprint.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sprint.socialmeli.dto.ExceptionDto;
import com.sprint.socialmeli.dto.post.PostDTO;
import com.sprint.socialmeli.dto.post.ProductDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostsControllerTest {

    @Autowired
    MockMvc mockMvc;

    private static Integer sellerId;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static ObjectMapper writer;

    @BeforeAll
    static void setUp() {
        sellerId = 1;
        writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    }

    @Test
    @DisplayName("Create a correct Post")
    void createPost() throws Exception {

        // Arrange
        PostDTO postDTO = PostDTO.builder()
                .user_id(sellerId)
                .date(LocalDate.now().format(formatter))
                .product(
                    ProductDTO.builder()
                        .product_id(2)
                        .product_name("Silla Interior")
                        .type("Interior")
                        .brand("Razer")
                        .color("Red and black")
                        .notes("")
                    .build())
                .category(1)
                .price(344.2)
                .build();
        String postDTOString = writer.writeValueAsString(postDTO);

        // Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postDTOString))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // Assert
        assertEquals(String.valueOf(0), result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Create a Post with wrong format date")
    void createPostWithWrongFormatDate() throws Exception {

        // Arrange
        String wrongDate = "2021-11-03";
        PostDTO postDTO = PostDTO.builder()
                .user_id(sellerId)
                .date(wrongDate)
                .product(
                        ProductDTO.builder()
                                .product_id(2)
                                .product_name("Silla Interior")
                                .type("Interior")
                                .brand("Razer")
                                .color("Red and black")
                                .notes("")
                                .build())
                .category(1)
                .price(344.2)
                .build();
        String postDTOString = writer.writeValueAsString(postDTO);

        // Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postDTOString))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andReturn();

        // Assert
        assertTrue(result.getResponse().getContentAsString().contains(wrongDate));
    }

    @Test
    @DisplayName("Create a Post with not existing seller ID")
    void createPostWithNotExistingSeller() throws Exception {

        // Arrange
        Integer unknownSellerId = 400;
        PostDTO postDTO = PostDTO.builder()
                .user_id(unknownSellerId)
                .date(LocalDate.now().format(formatter))
                .product(
                        ProductDTO.builder()
                                .product_id(2)
                                .product_name("Silla Interior")
                                .type("Interior")
                                .brand("Razer")
                                .color("Red and black")
                                .notes("")
                                .build())
                .category(1)
                .price(344.2)
                .build();
        String postDTOString = writer.writeValueAsString(postDTO);

        String exceptionDTOString = writer
                .writeValueAsString(new ExceptionDto("Seller with ID: " + unknownSellerId + " not found"));

        // Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postDTOString))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();

        // Assert
        assertEquals(exceptionDTOString, result.getResponse().getContentAsString());
    }
}