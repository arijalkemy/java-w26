package com.mercadolibre.starwars.integration;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.util.TestStarWarsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URLDecoder;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIntegrationTest {

    @MockBean
    FindService findService;

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test - Obtencion del método get para obtener la lista de personajes que coincidan con el query")
    public void findCharactersOkResponse() throws Exception {


        List<CharacterDTO> LukeEsperado = TestStarWarsGenerator.characterLuke();
        when(findService.find("Luke")).thenReturn(LukeEsperado);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "Luke"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*.name").value(LukeEsperado.get(0).getName()));
    }
}
