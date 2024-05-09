package org.example.g14.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.g14.dto.ProductDto;
import org.example.g14.dto.request.PostCreateRequestDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
            .findAndRegisterModules()
            .writer();
    }

    @Test
    public void createPostSuccessfullyIntegrationTest() throws Exception {
        ProductDto productDto = ProductDto.builder()
            .id(1)
            .name("Teclado HyperX Alloy 65")
            .type("Gamer")
            .brand("HyperX")
            .color("Black")
            .notes("Red Keys")
            .build();

        PostCreateRequestDto postCreateRequestDto = PostCreateRequestDto.builder()
            .idUser(20)
            .date(LocalDate.of(2023, 10, 31))
            .product(productDto)
            .category(100)
            .price(100.0)
            .build();

        this.mockMvc
            .perform(
                post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(writer.writeValueAsString(postCreateRequestDto))
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$.message").value("Post creado exitosamente."));
    }

    @Test
    public void createPostValidationErrorIntegrationTest() throws Exception {
        ProductDto productDto = ProductDto.builder()
            .id(-1)
            .name("Teclado HyperX Alloy 65")
            .type("Too Long Type Name To Trigger Validation")
            .brand("HyperX")
            .color("Invalid Color &")
            .notes("Red Keys")
            .build();

        PostCreateRequestDto postCreateRequestDto = PostCreateRequestDto.builder()
            .idUser(20)
            .date(LocalDate.of(2023, 10, 31))
            .product(productDto)
            .category(null)
            .price(100.0)
            .build();

        this.mockMvc
            .perform(
                post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(writer.writeValueAsString(postCreateRequestDto))
            )
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value("Hubo algún error de validación en los datos pasados en en el cuerpo de la petición."));
    }
}