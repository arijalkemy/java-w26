package com.meli.be_java_hisp_w26_g10.controller;

import com.api.socialmeli.BeJavaHispW26G10Application;
import com.api.socialmeli.dto.PostDto;
import com.api.socialmeli.dto.PostsByFollowedDto;
import com.api.socialmeli.dto.ProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
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
import java.util.List;

import static org.hamcrest.Matchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = BeJavaHispW26G10Application.class)
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private LocalDate date;
    private LocalDate date1;

    private final ObjectWriter objectWriter = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer().withDefaultPrettyPrinter();

    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false);

    @BeforeEach
    public void setUp(){
        date = LocalDate.of(2024, 4, 27);
        date1 = LocalDate.of(2024, 4, 26);
    }


    @Test
    @DisplayName("Validacion de retorno de variable autogenerada")
    public void testIntegrationV1() throws Exception {

        PostDto postDto = new PostDto(6, 1, date,
                (new ProductDto(1, "Silla", "acer", "Ergonomic", "black", "Nada")),
                2, 34444.0);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .content(objectWriter.writeValueAsString(postDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.post_id")
                        .value(any(Integer.class)));
    }

    @Test
    public void testGetPostsByFollowed() throws Exception {

        PostsByFollowedDto posts = new PostsByFollowedDto(1,
                List.of(new PostDto(2, 20, date,
                                (new ProductDto(20, "Maleta Samsonite Lite-Shock", "Samsonite", "Accesorio", "Gris", "Ultra ligera y resistente")),
                                4, 899000.0),
                        new PostDto(1, 19, date1,
                                (new ProductDto(19, "Licuadora Oster Xpert Series", "Oster", "Electrodoméstico", "Negro", "Potente y silenciosa")),
                                3, 2499000.0)
                ));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/1/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(posts)));
    }
}

