package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    @DisplayName("Tests finding exactly one character successfully.")
    public void findOneOkTest() {
        // Arrange
        String name = "Luke";
        CharacterDTO character = new CharacterDTO(
            "Luke Skywalker",
            "blond",
            "fair",
            "blue",
            "19BBY",
            "male",
            "Tatooine",
            "Human",
            172,
            77
        );
        List<CharacterDTO> characterDTOs = new ArrayList<>(){{
            add(character);
        }};

        // Act
        when(findService.find(name)).thenReturn(characterDTOs);
        List<CharacterDTO> result = findController.find(name);

        // Assert
        Assertions.assertTrue(result.size() == 1);
        Assertions.assertEquals(character, result.get(0));
        Assertions.assertTrue(result.get(0).getName().contains(name));
    }

    @Test
    @DisplayName("Tests finding more than one character successfully.")
    public void findMoreThanOneOkTest() {
        // Arrange
        String name = "Darth";

        CharacterDTO characterOne = new CharacterDTO("Darth Vader");
        CharacterDTO characterTwo = new CharacterDTO("Darth Maul");

        List<CharacterDTO> characterDTOs = new ArrayList<>(){{
            add(characterOne);
            add(characterTwo);
        }};

        // Act
        when(findService.find(name)).thenReturn(characterDTOs);
        List<CharacterDTO> result = findController.find(name);

        // Assert
        Assertions.assertTrue(result.size() > 1);
        Assertions.assertAll(
            result.stream().map(
                characterDTO -> () -> Assertions.assertTrue(characterDTO.getName().contains(name))
            )
        );
    }

    @Test
    @DisplayName("Tests finding no character without error.")
    public void findNoOneOkTest() {
        // Arrange
        String name = "Matches No One";
        List<CharacterDTO> characterDTOs = new ArrayList<>();

        // Act
        when(findService.find(name)).thenReturn(characterDTOs);
        List<CharacterDTO> result = findController.find(name);

        // Assert
        Assertions.assertTrue(result.size() == 0);
    }
}
