package org.example.be_java_hisp_w26_g07.ControllerIntegration;

import org.example.be_java_hisp_w26_g07.entity.User;
import org.example.be_java_hisp_w26_g07.utils.GeneratorDataTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControlerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test de Integración 001 - Obtener un listado de todos los vendedores seguidos de " +
            "un posible usuario no registrado")
    void listFollowedBadPath() throws Exception {
        Integer userId = Integer.MAX_VALUE;
        String order = "date_desc";

        //Realizar la petición get al end point /users/{userId}/followed/list
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId)
                                .param("order", order)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Test de Integración 001  - Obtener un listado de todos los vendedores seguidos de " +
            "un determinado usuario con orden nullo")
    void listFollowedBadPathOrder() throws Exception {
        Integer userId = 1;
        String order = null;
        User myUser = GeneratorDataTest.findUsers().get(0);

        //Realizar la petición get al end point /users/{userId}/followed/list
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId)
                                .param("order", order)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(userId)) // Verifica user_id
                .andExpect(jsonPath("$.user_name").value(myUser.getName())) // Verifica user_name
                .andExpect(jsonPath("$.followed").isArray());
    }

    @Test
    @DisplayName("Test de Integración 001 - Obtener un listado vacío de un seguidos de " +
            "un determinado registrado y con orden name_desc")
    void listFollowedBadPathOrder2() throws Exception {
        Integer userId = 9;
        String order = "name_desc";
        User myUser = GeneratorDataTest.findUsers().get(8);

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId)
                                .param("order", order)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(userId)) // Verifica user_id
                .andExpect(jsonPath("$.user_name").value(myUser.getName())) // Verifica user_name
                .andExpect(jsonPath("$.followed").isArray());
    }

}
