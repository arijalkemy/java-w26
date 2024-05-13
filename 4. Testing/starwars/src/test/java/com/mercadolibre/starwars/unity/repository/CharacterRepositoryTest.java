package com.mercadolibre.starwars.unity.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;

@SpringBootTest
 class CharacterRepositoryTest {


    private CharacterRepositoryImpl characterRepositoryImpl;

    private CharacterDTO characterDTO;

    @BeforeEach
    void setUp() {
        characterRepositoryImpl = new CharacterRepositoryImpl();
        characterDTO = new CharacterDTO("Luke Skywalker", "blond", "fair", "blue",
                "19BBY", "male", "Tatoine", "Human", 172, 77);
    }

    @Test
    @DisplayName("Found All by name contains successful in repository")
     void testFindAllByNameContainsSuccessful() {
        // Act
        List<CharacterDTO> result = characterRepositoryImpl.findAllByNameContains(characterDTO.getName());
        // Assert
        assertEquals(1, result.size());
        assertEquals(characterDTO.getName(), result.get(0).getName());
    }

    @Test
    @DisplayName("Found All by name contains unsuccessful in repository")
     void testFindAllByNameContainsUnsuccessful() {
        // Arrange
        characterDTO.setName("Character_not_found");

        // Act
        List<CharacterDTO> result = characterRepositoryImpl
                .findAllByNameContains(characterDTO.getName());

        // Assert
        assertEquals(0, result.size());
    }

}
