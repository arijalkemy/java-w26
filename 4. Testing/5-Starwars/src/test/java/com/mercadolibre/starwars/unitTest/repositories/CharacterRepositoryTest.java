package com.mercadolibre.starwars.unitTest.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CharacterRepositoryTest {

    private CharacterRepositoryImpl repository;

    @BeforeEach
    void setup() {
        repository = new CharacterRepositoryImpl();
    }

    @Test
    void findByAntName() {
        String name = "Ant";

        List<CharacterDTO> charactersAnt = new ArrayList<>();

        CharacterDTO character1 = new CharacterDTO();
        character1.setName("Wedge Antilles");
        character1.setHeight(170);
        character1.setMass(77);
        character1.setHair_color("brown");
        character1.setSkin_color("fair");
        character1.setEye_color("hazel");
        character1.setBirth_year("21BBY");
        character1.setGender("male");
        character1.setHomeworld("Corellia");
        character1.setSpecies("Human");

        CharacterDTO character2 = new CharacterDTO();
        character2.setName("Raymus Antilles");
        character2.setHeight(188);
        character2.setMass(79);
        character2.setHair_color("brown");
        character2.setSkin_color("light");
        character2.setEye_color("brown");
        character2.setBirth_year("NA");
        character2.setGender("male");
        character2.setHomeworld("Alderaan");
        character2.setSpecies("Human");

        charactersAnt.add(character1);
        charactersAnt.add(character2);

        List<CharacterDTO> charactersFound = repository.findAllByNameContains(name);

        Assertions.assertEquals(charactersAnt, charactersFound);
    }
}
