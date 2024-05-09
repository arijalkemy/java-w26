package org.mercadolibre.NotNullTeam.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mercadolibre.NotNullTeam.DTO.request.post.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.product.ProductDTO;
import org.mercadolibre.NotNullTeam.DTO.response.post.PostsByFollowedDTO;
import org.mercadolibre.NotNullTeam.mapper.PostMapper;
import org.mercadolibre.NotNullTeam.model.Post;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.model.User;
import org.mercadolibre.NotNullTeam.repository.IBuyerRepository;
import org.mercadolibre.NotNullTeam.repository.ISellerRepository;
import org.mercadolibre.NotNullTeam.service.IPostService;
import org.mercadolibre.NotNullTeam.utils.GeneratorTest;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PostIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    private ObjectWriter writer;

    private Seller seller;
    private PostDTO post;

    @Autowired
    IBuyerRepository buyerRepository;

    @Autowired
    ISellerRepository sellerRepository;

    @Autowired
    IPostService postService;

    @BeforeEach
    void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        post = GeneratorTest.getPostDTO();
    }

    @Test
    @DisplayName("Se crea un nuevo post asociado a Seller con Id 2L")
    void testCreatePost() throws Exception {
        createPostSuccessfully(post);
    }

    private void createPostSuccessfully(PostDTO post) throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType("application/json")
                        .content(writer.writeValueAsString(post)))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Se intenta crear un post asociado a Seller con Id 2L pasando un PostDTO invalido (en este caso fecha vacia) por lo que devuelve un 400")
    void testCreatePostWithInvalidPost() throws Exception {
        post.setDate(null);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType("application/json")
                        .content(writer.writeValueAsString(post)))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.date").value("La fecha no puede estar vacía."));
    }

    @Test
    @DisplayName("Se intenta crear un post asociado a Seller con Id 1L (seller inexistente) por lo que devuelve un 404 NotFoundException")
    void testCreatePostWithInvalidSeller() throws Exception {
        post.setUserId(1L);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType("application/json")
                        .content(writer.writeValueAsString(post)))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Seller not found"));
    }

    @Test
    @DisplayName("Se obtiene la lista de posteos, realizados por un vendedor que es seguido por el Buyer con id 3L, dentro de las ultimas 2 semanas.")
    void testFollowedListByBuyerId() throws Exception {
        PostsByFollowedDTO expected = GeneratorTest.createPostsByFollowedDTO(post);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 3L))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(expected)));
    }
}
