package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class CharacterRepositoryTest {
    CharacterRepository characterRepository= new CharacterRepositoryImpl();

    @Test
    @DisplayName("Find all by name test - voidList")
    public void findAllByNameTest(){
        List<CharacterDTO> expected = new ArrayList<>();

        List<CharacterDTO> result = characterRepository.findAllByNameContains("asdfasd");

        assertEquals(expected,result);
    }

    @Test
    @DisplayName("Find all by name test - Luke")
    public void findAllByNameLuke(){
        CharacterDTO lukeSkywalker= new CharacterDTO();
        lukeSkywalker.setName("Luke Skywalker");
        lukeSkywalker.setHair_color("blond");
        lukeSkywalker.setSkin_color("fair");
        lukeSkywalker.setEye_color("blue");
        lukeSkywalker.setBirth_year("19BBY");
        lukeSkywalker.setGender("male");
        lukeSkywalker.setHomeworld("Tatooine");
        lukeSkywalker.setSpecies("Human");
        lukeSkywalker.setHeight(172);
        lukeSkywalker.setMass(77);
        List<CharacterDTO> expectedList = new ArrayList<>();
        expectedList.add(lukeSkywalker);

        List<CharacterDTO> result = characterRepository.findAllByNameContains("Luke");

        assertEquals(expectedList.toString(),result.toString());
    }
}
