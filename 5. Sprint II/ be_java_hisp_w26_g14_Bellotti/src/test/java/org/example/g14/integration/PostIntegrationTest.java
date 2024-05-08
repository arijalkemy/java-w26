package org.example.g14.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.g14.dto.ProductDto;
import org.example.g14.dto.request.PostCreateRequestDto;
import org.example.g14.dto.response.MessageResponseDto;
import org.example.g14.dto.response.PostResponseDto;
import org.example.g14.model.Post;
import org.example.g14.model.Product;
import org.example.g14.utils.PostList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class PostIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .findAndRegisterModules()
                .setDateFormat(new SimpleDateFormat("yyyy-MM-dd"))
                .writer();
    }

    @Test
    @DisplayName("Post creado con exito")
    public void createPostTest() throws Exception {
        //arrange
        MessageResponseDto messageExpected = new MessageResponseDto("Post creado exitosamente.");
        PostCreateRequestDto postCreateRequestDto = new PostCreateRequestDto(1,
                LocalDate.of(2024, 05, 05),
                new ProductDto(
                        1,
                        "xbox",
                        "videojuego",
                        "PS",
                        "blanco",
                        ""
                ),
                1,
                45.9);

        //act
        ResultActions results = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postCreateRequestDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value(messageExpected.getMessage()));

        String responseObtained = results.andReturn().getResponse().getContentAsString();
        String responseExpected = writer.writeValueAsString(messageExpected);

        //assert
        Assertions.assertEquals(responseExpected, responseObtained);
    }

    @Test
    @DisplayName("Id del usuario invalido al crear el post")
    public void createPostTestBadRequest() throws Exception {
        //arrange
        PostCreateRequestDto postCreateRequestDto = new PostCreateRequestDto(-1,
                LocalDate.of(2024, 05, 05),
                new ProductDto(
                        1,
                        "xbox",
                        "videojuego",
                        "PS",
                        "blanco",
                        ""
                ),
                1,
                45.9);

        //act
        ResultActions results = this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(writer.writeValueAsString(postCreateRequestDto)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.detail[0]").value("idUser: El id debe ser mayor a cero."));
    }


    @Test
    @DisplayName("Obtener post de los usuarios que seguis")
    public void getPostsFromFollowedOk() throws Exception{
        //arrange
        int id = 29;
        String order="date_desc";

        PostResponseDto postExpectedDto = new PostResponseDto(22,
                22,
                LocalDate.of(2024,5,8),
                new ProductDto(22,
                        "PlayStation 5",
                        "Gaming Console",
                        "Sony",
                        "White",
                        "4K, 120fps, 825GB SSD"),
                22,
                219.99
        );

        List<PostResponseDto> listExpected = List.of(postExpectedDto);

        //act
        ResultActions results = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/products/followed/{user_id}/list", id)
                                .param("order", order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

        String responseObtained = results.andReturn().getResponse().getContentAsString();
        String responseExpected = writer.writeValueAsString(listExpected);

        Assertions.assertEquals(responseExpected, responseObtained);
    }
}
