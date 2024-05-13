package org.meli.ejercicio4_testing_p3_1_starwars.unitTest.repositories;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.meli.ejercicio4_testing_p3_1_starwars.dto.CharacterDTO;
import org.meli.ejercicio4_testing_p3_1_starwars.repositories.CharacterRepositoryImpl;
import org.meli.ejercicio4_testing_p3_1_starwars.utils.PersonUtil;

import java.util.List;

public class CharacterRepositoryIntegrationTest {
    private CharacterRepositoryImpl characterRepository;

    @BeforeEach
    void setUp() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    @DisplayName("Test 0001 - Buscar al personaje: Luke Skywalker")
    void findAllByNameContains(){
        //Arrange
        CharacterDTO expected_character = PersonUtil.getListPerson().get(0);

        //Act
        List <CharacterDTO> character_obtained = characterRepository.findAllByNameContains(expected_character.getName());

        //Assert
        Assertions.assertEquals(expected_character.toString(), character_obtained.get(0).toString());
        Assertions.assertTrue(character_obtained.size() == 1);
    }

    @Test
    @DisplayName("Test 0001 - Buscar al personaje:'AAAAAAAAA' ")
    void findAllByNameContainsNotCharacter(){
        //Arrange
        CharacterDTO expected_character = new CharacterDTO();
        expected_character.setName("AAAAAAAAA");
        //Act
        List <CharacterDTO> character_obtained = characterRepository.findAllByNameContains(expected_character.getName());
        //Assert
        Assertions.assertTrue(character_obtained.size() == 0);
    }

    @Test
    @DisplayName("Test 0001 - Buscar al personaje:'', caso de borde llamar a todos los personajes")
    void findAllByNameContainsCharacter(){
        //Arrange
        List <CharacterDTO> expected_character = characterRepository.getDatabase();
        //Act
        List <CharacterDTO> character_obtained = characterRepository.findAllByNameContains("");
        //Assert
        Assertions.assertEquals(expected_character, character_obtained);
    }
}
