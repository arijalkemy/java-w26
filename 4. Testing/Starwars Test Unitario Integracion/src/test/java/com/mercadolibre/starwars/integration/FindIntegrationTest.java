package com.mercadolibre.starwars.integration;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Find;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FindIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

    @Test
    @DisplayName("Busquedar de personaje por nombre")
    public void findCharacter()  {
        String name = "Luke Skywalker";

        try {
            this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}",name)
                    .contentType(MediaType.APPLICATION_JSON)
            ).andDo(print()).andExpect(status().isOk()).
                    andExpect(content().contentType("application/json"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value(name));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Busquedar de personaje con el nombre nulo")
    public void findCharacterNameNull()  {
        String name = null;

        try {
            this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}",name)
                            .contentType(MediaType.APPLICATION_JSON)
                    ).andDo(print()).andExpect(status().isNotFound());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
