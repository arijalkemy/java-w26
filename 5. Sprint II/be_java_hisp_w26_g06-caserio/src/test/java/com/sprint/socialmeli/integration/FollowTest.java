package com.sprint.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sprint.socialmeli.exception.ConflictException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FollowTest {

    @Autowired
    private MockMvc mockMvc;

    private static ObjectWriter writer;

    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        objectMapper = new ObjectMapper();
    }

    /**
     * Se testea integralmente la funcionalidad de follow, casos:
     *  - Follow entre customerId2 y sellerId1
     *  - Follow de nuevo entre ya seguidos (debe arrojar conflicto)
     *  - Unfollow entre customerId2 y sellerId1
     *  - Follow nuevamente entre customerId2 y sellerId1 (ahora si debe funcionar por el unfollow realizado)
     * @throws Exception
     */
    @Test
    public void testFollow() throws Exception {
        //El Customer con id 2 sigue al Seller con id 1
        simpleFollowTest();

        // El customer con id 2 quiere seguir nuevamente al seller con id 1
        // Debe lanzar conflicto
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/2/follow/1"));

        result.andExpect(status().isConflict());

        //El Customer con id 2 deja de seguir al Seller con id 1
        simpleUnfollowTest();

        //El Customer con id 2 sigue al Seller con id 1
        simpleFollowTest();
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
}
