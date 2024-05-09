package org.example.sprint1.controller;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SellerControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Evaluar que se lanza la exception 400 si no mando ningun body")
    public void addPostTest() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect((ResultMatcher) jsonPath("$.message").exists())
                .andExpect((ResultMatcher) jsonPath("$.message").isString()
        );
    }

    @Test
    @DisplayName("Validar la respuesta de obtener un listado de todos los sellers junto con sus respectivos productos")
    public void getAllSellersTest() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$").isArray()
        );
    }

    @Test
    @DisplayName("Verificar que el codigo devuelto sea 404 al mandar un id que no corresponda a un usuario")
    public void getPostsFromFollowingWithTwoWeeksOldTestFail() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/products//followed/{userId}/list", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) status().isNotFound())
                .andExpect((ResultMatcher) jsonPath("$.message").exists())
                .andExpect((ResultMatcher) jsonPath("$.message").isString()
        );
    }

    @Test
    @DisplayName("Verificar al mandar 234 como id me regrese el formato correcto")
    public void getPostsFromFollowingWithTwoWeeksOldTestOkWay() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/products//followed/{userId}/list", 234)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$.posts").isArray())
                .andExpect((ResultMatcher) jsonPath("$.posts").isNotEmpty())
                .andExpect((ResultMatcher) jsonPath("$.posts.length()").value(1))
                .andExpect((ResultMatcher) jsonPath("$.posts[0].has_promo").value(false)
        );
    }
}
