package org.tests.starwars.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.tests.starwars.dto.CharacterDTO;
import org.tests.starwars.repositories.CharacterRepository;
import org.tests.starwars.utils.TestGeneratorCharacters;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @DisplayName("Test - Obtener personaje dado la palabra darth, caso exitoso")
    @Test
    void findTest() {
        // Arrange
        String query = "darth";
        List<CharacterDTO> charactersExpected = TestGeneratorCharacters.getCharactersWithDarth();
        when(characterRepository.findAllByNameContains(query)).thenReturn(charactersExpected);
        // Act
        List<CharacterDTO> charactersObtained = findService.find(query);
        // Assert
        assertTrue(charactersExpected.stream()
                .collect(Collectors.toList())
                .equals(charactersObtained.stream().collect(Collectors.toList())
                )
        );
    }

    @DisplayName("Test - Obtener personaje dado la palabra LeoMessi, lista vacia")
    @Test
    void findWithListEmptyTest() {
        // Arrange
        String query = "LeoMessi";
        when(characterRepository.findAllByNameContains(query)).thenReturn(List.of());
        // Act
        List<CharacterDTO> charactersObtained = findService.find(query);
        // Assert
        assertTrue(charactersObtained.isEmpty());
    }

}