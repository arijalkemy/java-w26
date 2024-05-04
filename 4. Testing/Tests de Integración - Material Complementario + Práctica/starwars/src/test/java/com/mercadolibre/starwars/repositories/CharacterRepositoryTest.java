package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryTest {

    CharacterRepository characterRepository;

    @BeforeEach
    public void setUp() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    public void findByName() {
        // Arrange
        String name = "Luke";
        CharacterDTO character = new CharacterDTO();
        character.setName("Luke Skywalker");
        character.setHair_color("blond");
        character.setSkin_color("fair");
        character.setEye_color("blue");
        character.setBirth_year("19BBY");
        character.setGender("male");
        character.setHomeworld("Tatooine");
        character.setSpecies("Human");
        character.setHeight(172);
        character.setMass(77);

        // Act
                List<CharacterDTO> characters =
        characterRepository.findAllByNameContains(name);

        // Assert
        Assertions.assertEquals(1, characters.size());
        Assertions.assertEquals(character, characters.get(0));
    }
}
