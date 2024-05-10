package org.mercadolibre.NotNullTeam.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mercadolibre.NotNullTeam.DTO.response.buyer.BuyerResponseDTO;
import org.mercadolibre.NotNullTeam.DTO.response.buyer.BuyerResponseWithNotSellerListDTO;
import org.mercadolibre.NotNullTeam.mapper.BuyerMapper;
import org.mercadolibre.NotNullTeam.mapper.SellerMapper;
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
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BuyerControllerIntegrationTest {
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
    @DisplayName("Se solicita listar todos los usuarios compradores " +
            "y se retorna una lista con todos los que estan registrados.")
    public void getAllSuccessfully() throws Exception {

        // Se arma la lista de BuyerResponseDTO que se espera recibir usando los compradores iniciales
        List<BuyerResponseWithNotSellerListDTO> expectedBuyersResponseDTOList =
                BuyerMapper.toListBuyerResponseWithNotSellerListDTO(initialBuyers);

        // Se le pega al endpoint y se chequea codigo de estado, tipo de contenido y guardamos el MvcResult
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/all"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        // Mapeamos la respuesta tipo String a lista de BuyerResponseDTO
        List<BuyerResponseWithNotSellerListDTO> actualBuyersResponseDTOList = objectMapper.readValue(
                mvcResult.getResponse().getContentAsString(),
                new TypeReference<List<BuyerResponseWithNotSellerListDTO>>(){}
        );

        // Hacemos un assert entre las dos listas: lista esperada y losta resultado
        assertEquals(expectedBuyersResponseDTOList, actualBuyersResponseDTOList);
    }

    @Test
    @DisplayName("Se solicita la lista de seguidos por el usuario Buyer One " +
            "sin determinar orden (toma por defecto nombre ascendente) " +
            "y se devuelve una lista con 2 vendedores (Seller One y Seller Two) " +
            "ordenada alfabeticamente.")
    public void getFollowedListOrderedAscByDefault() throws Exception {
        List<Seller> orderedSellersList = this.initialSellers
                .stream()
                .sorted(Comparator.comparing(Seller::getUsername))
                .collect(Collectors.toList());

        BuyerResponseDTO expectedBuyerResponseDTO =
                BuyerResponseDTO.builder()
                        .user_id(1L)
                        .user_name("Buyer One")
                        .sellers(SellerMapper.toListSellerResponseWithNotBuyerListDTO(orderedSellersList))
                        .build();

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        BuyerResponseDTO actualBuyerResponseDTO = objectMapper.readValue(
                mvcResult.getResponse().getContentAsString(),
                new TypeReference<BuyerResponseDTO>(){}
        );

        assertEquals(expectedBuyerResponseDTO, actualBuyerResponseDTO);
    }

    @Test
    @DisplayName("Se solicita la lista de seguidos por el usuario Buyer One " +
            "con orden descendente (order = name_desc) " +
            "y se devuelve una lista con 2 vendedores (Seller One y Seller Two) " +
            "ordenada por nombre de forma descendente.")
    public void getFollowedListOrderedDescByParam() throws Exception {
        List<Seller> orderedSellersList = this.initialSellers
                .stream()
                .sorted(Comparator.comparing(Seller::getUsername).reversed())
                .collect(Collectors.toList());

        BuyerResponseDTO expectedBuyerResponseDTO =
                BuyerResponseDTO.builder()
                        .user_id(1L)
                        .user_name("Buyer One")
                        .sellers(SellerMapper.toListSellerResponseWithNotBuyerListDTO(orderedSellersList))
                        .build();

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/users/{userId}/followed/list", 1L)
                        .param("order", "name_desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        BuyerResponseDTO actualBuyerResponseDTO = objectMapper.readValue(
                mvcResult.getResponse().getContentAsString(),
                new TypeReference<BuyerResponseDTO>(){}
        );

        assertEquals(expectedBuyerResponseDTO, actualBuyerResponseDTO);
    }

    // @Test
    // @DisplayName("Buyer Two sigue a Seller Two correctamente")
    public void followSellerSuccessfully() throws Exception {

    }
}
