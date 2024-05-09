package org.example.social_meli.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.social_meli.dto.PostDTO;
import org.example.social_meli.dto.ProductDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.Random;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private PostDTO createPostDTO() {
        return PostDTO.builder()
                .post_id(new Random().nextInt(150, 2000))
                .user_id(2)
                .date(LocalDate.now())
                .product(ProductDTO.builder()
                        .product_id(1)
                        .product_name("Producto 1")
                        .type("Tipo 1")
                        .brand("Marca 1")
                        .color("Color 1")
                        .notes("Notas 1")
                        .build())
                .category(1)
                .price(100.0)
                .build();
    }

    @Test
    @DisplayName("validar el alta de un post de un producto")
    void postProductPost() throws Exception {
        PostDTO postDTO = createPostDTO();

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .content(objectMapper.writeValueAsString(postDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(postDTO)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(2));
    }

    @Test
    @DisplayName("Validar la lista de seguidos por el usuario")
    void getSellersPostsFollowedByUser() throws Exception {
        Integer userId = 1;
        String url = String.format("/users/%d/followed/list", userId);

        mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("wcalderwood0"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.follower").isEmpty());

    }

}
