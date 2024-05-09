package org.mercadolibre.NotNullTeam.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.*;
import org.mercadolibre.NotNullTeam.DTO.response.buyer.BuyerResponseWithNotSellerListDTO;
import org.mercadolibre.NotNullTeam.DTO.response.seller.SellerFollowersCountDto;
import org.mercadolibre.NotNullTeam.DTO.response.seller.SellerResponseDTO;
import org.mercadolibre.NotNullTeam.model.Buyer;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.model.User;
import org.mercadolibre.NotNullTeam.repository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
class SellerControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ISellerRepository sellerRepository;

    static ObjectWriter objectWriter;

    static ObjectMapper objectMapper;

    @BeforeAll
    static void setup() {
        objectMapper = new ObjectMapper();
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
        sellerRepository.setSellers(new ArrayList<>());
    }

    @Test
    @DisplayName("Obtener la cantidad de seguidores de un seller x debe ser 0")
    void getFollowersCountTest() throws Exception {
        // arrange
        User user = User
                .builder()
                .id(1L)
                .name("Juan")
                .build();

        Seller seller = Seller
                .builder()
                .user(user)
                .followersList(new ArrayList<>())
                .build();

        sellerRepository.save(seller);

        SellerFollowersCountDto responseExcepted = new SellerFollowersCountDto(
                1L,
                user.getName(),
                0
        );

        // act
        MvcResult result = mockMvc
                .perform(get("/users/1/followers/count"))
                .andReturn();

        SellerFollowersCountDto response = objectMapper.readValue(
                result
                        .getResponse()
                        .getContentAsString(),
                SellerFollowersCountDto.class
        );

        // assert
        Assertions.assertEquals(
                HttpStatus.OK.value(),
                result
                        .getResponse()
                        .getStatus()
        );
        Assertions.assertEquals(
                responseExcepted,
                response
        );
    }

    @Test
    @DisplayName("Obtener la cantidad de seguidores de un seller x debe ser 3")
    void getFollowersCountTest2() throws Exception {
        // arrange
        Seller seller = getAndSaveSellerWithThreeFollowers();

        sellerRepository.save(seller);

        SellerFollowersCountDto responseExcepted = new SellerFollowersCountDto(
                1L,
                seller.getUsername(),
                3
        );

        // act
        MvcResult result = mockMvc
                .perform(get("/users/1/followers/count"))
                .andReturn();

        SellerFollowersCountDto response = objectMapper.readValue(
                result
                        .getResponse()
                        .getContentAsString(),
                SellerFollowersCountDto.class
        );

        // assert
        Assertions.assertEquals(
                HttpStatus.OK.value(),
                result
                        .getResponse()
                        .getStatus()
        );
        Assertions.assertEquals(
                responseExcepted,
                response
        );
    }

    @Test
    @DisplayName("Obtener la cantidad de seguidores de un seller desconocido debe devolver not found")
    void getFollowersCountTest3() throws Exception {
        Long unknownSellerId = 999L;

        // act
        MvcResult result = mockMvc
                .perform(get("/users/" + unknownSellerId + "/followers/count"))
                .andReturn();

        // assert
        Assertions.assertEquals(
                HttpStatus.NOT_FOUND.value(),
                result
                        .getResponse()
                        .getStatus()
        );
    }

    @Test
    @DisplayName("Obtener la lista de seguidores de un seller x que no tiene seguidores")
    void getListFollowersTest() throws Exception {
        // arrange
        User user = User
                .builder()
                .id(1L)
                .name("Juan")
                .build();

        Seller seller = Seller
                .builder()
                .user(user)
                .followersList(new ArrayList<>())
                .build();

        sellerRepository.save(seller);

        SellerResponseDTO sellerResponseExpectedDTO = new SellerResponseDTO(
                1L,
                user.getName(),
                new ArrayList<>()
        );

        // act
        MvcResult result = mockMvc
                .perform(get("/users/1/followers/list"))
                .andReturn();

        SellerResponseDTO sellerResponseDTO = objectMapper.readValue(
                result
                        .getResponse()
                        .getContentAsString(),
                SellerResponseDTO.class
        );

        // assert
        Assertions.assertEquals(
                HttpStatus.OK.value(),
                result
                        .getResponse()
                        .getStatus()
        );
        Assertions.assertEquals(
                sellerResponseExpectedDTO,
                sellerResponseDTO
        );
    }

    @Test
    @DisplayName("Obtener la lista de seguidores de un seller x que tiene 3 seguidores")
    void getListFollowersTest2() throws Exception {
        // arrange
        Seller seller = getAndSaveSellerWithThreeFollowers();

        // expected list with followers sorted by id and name
        List<BuyerResponseWithNotSellerListDTO> expectedFollowers = seller
                .getFollowersList()
                .stream()
                .map(s -> new BuyerResponseWithNotSellerListDTO(
                        s.getUser().getId(),
                        s.getUsername()
                ))
                .sorted(Comparator
                        .comparing(BuyerResponseWithNotSellerListDTO::getId)
                        .thenComparing(BuyerResponseWithNotSellerListDTO::getName))
                .collect(Collectors.toList());

        SellerResponseDTO sellerResponseExpectedDTO = new SellerResponseDTO(
                1L,
                seller.getUsername(),
                expectedFollowers
        );

        // act
        MvcResult result = mockMvc
                .perform(get("/users/1/followers/list"))
                .andReturn();

        SellerResponseDTO sellerResponseDTO = objectMapper.readValue(
                result
                        .getResponse()
                        .getContentAsString(),
                SellerResponseDTO.class
        );

        // sort the actual list before comparing
        sellerResponseDTO.getFollowers().sort(Comparator.comparing(BuyerResponseWithNotSellerListDTO::getId)
                .thenComparing(BuyerResponseWithNotSellerListDTO::getName));

        // assert
        Assertions.assertEquals(
                HttpStatus.OK.value(),
                result
                        .getResponse()
                        .getStatus()
        );
        Assertions.assertEquals(
                sellerResponseExpectedDTO,
                sellerResponseDTO
        );
    }

    @Test
    @DisplayName("Obtener la lista de seguidores de un seller x que tiene 3 seguidores ordenado ascendentemente")
    void getListFollowersAscTest() throws Exception {
        // arrange
        Seller seller = getAndSaveSellerWithThreeFollowers();

        // expected list with followers sorted by name
        List<BuyerResponseWithNotSellerListDTO> expectedFollowers = seller
                .getFollowersList()
                .stream()
                .map(s -> new BuyerResponseWithNotSellerListDTO(
                        s.getUser().getId(),
                        s.getUsername()
                ))
                .sorted(Comparator
                        .comparing(BuyerResponseWithNotSellerListDTO::getName)
                        )
                .collect(Collectors.toList());

        SellerResponseDTO sellerResponseExpectedDTO = new SellerResponseDTO(
                1L,
                seller.getUsername(),
                expectedFollowers
        );

        // act
        MvcResult result = mockMvc
                .perform(get("/users/1/followers/list?order=name_asc"))
                .andReturn();

        SellerResponseDTO sellerResponseDTO = objectMapper.readValue(
                result
                        .getResponse()
                        .getContentAsString(),
                SellerResponseDTO.class
        );

        // assert
        Assertions.assertEquals(
                HttpStatus.OK.value(),
                result
                        .getResponse()
                        .getStatus()
        );
        Assertions.assertEquals(
                sellerResponseExpectedDTO,
                sellerResponseDTO
        );
    }

    @Test
    @DisplayName("Obtener la lista de seguidores de un seller x que tiene 3 seguidores ordenado descendentemente")
    void getListFollowersDescTest() throws Exception {
        // arrange
        Seller seller = getAndSaveSellerWithThreeFollowers();

        // expected list with followers sorted by name
        List<BuyerResponseWithNotSellerListDTO> expectedFollowers = seller
                .getFollowersList()
                .stream()
                .map(s -> new BuyerResponseWithNotSellerListDTO(
                        s.getUser().getId(),
                        s.getUsername()
                ))
                .sorted(Comparator
                        .comparing(BuyerResponseWithNotSellerListDTO::getName)
                        .reversed()
                )
                .collect(Collectors.toList());

        SellerResponseDTO sellerResponseExpectedDTO = new SellerResponseDTO(
                1L,
                seller.getUsername(),
                expectedFollowers
        );

        // act
        MvcResult result = mockMvc
                .perform(get("/users/1/followers/list?order=name_desc"))
                .andReturn();

        SellerResponseDTO sellerResponseDTO = objectMapper.readValue(
                result
                        .getResponse()
                        .getContentAsString(),
                SellerResponseDTO.class
        );

        // assert
        Assertions.assertEquals(
                HttpStatus.OK.value(),
                result
                        .getResponse()
                        .getStatus()
        );
        Assertions.assertEquals(
                sellerResponseExpectedDTO,
                sellerResponseDTO
        );
    }

    @Test
    @DisplayName("Obtener la lista de seguidores de un seller x que tiene 3 seguidores con un order invalido")
    void getListFollowersInvalidOrderTest() throws Exception {
        // arrange
        getAndSaveSellerWithThreeFollowers();

        // act
        MvcResult result = mockMvc
                .perform(get("/users/1/followers/list?order=invalid"))
                .andReturn();

        // assert
        Assertions.assertEquals(
                HttpStatus.BAD_REQUEST.value(),
                result
                        .getResponse()
                        .getStatus()
        );
    }


    @Test
    @DisplayName("Obtener la lista de seguidores de un seller desconocido debe devolver not found")
    void getListFollowersTest3() throws Exception {
        Long unknownSellerId = 999L;

        // act
        MvcResult result = mockMvc
                .perform(get("/users/" + unknownSellerId + "/followers/list"))
                .andReturn();

        // assert
        Assertions.assertEquals(
                HttpStatus.NOT_FOUND.value(),
                result
                        .getResponse()
                        .getStatus()
        );
    }

    private Seller getAndSaveSellerWithThreeFollowers() {
        User user = User
                .builder()
                .id(1L)
                .name("Juan")
                .build();
        User user2 = User
                .builder()
                .id(2L)
                .name("Pedro")
                .build();
        User user3 = User
                .builder()
                .id(3L)
                .name("Maria")
                .build();
        User user4 = User
                .builder()
                .id(4L)
                .name("Jose")
                .build();

        Seller seller = Seller
                .builder()
                .user(user)
                .followersList(new ArrayList<>())
                .build();

        seller.addNewFollower(Buyer
                .builder()
                .user(user2)
                .followedList(List.of())
                .build());
        seller.addNewFollower(Buyer
                .builder()
                .user(user3)
                .followedList(List.of())
                .build());
        seller.addNewFollower(Buyer
                .builder()
                .user(user4)
                .followedList(List.of())
                .build());

        sellerRepository.save(seller);

        return seller;
    }

}
