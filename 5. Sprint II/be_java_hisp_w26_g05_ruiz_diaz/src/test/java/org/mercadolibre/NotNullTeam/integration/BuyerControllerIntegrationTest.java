package org.mercadolibre.NotNullTeam.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.*;
import org.mercadolibre.NotNullTeam.DTO.response.buyer.BuyerResponseWithNotSellerListDTO;
import org.mercadolibre.NotNullTeam.mapper.BuyerMapper;
import org.mercadolibre.NotNullTeam.model.Buyer;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.model.User;
import org.mercadolibre.NotNullTeam.repository.IBuyerRepository;
import org.mercadolibre.NotNullTeam.repository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class BuyerControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    IBuyerRepository iBuyerRepository;

    @Autowired
    ISellerRepository iSellerRepository;

    static ObjectMapper objectMapper;
    static ObjectWriter objectWriter;

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
        iBuyerRepository.setBuyers(new ArrayList<>());
        iSellerRepository.setSellers(new ArrayList<>());
    }

    @Test
    @DisplayName("Obtener todos los buyers")
    void getAllBuyersTest() throws Exception {
        // arrange
        List<Buyer> buyers = get2Buyers();
        for(Buyer buyer : buyers){
            iBuyerRepository.save(buyer);

        }

        List<BuyerResponseWithNotSellerListDTO> expectedResponse =
                BuyerMapper.toListBuyerResponseWithNotSellerListDTO(buyers);

        // act
        MvcResult result = mockMvc
                .perform(get("/users/all"))
                .andReturn();

        List<BuyerResponseWithNotSellerListDTO> response = objectMapper.readValue(
                result.getResponse().getContentAsString(),
                objectMapper
                        .getTypeFactory()
                        .constructCollectionType(List.class, BuyerResponseWithNotSellerListDTO.class)
        );

        // assert
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        Assertions.assertEquals(expectedResponse, response);
    }


    @Test
    @DisplayName("un buyer x sigue a un seller y")
    void followSellerTest() throws Exception {
        // arrange
        Seller seller = getSeller();
        Buyer buyer = getBuyer();

        iBuyerRepository.save(buyer);
        iSellerRepository.save(seller);

        // act
        MvcResult result = mockMvc
                .perform(post("/users/1/follow/2"))
                .andReturn();

        // assert
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        //
        // los objetos estan en memoria por lo tanto los puedo verificar con los mismos objetos
        // para este proyecto en particular que se guardan los objetos en memoria
        //
        Assertions.assertTrue(buyer.getFollowedList().contains(seller));
        Assertions.assertTrue(seller.getFollowersList().contains(buyer));
    }

    @Test
    @DisplayName("un buyer x que ya sigue a un seller y, intenta seguirlo nuevamente, se espera un error conflict")
    void followSellerAlreadyFollowedTest() throws Exception {
        // arrange
        Seller seller = getSeller();
        Buyer buyer = getBuyer();

        buyer.getFollowedList().add(seller);
        seller.getFollowersList().add(buyer);

        iBuyerRepository.save(buyer);
        iSellerRepository.save(seller);

        // act
        MvcResult result = mockMvc
                .perform(post("/users/1/follow/2"))
                .andReturn();

        // assert
        Assertions.assertEquals(HttpStatus.CONFLICT.value(), result.getResponse().getStatus());
    }

    @Test
    @DisplayName("un buyer x intenta seguir a un seller y, que no existe, se espera un error not found")
    void followSellerNotFoundTest() throws Exception {
        // arrange
        Buyer buyer = getBuyer();

        iBuyerRepository.save(buyer);

        // act
        MvcResult result = mockMvc
                .perform(post("/users/1/follow/2"))
                .andReturn();

        // assert
        Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());
    }

    @Test
    @DisplayName("un buyer x que no existe, intenta seguir a un seller y, se espera un error not found")
    void followSellerBuyerNotFoundTest() throws Exception {
        // act
        MvcResult result = mockMvc
                .perform(post("/users/1/follow/2"))
                .andReturn();

        // assert
        Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());
    }

    @Test
    @DisplayName("un buyer x deja de seguir a un seller y")
    void unfollowSellerTest() throws Exception {
        // arrange
        Seller seller = getSeller();
        Buyer buyer = getBuyer();

        buyer.getFollowedList().add(seller);
        seller.getFollowersList().add(buyer);

        iBuyerRepository.save(buyer);
        iSellerRepository.save(seller);

        // act
        MvcResult result = mockMvc
                .perform(post("/users/1/unfollow/2"))
                .andReturn();

        // assert
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        //
        // los objetos estan en memoria por lo tanto los puedo verificar con los mismos objetos
        // para este proyecto en particular que se guardan los objetos en memoria
        //
        Assertions.assertFalse(buyer.getFollowedList().contains(seller));
        Assertions.assertFalse(seller.getFollowersList().contains(buyer));
    }

    private Seller getSeller(){
        User user2 = User
                .builder()
                .id(2L)
                .name("user2")
                .build();

        Seller seller = Seller
                .builder()
                .user(user2)
                .followersList(new ArrayList<>())
                .build();

        return seller;
    }

    private Buyer getBuyer(){
        User user1 = User
                .builder()
                .id(1L)
                .name("user")
                .build();


        Buyer buyer = Buyer
                .builder()
                .user(user1)
                .followedList(new ArrayList<>())
                .build();

        return buyer;
    }

    private List<Buyer> get2Buyers(){
        List<Buyer> buyers = new ArrayList<>();

        User user1 = User
                .builder()
                .id(1L)
                .name("user")
                .build();

        User user2 = User
                .builder()
                .id(2L)
                .name("user2")
                .build();

        Buyer buyer1 = Buyer
                .builder()
                .user(user1)
                .followedList(new ArrayList<>())
                .build();

        Buyer buyer2 = Buyer
                .builder()
                .user(user2)
                .followedList(new ArrayList<>())
                .build();

        buyers.add(buyer1);
        buyers.add(buyer2);

        return buyers;
    }
}
