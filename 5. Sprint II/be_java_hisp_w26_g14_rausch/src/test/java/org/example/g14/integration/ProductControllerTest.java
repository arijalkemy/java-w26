package org.example.g14.integration;

import org.example.g14.dto.ProductDto;
import org.example.g14.dto.request.PostCreateRequestDto;
import org.example.g14.model.User;
import org.example.g14.repository.IPostRepository;
import org.example.g14.repository.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Collections;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IPostRepository postRepository;

    @BeforeEach
    public void setup() {
        // Añadir un usuario a la base de datos de prueba
        User user = new User();
        user.setId(1);
        user.setName("testuser");
        user.setIdFollows(Collections.emptyList());
        userRepository.save(user);
    }

    @Test
    public void testCreatePost() throws Exception {
        PostCreateRequestDto postCreateRequestDto = new PostCreateRequestDto();
        postCreateRequestDto.setIdUser(1);
        postCreateRequestDto.setDate(LocalDate.now());
        postCreateRequestDto.setCategory(1);
        postCreateRequestDto.setPrice(100.0);

        ProductDto productDto = new ProductDto();
        productDto.setId(1);
        productDto.setName("Test Product");
        productDto.setType("Type");
        productDto.setBrand("Brand");
        productDto.setColor("Color");
        productDto.setNotes("Notes");

        postCreateRequestDto.setProduct(productDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postCreateRequestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", is("Post creado exitosamente.")));
    }
}
