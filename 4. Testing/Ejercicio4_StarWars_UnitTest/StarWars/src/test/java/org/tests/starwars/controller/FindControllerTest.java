package org.tests.starwars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.tests.starwars.dto.CharacterDTO;
import org.tests.starwars.service.FindService;
import org.tests.starwars.utils.TestGeneratorCharacters;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FindController.class)
class FindControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FindService findService;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @DisplayName("Test - Obtener personaje dado la palabra darth, caso exitoso")
    @Test
    void findTest() throws Exception {
        // Arrange
        String query = "darth";
        List<CharacterDTO> charactersExpected = TestGeneratorCharacters.getCharactersWithDarth();
        when(findService.find(query)).thenReturn(charactersExpected);
        // Act - Assert
        mockMvc.perform(get("/{query}", query))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(result -> assertEquals(
                                writer.writeValueAsString(charactersExpected),
                                result.getResponse().getContentAsString(StandardCharsets.UTF_8)
                        )
                );
    }

    @DisplayName("Test - Obtener personaje dado la palabra LeoMessi, lista vacia")
    @Test
    void findWithEmptyListTest() throws Exception {
        // Arrange
        String query = "LeoMessi";
        when(findService.find(query)).thenReturn(List.of());
        // Act - Assert
        mockMvc.perform(get("/{query}", query))
                .andDo(print())
                .andExpect(result -> assertEquals(
                                "[]", result.getResponse().getContentAsString(StandardCharsets.UTF_8)
                        )
                );
    }
}