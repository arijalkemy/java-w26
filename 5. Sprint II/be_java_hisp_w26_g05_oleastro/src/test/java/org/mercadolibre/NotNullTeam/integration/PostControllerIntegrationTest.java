package org.mercadolibre.NotNullTeam.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mercadolibre.NotNullTeam.DTO.request.post.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.product.ProductDTO;
import org.mercadolibre.NotNullTeam.model.Buyer;
import org.mercadolibre.NotNullTeam.model.Product;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.model.User;
import org.mercadolibre.NotNullTeam.repository.IBuyerRepository;
import org.mercadolibre.NotNullTeam.repository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    IBuyerRepository buyerRepository;
    @Autowired
    ISellerRepository sellerRepository;
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter;
    List<Buyer> initialBuyers;
    List<Seller> initialSellers;
    PostDTO correctArgumentsPostDTO;
    PostDTO incorrectArgumentsPostDTO;

    @BeforeEach
    public void setup() {
        objectMapper.findAndRegisterModules();
        objectWriter = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer();

        Buyer buyerOne = Buyer.builder()
                .user(User.builder().id(1L).name("Buyer One").build())
                .followedList(new ArrayList<>())
                .build();

        Buyer buyerTwo = Buyer.builder()
                .user(User.builder().id(2L).name("Buyer Two").build())
                .followedList(new ArrayList<>())
                .build();

        Seller sellerOne = Seller.builder()
                .user(User.builder().id(101L).name("Seller One").build())
                .followersList(new ArrayList<>())
                .build();

        Seller sellerTwo = Seller.builder()
                .user(User.builder().id(102L).name("Seller Two").build())
                .followersList(new ArrayList<>())
                .build();

        correctArgumentsPostDTO = PostDTO.builder()
                .userId(101L)
                .date("08-05-2024")
                .product(
                        ProductDTO.builder()
                                .productId(1L)
                                .productName("Silla Gamer")
                                .type("Gamer")
                                .brand("Racer")
                                .color("Red and Black")
                                .notes("Special Edition")
                                .build())
                .category(100)
                .price(1500.50)
                .build();

        incorrectArgumentsPostDTO = PostDTO.builder()
                .userId(101L)
                .date("08-05-2024")
                .product(
                        ProductDTO.builder()
                                .productId(1L)
                                .productName("Silla Gamer")
                                .type("Gamer")
                                .brand("Racer")
                                .color("Red & Black")
                                .notes("Special Edition")
                                .build())
                .category(100)
                .price(1500.50)
                .build();

        buyerOne.addNewFollowed(sellerOne);
        sellerOne.addNewFollower(buyerOne);
        buyerOne.addNewFollowed(sellerTwo);
        sellerTwo.addNewFollower(buyerOne);

        initialBuyers = new ArrayList<>();
        initialBuyers.add(buyerOne);
        initialBuyers.add(buyerTwo);

        initialSellers = new ArrayList<>();
        initialSellers.add(sellerOne);
        initialSellers.add(sellerTwo);

        buyerRepository.setBuyers(initialBuyers);
        sellerRepository.setSellers(initialSellers);
    }

    @Test
    @DisplayName("El usuario Seller One (ID = 101) crea una publicacion de una silla gamer " +
            "correctamente y recibe un mensaje de confirmacion.")
    public void createPostSuccessfully() throws Exception {

        String payloadJson = objectWriter.writeValueAsString(correctArgumentsPostDTO);

        String localDateNowAsString = LocalDate.now().toString();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson)
                )
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value("Post created successfully"))
                .andExpect(jsonPath("$.date").value(localDateNowAsString));
    }

    @Test
    @DisplayName("El usuario Seller One (ID = 101) quiere crear una publicacion de una silla gamer " +
            "que contiene caracteres especiales en las notas del producto " +
            "y recibe un mensaje describiendo ese error.")
    public void createPostThrowsMethodArgumentNotValid() throws Exception {

        String payloadJson = objectWriter.writeValueAsString(incorrectArgumentsPostDTO);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson)
                )
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(
                        jsonPath("$['product.color']")
                                .value("El campo no puede poseer caracteres especiales.")
                );
    }
}
