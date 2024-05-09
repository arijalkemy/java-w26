package org.example.SocialMeli2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.SocialMeli2.dto.ExceptionDTO;
import org.example.SocialMeli2.dto.PostDTO;
import org.example.SocialMeli2.dto.ResponsePostDTO;
import org.example.SocialMeli2.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SellerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    ResponsePostDTO responsePostDTOAsc;
    ResponsePostDTO responsePostDTODesc;

    ObjectMapper mapper = new ObjectMapper();

    /**
     * Configuración inicial antes de cada prueba.
     * Aquí se inicializan los objetos necesarios para las pruebas.
     */
    @BeforeEach
    public void setup() {
        int userId = 239;

        Product product = Product.builder()
                .productId(301)
                .productName("Monitor 4K")
                .type("Electronica")
                .brand("UltraView")
                .color("Black")
                .notes("High resolution, 32 inches")
                .build();

        Product product2 = Product.builder()
                .productId(302)
                .productName("Teclado Mecanico")
                .type("Accesorio")
                .brand("KeyMax")
                .color("Gray")
                .notes("Cherry MX switches, LED backlight")
                .build();

        List<PostDTO> postDTOS = new ArrayList<>();
        postDTOS.add(PostDTO.builder()
                .sellerId(101)
                .postId(201)
                .date(LocalDate.of(2024, 5, 1))
                .category(1)
                .price(400.00)
                .hasPromo(true)
                .discount(15.0)
                .product(product)
                .build()
        );

        postDTOS.add(PostDTO.builder()
                .sellerId(101)
                .postId(202)
                .date(LocalDate.of(2024, 4, 30))
                .category(1)
                .price(120.00)
                .hasPromo(false)
                .discount(0.0)
                .product(product2)
                .build()
        );

        List<PostDTO> reversedPostDTOS = new ArrayList<>(postDTOS);
        Collections.reverse(reversedPostDTOS);

        responsePostDTOAsc = new ResponsePostDTO(userId, postDTOS);
        responsePostDTODesc = new ResponsePostDTO(userId, reversedPostDTOS);

        mapper.registerModule(new JavaTimeModule());
    }

    @Test
    @DisplayName("Retorna una lista de post de los seguidores de un usuario publicado en las ultimas dos semanas")
    public void getPostsFromFollowingWithTwoWeeksOldTest() throws Exception {
        // Arrange
        String responsePostDTO = mapper.writeValueAsString(responsePostDTOAsc);

        // Act & Assert
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 239))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responsePostDTO, result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Lanza un error al no encontrar un usuario con el id dado")
    public void notFoundUserTest() throws Exception {
        // Arrange
        ExceptionDTO exceptionDTO = new ExceptionDTO("No existe un cliente con ese ID");
        String reponseExpected = mapper.writeValueAsString(exceptionDTO);

        // Act & Assert
        MvcResult responseObtained = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 120))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(reponseExpected, responseObtained.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("El id del usuario debe ser mayor o igual a 1")
    public void invalidUserIdTest() throws Exception {
        // Arrange
        String response = "getPostsFromFollowingWithTwoWeeksOld.userId: El id debe ser mayor a cero";

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 0))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(response));
    }
}
