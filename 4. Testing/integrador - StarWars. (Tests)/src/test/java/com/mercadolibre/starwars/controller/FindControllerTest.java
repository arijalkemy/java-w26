package com.mercadolibre.starwars.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Debería mostrar una coincidencia llamando al servicio")
    public void findControllerStarWarsTest() throws Exception {
        String input = "Luke";

        String url = String.format("/%s", input);
        String expectedResponse= "[{" +
                "\"name\":\"Luke Skywalker\"," +
                "\"hair_color\":\"blond\"," +
                "\"skin_color\":\"fair\"," +
                "\"eye_color\":\"blue\"," +
                "\"birth_year\":\"19BBY\"," +
                "\"gender\":\"male\"," +
                "\"homeworld\":\"Tatooine\"," +
                "\"species\":\"Human\"," +
                "\"height\":172," +
                "\"mass\":77" +
                "}]";
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(content().string(expectedResponse))
                .andExpect(status().isOk());
    }


}