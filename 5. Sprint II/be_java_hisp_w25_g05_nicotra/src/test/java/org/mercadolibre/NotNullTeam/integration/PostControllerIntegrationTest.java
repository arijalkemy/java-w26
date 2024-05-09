package org.mercadolibre.NotNullTeam.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mercadolibre.NotNullTeam.DTO.request.post.PostDTO;
import org.mercadolibre.NotNullTeam.mapper.PostMapper;
import org.mercadolibre.NotNullTeam.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Se crea un post con exito")
    public void testCreatePost() throws Exception {
        Product product = Product.builder()
                .id(1L)
                .name("Product1")
                .type("Chair")
                .brand("Gamer")
                .color("White")
                .notes("Very gamer with RGB")
                .build();

        PostDTO postDTO = new PostDTO(5L, "01-01-2024",
                PostMapper.productToProductDto(product), 2, 100.0);

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType("application/json")
                        .content(toJson(postDTO)));

        result.andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Falla al crear un post con categoria menor a 1")
    public void testCreatePostBadRequest() throws Exception {
        Product product = Product.builder()
                .id(1L)
                .name("Product1")
                .type("Chair")
                .brand("Gamer")
                .color("White")
                .notes("Very gamer with RGB")
                .build();

        PostDTO postDTO = new PostDTO(5L, "01-01-2024",
                PostMapper.productToProductDto(product), -1, 100.0);

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType("application/json")
                        .content(toJson(postDTO)));


        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.category").value("La categoría debe ser mayor a cero."));
    }

    //Convertir a byte el objeto PostDTO
    private byte[] toJson(PostDTO postDTO) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsBytes(postDTO);
    }
}
