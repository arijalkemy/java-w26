package org.example.g14.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.g14.dto.ProductDto;
import org.example.g14.dto.request.PostCreateRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Integracion: camino feliz de endpoint /products/post")
    public void createPostOk() throws Exception {

        PostCreateRequestDto requestDto = new PostCreateRequestDto(
            1,
            LocalDate.of(2024, 5, 10),
            new ProductDto(
                50,
                "Audio system S3000",
                "Electronics",
                "Aiwa",
                "Space gray",
                "You wont get dissapointed"
            ),
            105,
            4_500.0
        );

        ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

        mockMvc
            .perform(
                post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(requestDto))
            )
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.message").value("Post creado exitosamente."));
    }
}
