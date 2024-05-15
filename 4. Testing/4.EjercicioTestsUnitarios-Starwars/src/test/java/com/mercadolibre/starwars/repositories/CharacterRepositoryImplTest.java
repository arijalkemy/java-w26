package com.mercadolibre.starwars.repositories;


import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CharacterRepositoryImplTest {

    private CharacterRepository repository;

    private CharacterDTO characterDTO;
    private List<CharacterDTO> characters;

    @BeforeEach
    void setUp() {
        repository = new CharacterRepositoryImpl();
        characterDTO = new CharacterDTO();
        characterDTO.setName("Leia Organa");
        characterDTO.setHeight(150);
        characterDTO.setMass(49);
        characterDTO.setHair_color("brown");
        characterDTO.setSkin_color("light");
        characterDTO.setEye_color("brown");
        characterDTO.setBirth_year("19BBY");
        characterDTO.setGender("female");
        characterDTO.setHomeworld("Alderaan");
        characterDTO.setSpecies("Human");

        characters = List.of(characterDTO);
    }

    @Test
    void findAllByNameContainsWithExistCharacterTest(){
         // act
         List<CharacterDTO> result = repository.findAllByNameContains("Leia");
         // assert
         Assertions.assertEquals(1, result.size());
         Assertions.assertEquals(characters.get(0).getName(), result.get(0).getName());
    }

    @Test
    void findAllByNameContainsWithNotExistCharacterTest(){
        // act
        List<CharacterDTO> result = repository.findAllByNameContains("Leiaa");
        //arrange
        Assertions.assertEquals(0, result.size());
        Assertions.assertEquals(List.of(), result);
    }

}