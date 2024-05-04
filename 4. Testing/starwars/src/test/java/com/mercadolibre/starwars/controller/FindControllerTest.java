package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.util.UtilTestCharacters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class FindControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    private String characterSearch;

    List<CharacterDTO> characters;

    @BeforeEach
    public void setup() {
        characterSearch = "lu";
        characters = UtilTestCharacters.generateListOfCharacters(characterSearch);
    }

    @Test
    @DisplayName("check returned List")
    public void findTest() {
        when(service.find(characterSearch)).thenReturn(characters);
        List<CharacterDTO> expected = characters;
        List<CharacterDTO> result = controller.find(characterSearch);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("check return status")
    public void findTestStatus() throws Exception {
        MvcResult result =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", characterSearch))
                        .andDo(print()).andExpect(status().isOk())
                        .andReturn();
    }
}
