package org.mercadolibre.NotNullTeam.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BuyerControllerTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    private static final String URL_BASE = "/users";

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    @DisplayName("Se obtienen todos los Buyers")
    void getAllBuyers() throws Exception {
        mockMvc
                .perform(get(URL_BASE + "/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

    }

    @Test
    @DisplayName("UNFOLLOW - El Buyer 'Juan Peres' con id 1L deja de seguir al seller 'Carlos Tevez' con id 3L")
    void unfollowSellerOk() throws Exception {
        long userId = 1L;
        long userIdToUnfollow = 3L;
        String url = URL_BASE + "/" + userId + "/unfollow/" + userIdToUnfollow;
        mockMvc
                .perform(post(url))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @DisplayName("UNFOLLOW - El Buyer 'Juan Peres' con id 1L deja de seguir a un Seller que no existe con id 6L")
    void unfollowSellerNotFoundSellerNotExist() throws Exception {
        long userId = 1L;
        long userIdToUnfollow = 6L;
        String url = URL_BASE + "/" + userId + "/unfollow/" + userIdToUnfollow;
        mockMvc
                .perform(post(url))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Seller not found"))
                .andExpect(jsonPath("$.uri").value(url))
                .andReturn();
    }

    @Test
    @DisplayName("UNFOLLOW - El Buyer con id 10L que no existe deja de seguir a un Seller")
    void unfollowSellerNotfoundBuyerNotExist() throws Exception {
        long userId = 10L;
        long userIdToUnfollow = 6L;
        String url = URL_BASE + "/" + userId + "/unfollow/" + userIdToUnfollow;
        mockMvc
                .perform(post(url))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Buyer not found"))
                .andExpect(jsonPath("$.uri").value(url))
                .andReturn();
    }


    @Test
    @DisplayName("UNFOLLOW - El userId del path es un valor negativo")
    void unfollowSellerBadRequestIdUser() throws Exception {
        long userId = -1L;
        long userIdToUnfollow = 6L;
        String url = URL_BASE + "/" + userId + "/unfollow/" + userIdToUnfollow;
        mockMvc
                .perform(post(url))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.uri").value(url))
                .andReturn();
    }

    @Test
    @DisplayName("UNFOLLOW - El userIdToUnfollow del path es un valor negativo")
    void unfollowSellerBadRequestUserIdToUnfollow() throws Exception {
        long userId = 1L;
        long userIdToUnfollow = -6L;
        String url = URL_BASE + "/" + userId + "/unfollow/" + userIdToUnfollow;
        mockMvc
                .perform(post(url))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.uri").value(url))
                .andReturn();
    }

    @Test
    @DisplayName("FOLLOW - El Buyer 'Maria Lopez' con id 2L comienza de seguir al seller 'AgustinDias' con id 4L")
    void followSellerOk() throws Exception {
        long userId = 2L;
        long userIdToFollow = 4L;
        String url = URL_BASE + "/" + userId + "/follow/" + userIdToFollow;

        mockMvc
                .perform(post(url))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @DisplayName("FOLLOW - El Buyer 'Maria Lopez' con id 2L intenta seguir a un seller que ya sigue 'Carlos tevez' con id 3L")
    void followSellerUserAlreadyFollowedException() throws Exception {
        long userId = 2L;
        long userIdToFollow = 3L;
        String url = URL_BASE + "/" + userId + "/follow/" + userIdToFollow;

        mockMvc
                .perform(post(url))
                .andDo(print())
                .andExpect(status().isConflict())
                .andReturn();
    }

    @Test
    @DisplayName("FOLLOWED - Se recupera la lista de Sellers que sigue el Buyer 'Juan Peres' con id 1L ordenados por nombre de forma ascendente")
    void getFollowedListOrderedAsc() throws Exception {
        long userId = 1L;
        String order = "name_asc";
        String url = URL_BASE + "/" + userId + "/followed/list?order=" + order;
        mockMvc
                .perform(get(url))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @Test
    @DisplayName("FOLLOWED - Se recupera la lista de Sellers que sigue el Buyer 'Juan Peres' con " + "id 1L ordenados por nombre de forma descendente")
    void getFollowedListOrderedDesc() throws Exception {
        long userId = 1L;
        String order = "name_desc";
        String url = URL_BASE + "/" + userId + "/followed/list?order=" + order;
        mockMvc
                .perform(get(url))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }


    @Test
    @DisplayName("FOLLOWED - Se intenta aplicar un tipo de orden invalido")
    void getFollowedListOrderedInvalid() throws Exception {
        long userId = 1L;
        String order = "invalid";
        String url = URL_BASE + "/" + userId + "/followed/list?order=" + order;
        mockMvc
                .perform(get(url))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    @DisplayName("FOLLOWED - Se intenta recuperar la lista de seguidos de un Buyer con id negativo")
    void getFollowedListOrderedBadRequestUserId() throws Exception {
        long userId = -1L;
        String order = "invalid";
        String url = URL_BASE + "/" + userId + "/followed/list?order=" + order;
        mockMvc
                .perform(get(url))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }
}