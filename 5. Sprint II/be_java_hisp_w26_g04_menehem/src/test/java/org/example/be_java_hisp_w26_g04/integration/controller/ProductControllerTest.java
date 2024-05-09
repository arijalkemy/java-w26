package org.example.be_java_hisp_w26_g04.integration.controller;

import jakarta.validation.ConstraintViolationException;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Creamos un post con éxito")
    void createPost() throws Exception {
        mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "user_id": 123,
                            "date": "08-05-2024",
                            "product": {
                                "product_id": 1,
                                "product_name": "Silla Gamer",
                                "type": "Gamer",
                                "brand": "Racer",
                                "color": "Red and Black",
                                "notes": "Special Edition"
                            },
                            "category": 100,
                            "price": 1500.50
                        }"""))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.blankOrNullString()))
                .andReturn();
    }

    @Test
    @DisplayName("Lanza MethodArgumentNotValidException al post no cumplir con las validaciones")
    void createPostWithValidationsFails() throws Exception {
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                            "user_id": 1,
                            "date": "08-05-2024",
                            "product": {
                                "product_id": -1,
                                "product_name": "Silla Gamer",
                                "type": "Gamer",
                                "brand": "Racer",
                                "color": "Red & Black",
                                "notes": "Special Edition"
                            },
                            "category": 100,
                            "price": 1500.50
                        }"""))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertInstanceOf(MethodArgumentNotValidException.class, result.getResolvedException()));
    }

    @Test
    @DisplayName("Obtenemos los posts de un seguidor con éxito")
    void getPostsFromFollower() throws Exception {
        mockMvc.perform(get("/products/followed/{userId}/list", 456))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{'post_id': 5}, {'post_id': 2}]"))
                .andReturn();
    }

    @Test
    @DisplayName("Lanza ConstraintViolationException si el userId es negativo")
    void getPostsWithBadUserId() throws Exception {
        mockMvc.perform(get("/products/followed/{userId}/list", -456))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertInstanceOf(ConstraintViolationException.class, result.getResolvedException()));
    }
}