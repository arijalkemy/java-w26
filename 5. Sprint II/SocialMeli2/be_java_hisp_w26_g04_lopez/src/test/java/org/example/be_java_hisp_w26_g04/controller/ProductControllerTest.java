package org.example.be_java_hisp_w26_g04.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.be_java_hisp_w26_g04.dto.PostResponseDTO;
import org.example.be_java_hisp_w26_g04.dto.ProductDTO;
import org.example.be_java_hisp_w26_g04.service.util.UtilTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;


import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private final String url = "/products";

    @Test
    @DisplayName("endpoint /products/post")
    public void savePostOk() throws Exception {
        int userId = 123;
        LocalDate date = LocalDate.now().minusWeeks(1);
        int idPost = 100;
        int category = 1;
        double price = 100.0;
        ProductDTO product = UtilTest.getProduct();

        PostResponseDTO post = PostResponseDTO.builder()
                .userId(userId)
                .idPost(idPost)
                .date(date)
                .category(category)
                .price(price)
                .idPost(idPost)
                .product(product).build();

        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        String payload = mapper.writeValueAsString(post);

        mockMvc.perform(MockMvcRequestBuilders.post(url + "/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("endpoint /products/post req invalido")
    public void savePostReqInvalid() throws Exception {
        int userId = 123;
        LocalDate date = LocalDate.now().minusWeeks(1);
        int idPost = 100;
        int category = 1;
        double price = 100.0;
        ProductDTO product = UtilTest.getProductSpecialChars(); //posee numericos en productos props.

        PostResponseDTO post = PostResponseDTO.builder()
                .userId(userId)
                .idPost(idPost)
                .date(date)
                .category(category)
                .price(price)
                .idPost(idPost)
                .product(product).build();

        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        String payload = mapper.writeValueAsString(post);

        String expectedJson = "{'message':'Hay errores de validación'," +
                "'errors':" +
                "{'product.productName':'El campo no puede contener caracteres especiales'," +
                "'product.notes':'El campo no puede contener caracteres especiales'}}";

        mockMvc.perform(MockMvcRequestBuilders.post(url + "/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectedJson));

    }
}
