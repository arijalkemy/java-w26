package org.example.be_java_hisp_w26_g07.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.validation.ConstraintViolationException;
import org.example.be_java_hisp_w26_g07.dto.errors.ValidErrorDto;
import org.example.be_java_hisp_w26_g07.dto.products.PostDto;
import org.example.be_java_hisp_w26_g07.dto.products.PostRequestDto;
import org.example.be_java_hisp_w26_g07.entity.Post;
import org.example.be_java_hisp_w26_g07.utils.GeneratorDataTest;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIT {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper;
    private ObjectWriter writer;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
        writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @DisplayName("Integration Test - Creación de un nuevo post de manera correcta")
    @Test
    public void createPostHappyPathIntegrationTest() throws Exception {
        // Arrange
        PostRequestDto postRequestDto = GeneratorDataTest.getPostRequestDto();
        Post post = mapper.convertValue(postRequestDto, Post.class);
        post.setId(11);
        PostDto postDto = mapper.convertValue(post, PostDto.class);
        String expected1 = writer.writeValueAsString(postDto);
        // Act
        ResultActions response = mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(postRequestDto))
        );
        // Assert
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(result -> assertEquals(
                        expected1, result.getResponse().getContentAsString(StandardCharsets.UTF_8))
                );
    }

    @DisplayName("Integration Test - Creación de un nuevo post con datos ingresado de manera invalida")
    @Test
    public void createPostWhenTheDataIsInvalidIntegrationTest() throws Exception {
        // Arrange
        PostRequestDto postRequestDto = GeneratorDataTest.getPostRequestDtoWithInvalidData();
        Map<String, String> mistakes = new TreeMap<>();
        mistakes.put("product.id", "El id debe ser mayor a cero");
        mistakes.put("product.color", "El campo no puede poseer caracteres especiales.");
        mistakes.put("product.name", "La longitud no puede superar los 40 caracteres.");
        mistakes.put("product.type", "El campo no puede estar vacío.");
        mistakes.put("userId", "El id debe ser mayor a cero");
        ValidErrorDto validErrorDto = new ValidErrorDto("Por favor corregir los siguientes datos: ", mistakes, "/products/post");
        String expected = writer.writeValueAsString(validErrorDto);
        System.out.println(expected);
        // Act
        ResultActions response = mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(postRequestDto))
        );
        // Assert
        response.andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", CoreMatchers.is(validErrorDto.getMessage())))
                .andExpect(jsonPath("$.uri", CoreMatchers.is(validErrorDto.getUri())))
                .andExpect(jsonPath("$.mistakes", CoreMatchers.is(validErrorDto.getMistakes())));
    }

}
