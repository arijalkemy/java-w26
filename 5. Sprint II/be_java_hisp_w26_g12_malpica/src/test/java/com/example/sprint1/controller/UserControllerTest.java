package com.example.sprint1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {


    @Autowired
    MockMvc mockMvc;


    private static ObjectMapper objectMapper;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setup() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter writer = objectMapper.writer();
    }

    /**
     * Test al controlador de usuarios para seguir a un usuario
     */
    @Test
    @DisplayName("Test al controlador de usuarios para seguir a un usuario")
    public void seguirUsuarioTest() throws Exception {
        mockMvc.perform(post("/users/{userID}/follow/{userIdToFollow}",1,2))
                .andExpect(status().isCreated());
    }

    /**
     * Test al controlador de usuarios para seguir a un usuario
     * Cuando el usuario a seguir es el mismo
     */
    @Test
    @DisplayName("Test al controlador de usuarios para seguir a un usuario")
    public void seguirMismoUsuarioTest() throws Exception {
        mockMvc.perform(post("/users/{userID}/follow/{userIdToFollow}",1,1))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Can't follow yourself"));
    }

    /**
     * Test al controlador de usuarios para seguir a un usuario
     * Cuando el usuario a seguir no existe
     */
    @Test
    @DisplayName("Test al controlador de usuarios para seguir a un usuario que no existe")
    public void seguirUsuarioNoExistenteTest() throws Exception {
        mockMvc.perform(post("/users/{userID}/follow/{userIdToFollow}",1,1000))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("User to follow not found"));
    }

    /**
     * Test al controlador de usuarios para obtener el numero de seguidores de un vendedor
     */
    @Test
    @DisplayName("Test al controlador de usuarios para obtener el numero de seguidores de un vendedor")
    public void obtenerNumeroSeguidoresTest() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/count",3))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers_count").value(2));
    }


}
