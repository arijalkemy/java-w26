package org.tests.starwars.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tests.starwars.dto.CharacterDTO;
import org.tests.starwars.utils.TestGeneratorCharacters;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharacterRepositoryImplTest {

    private CharacterRepository characterRepository;


    @BeforeEach
    void setUp() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @DisplayName("Test - Obtener personaje dado la palabra darth, caso exitoso")
    @Test
    void findAllByNameContainsTest() throws JsonProcessingException {
        // Arrange
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        List<CharacterDTO> charactersExpected = TestGeneratorCharacters.getCharactersWithDarth();
        // Act
        List<CharacterDTO> charactersObteined = characterRepository.findAllByNameContains("darth");
        // Assert
        assertEquals(writer.writeValueAsString(charactersExpected), writer.writeValueAsString(charactersObteined));
    }

    @DisplayName("Test - Obtener personaje dado la palabra LeoMessi, lista vacía")
    @Test
    void findAllByNameContainsNoContentTest() throws JsonProcessingException {
        // Act
        List<CharacterDTO> charactersObteined = characterRepository.findAllByNameContains("LeoMessi");
        // Assert
        assertTrue(charactersObteined.isEmpty());
    }
}