package org.mercadolibre.NotNullTeam.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.*;
import org.mercadolibre.NotNullTeam.DTO.request.post.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.product.ProductDTO;
import org.mercadolibre.NotNullTeam.DTO.response.post.PostCreatedDto;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.model.User;
import org.mercadolibre.NotNullTeam.repository.IPostRepository;
import org.mercadolibre.NotNullTeam.repository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    IPostRepository iPostRepository;

    @Autowired
    ISellerRepository sellerRepository;

    static ObjectWriter objectWriter;

    static ObjectMapper objectMapper = new ObjectMapper();

    @BeforeAll
    static void setup() {
        objectMapper.findAndRegisterModules();

        objectWriter = new ObjectMapper()
                .configure(
                        SerializationFeature.WRAP_ROOT_VALUE,
                        false
                )
                .writer();
    }

    @BeforeEach
    void setupBeforeEach() {
        iPostRepository.setPosts(new HashMap<>());
        sellerRepository.setSellers(new ArrayList<>());
    }

    @Test
    @DisplayName("se crea un post de una casa de forma exitosa")
    void createPostSuccessfully() throws Exception {
        // Arrange
        Long sellerId = 1L;

        saveASeller(sellerId);
        PostDTO housePost = getAHousePost(sellerId);

        PostCreatedDto responseExcepted = new PostCreatedDto(
                1L,
                "Post created successfully",
                LocalDate.now()
        );

        // Act
        MvcResult mvcResult = mockMvc
                .perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(housePost)))
                .andReturn();

        PostCreatedDto response = objectMapper.readValue(
                mvcResult
                        .getResponse()
                        .getContentAsString(),
                PostCreatedDto.class
        );

        // Assert
        Assertions.assertEquals(
                responseExcepted,
                response
        );
        Assertions.assertEquals(
                HttpStatus.CREATED.value(),
                mvcResult
                        .getResponse()
                        .getStatus()
        );
    }

    @Test
    @DisplayName("se crea un post de una casa de un seller que no existe")
    void createPostWithSellerNotExists() throws Exception {
        // Arrange
        PostDTO housePost = getAHousePost(999L);

        // Act
        MvcResult mvcResult = mockMvc
                .perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(housePost)))
                .andReturn();

        // Assert
        Assertions.assertEquals(
                HttpStatus.NOT_FOUND.value(),
                mvcResult
                        .getResponse()
                        .getStatus()
        );
    }

    @Test
    @DisplayName("se crea un post de una casa con campos invalidos")
    void createPostWithInvalidFields() throws Exception {
        // Arrange
        PostDTO housePost = getHousePostWithBadFields();

        // Act
        MvcResult mvcResult = mockMvc
                .perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(housePost)))
                .andReturn();

        // Assert
        Assertions.assertEquals(
                HttpStatus.BAD_REQUEST.value(),
                mvcResult
                        .getResponse()
                        .getStatus()
        );
    }

    private void saveASeller(Long id) {
        User user = new User(
                id,
                "Juan"
        );
        Seller seller = new Seller(
                user,
                new ArrayList<>()
        );

        sellerRepository.save(seller);
    }

    private PostDTO getAHousePost(Long sellerId) {
        ProductDTO apartmentProductDTO = new ProductDTO(
                1L,
                "Apartment",
                "Real Estate",
                "No Brand",
                "No Color",
                "This is an apartment with a lot commodities"
        );

        return new PostDTO(
                sellerId,
                "08-05-2024",
                apartmentProductDTO,
                1,
                1000000.0
        );
    }

    private PostDTO getHousePostWithBadFields(){
        ProductDTO apartmentProductDTO = new ProductDTO(
                1L,
                null,
                "Real Estate",
                "No Brand&&",
                "",
                "This is an apa%%rtment with a lot commodities"
        );

        return new PostDTO(
                null,
                "invalid",
                apartmentProductDTO,
                -1,
                -1000000.0
        );
    }

}
