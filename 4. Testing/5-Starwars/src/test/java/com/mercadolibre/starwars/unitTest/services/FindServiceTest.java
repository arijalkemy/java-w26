package com.mercadolibre.starwars.unitTest.services;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepository characterRepository;
    @InjectMocks
    FindService findService;

    @Test
    void findAntNameOkTest(){
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

        when(characterRepository.findAllByNameContains(name)).thenReturn(charactersAnt);

        List<CharacterDTO> charactersFound = findService.find(name);

        Assertions.assertEquals(charactersAnt, charactersFound);
        Assertions.assertTrue(charactersFound.size() == 2);
    }
}
