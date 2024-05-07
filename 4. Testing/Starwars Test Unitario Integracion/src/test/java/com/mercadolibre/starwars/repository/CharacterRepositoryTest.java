package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.Util;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CharacterRepositoryTest {

    private CharacterRepository repository;

    @BeforeEach
    void setUp() {
        repository = new CharacterRepositoryImpl();
    }

    @Test
    @DisplayName("Busqueda de personajes por su nombre")
    void searchCharacters() {
        //Arrange
        CharacterDTO characterDTO = Util.characterTest();
        List<CharacterDTO> characterRespository;


        //Act
        characterRespository = repository.findAllByNameContains(characterDTO.getName());

        //Assert
        Assertions.assertEquals(characterDTO, characterRespository.get(0));
    }

    @Test
    @DisplayName("Buscar personajes con un nombre que no existe")
    void searchCharactersNotMatchingName() {
        //Arrange
        CharacterDTO characterDTO = new CharacterDTO();

        //Act
        //Assert
        Assertions.assertThrows(NullPointerException.class, () ->
                repository.findAllByNameContains(characterDTO.getName()));
    }
}
