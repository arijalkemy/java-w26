package org.mercadolibre.NotNullTeam.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mercadolibre.NotNullTeam.DTO.response.buyer.BuyerResponseWithNotSellerListDTO;
import org.mercadolibre.NotNullTeam.mapper.BuyerMapper;
import org.mercadolibre.NotNullTeam.model.Buyer;
import org.mercadolibre.NotNullTeam.model.User;
import org.mercadolibre.NotNullTeam.repository.IBuyerRepository;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BuyerControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    IBuyerRepository buyerRepository;
    ObjectMapper objectMapper = new ObjectMapper();
    List<Buyer> initialBuyers;

    @BeforeEach
    public void setup() {
        objectMapper.findAndRegisterModules();
        ObjectWriter objectWriter = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer();

        initialBuyers = new ArrayList<>();
        initialBuyers.add(
                Buyer.builder()
                        .user(User.builder().id(1L).name("Random Buyer One").build())
                        .followedList(new ArrayList<>())
                        .build()
        );
        initialBuyers.add(
                Buyer.builder()
                        .user(User.builder().id(1L).name("Random Buyer Two").build())
                        .followedList(new ArrayList<>())
                        .build()
        );
        buyerRepository.setBuyers(initialBuyers);
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
        List<BuyerResponseWithNotSellerListDTO> resultBuyersResponseDTOList = objectMapper.readValue(
                mvcResult.getResponse().getContentAsString(),
                new TypeReference<List<BuyerResponseWithNotSellerListDTO>>(){}
        );

        // Hacemos un assert entre las dos listas: lista esperada y losta resultado
        assertEquals(expectedBuyersResponseDTOList, resultBuyersResponseDTOList);
    }
}
