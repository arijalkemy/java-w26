package org.example.social_meli.integracion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.social_meli.dto.ExceptionDTO;
import org.example.social_meli.dto.PostDTO;
import org.example.social_meli.dto.ProductDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;

    ProductDTO product;
    PostDTO post;
    PostDTO existedPost;
    ExceptionDTO exception;

    private static ObjectWriter writer;

    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        objectMapper = new ObjectMapper();
    }

    @BeforeEach()
    void setUp(){
        product = ProductDTO.builder()
                .color("Green with RGB")
                .notes("Sin Batería")
                .brand("Razer")
                .productId(62)
                .type("Gamer")
                .productName("Headset RGB Inalámbrico")
                .build();
        post = PostDTO.builder()
                .userId(2)
                .postId(127)
                .category(120)
                .price(200.2)
                .product(product)
                .date(LocalDate.of(2024,2,2))
                .build();
        existedPost = PostDTO.builder()
                .userId(2)
                .postId(20)
                .category(120)
                .price(200.2)
                .product(product)
                .date(LocalDate.of(2024,2,2))
                .build();
        exception = ExceptionDTO.builder()
                .message("Ya existe un post con el id 20")
                .build();

    }
    @Test
    @DisplayName("Test del post de publicación de un producto")
    void postProductPostTest() throws Exception {
        String url = "/products/post";

        ResultActions result = mockMvc.perform(
                        MockMvcRequestBuilders.post(url)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(writer.writeValueAsString(post)))
                .andExpect(MockMvcResultMatchers.status().isOk()
                );
        String stringResult = result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
        String stringExpected = objectMapper.writeValueAsString(post);

        assertEquals(stringExpected,stringResult);

    }

    @Test
    @DisplayName("Test del post de publicación de un producto, con un postId ya existente")
    void postProductExistedPostTest() throws Exception {
        String url = "/products/post";

        ResultActions result = mockMvc.perform(
                        MockMvcRequestBuilders.post(url)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(writer.writeValueAsString(existedPost)))
                .andExpect(MockMvcResultMatchers.status().isConflict()
                );
        String stringResult = result.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
        String stringExpected = objectMapper.writeValueAsString(exception);

        assertEquals(stringExpected,stringResult);

    }
}
