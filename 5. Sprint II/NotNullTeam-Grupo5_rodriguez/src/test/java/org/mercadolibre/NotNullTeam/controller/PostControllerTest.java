package org.mercadolibre.NotNullTeam.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.*;
import org.mercadolibre.NotNullTeam.DTO.request.post.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.product.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    private static final String URL_BASE = "/products";

    static ProductDTO productDTO;
    static PostDTO postDTO;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        productDTO = ProductDTO
                .builder()
                .productId(1L)
                .productName("Producto 1")
                .type("Nuevo")
                .brand("Marca 1")
                .color("Rojo")
                .notes("Notas")
                .build();
        postDTO = PostDTO
                .builder()
                .product(productDTO)
                .userId(3L)
                .price(1000.0)
                .category(1)
                .date(LocalDateTime
                        .now()
                        .format(DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                .build();

    }


    @Test
    @Order(1)
    @DisplayName("Crear un Post correctamente")
    void createPostOk() throws Exception {
        String url = URL_BASE + "/post";

        mockMvc
                .perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postDTO)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").isNumber())
                .andReturn();
    }

    @Test
    @Order(2)
    @DisplayName("Se intenta crear un post con un formato de fecha incorrecto yyyy-MM-dd")
    void createPostBadRequestFormatDate() throws Exception {
        String url = URL_BASE + "/post";

        postDTO.setDate(LocalDateTime
                .now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        mockMvc
                .perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

}