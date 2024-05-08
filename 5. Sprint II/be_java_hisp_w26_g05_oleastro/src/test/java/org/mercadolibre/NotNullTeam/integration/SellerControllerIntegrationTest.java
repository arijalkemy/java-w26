package org.mercadolibre.NotNullTeam.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mercadolibre.NotNullTeam.DTO.response.seller.SellerFollowersCountDto;
import org.mercadolibre.NotNullTeam.model.Buyer;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.model.User;
import org.mercadolibre.NotNullTeam.repository.IBuyerRepository;
import org.mercadolibre.NotNullTeam.repository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SellerControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    IBuyerRepository buyerRepository;
    @Autowired
    ISellerRepository sellerRepository;
    ObjectMapper objectMapper = new ObjectMapper();
    List<Buyer> initialBuyers;
    List<Seller> initialSellers;

    @BeforeEach
    public void setup() {
        objectMapper.findAndRegisterModules();
        ObjectWriter objectWriter = new ObjectMapper().
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
    @DisplayName("Se quiere listar los seguidores del usuario vendedor con ID = 9999 " +
            "y lanza una excepcion porque no existe ningun usuario con dicho ID.")
    public void getListFollowersThrowsNotFoundExeption() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 9999))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(
                        jsonPath("$.message")
                        .value("No se encontro el vendedor con ID = 9999 not found")
                );
    }

    @Test
    @DisplayName("Se solicita el conteo de seguidores del usuario vendedor" +
            "con ID = 101 que corresponde al usuario llamado Seller One " +
            "y se obtiene que tiene un seguidor")
    public void getFollowersCountSuccessfully() throws Exception {
        SellerFollowersCountDto expectedSellerFollowersCountDto =
                SellerFollowersCountDto.builder()
                        .user_id(101L)
                        .user_name("Seller One")
                        .followers_count(1)
                        .build();

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/users/{userId}/followers/count", 101)
                )
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        SellerFollowersCountDto actualSellerFollowersCountDto = objectMapper.readValue(
                mvcResult.getResponse().getContentAsString(),
                new TypeReference<SellerFollowersCountDto>(){}
        );

        assertEquals(expectedSellerFollowersCountDto, actualSellerFollowersCountDto);
    }
}
