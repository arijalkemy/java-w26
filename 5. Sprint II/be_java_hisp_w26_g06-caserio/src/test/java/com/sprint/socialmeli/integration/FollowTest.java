package com.sprint.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sprint.socialmeli.dto.user.FollowerCountResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FollowTest {

    @Autowired
    private MockMvc mockMvc;

    FollowerCountResponseDTO followerCount;
    private static ObjectWriter writer;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    /**
     * Se testea integralmente la funcionalidad de follow, casos:
     *  - Follow con sellerId inválido (debe arrojar not found)
     *  - Follow con customerId inválido (debe arrojar not found)
     *  - Follow entre customerId2 y sellerId1
     *  - Follow de nuevo entre ya seguidos (debe arrojar conflicto)
     *  - Unfollow entre customerId2 y sellerId1
     *  - Follow nuevamente entre customerId2 y sellerId1 (ahora si debe funcionar por el unfollow realizado)
     *  - Obtener cantidad de seguidores de sellerId 1 en cada caso
     * @throws Exception
     */
    @Test
    public void testFollow() throws Exception {

        // El customerId 2 quiere seguir al sellerId 100
        // Debe lanzar not found
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/2/follow/100"));
        result.andExpect(status().isNotFound());
        checkFollowerCount(0);

        // El customerId 200 quiere seguir al sellerId 1
        // Debe lanzar not found
        result = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/200/follow/1"));
        result.andExpect(status().isNotFound());
        checkFollowerCount(0);
        
        //El customerId 2 sigue al sellerId 1
        simpleFollowTest();
        checkFollowerCount(1);

        // El customerId 2 quiere seguir nuevamente al sellerId 1
        // Debe lanzar conflicto
        result = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/2/follow/1"));
        result.andExpect(status().isConflict());
        checkFollowerCount(1);

        //El customerId 2 deja de seguir al sellerId 1
        simpleUnfollowTest();
        checkFollowerCount(0);

        //El customerId 2 sigue al sellerId 1
        simpleFollowTest();
        checkFollowerCount(1);
    }

    private void simpleFollowTest() throws Exception {
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/2/follow/1"));

        result.andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("OK"));
    }

    private void simpleUnfollowTest() throws Exception {
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/2/unfollow/1"));

        result.andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("OK"));
    }

    private void checkFollowerCount( int count) throws Exception {
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/1/followers/count"));
        result.andExpect(status().isOk());
        FollowerCountResponseDTO followerCount = new FollowerCountResponseDTO(1, "Martin",count);
        String respuestaEsperadaString = writer.writeValueAsString(followerCount);

        Assertions.assertEquals(respuestaEsperadaString, result.andReturn().getResponse().getContentAsString());
    }
}
