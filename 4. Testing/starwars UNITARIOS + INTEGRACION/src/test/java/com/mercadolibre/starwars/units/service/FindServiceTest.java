package com.mercadolibre.starwars.units.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    @DisplayName("Busca todos los personajes que coincidan y compara si son correctos")
    void findAllNotEmptyListCharacter() {
        //Arrange
        String queryName = "Darth";

        CharacterDTO character1 = new CharacterDTO();
        character1.setName("Darth Vader");
        character1.setHair_color("none");
        character1.setSkin_color("white");
        character1.setEye_color("yellow");
        character1.setBirth_year("41.9BBY");
        character1.setGender("male");
        character1.setHair_color("Tatooine");
        character1.setSpecies("Human");
        character1.setHeight(202);
        character1.setMass(136);

        CharacterDTO character2 = new CharacterDTO();
        character2.setName("Darth Maul");
        character2.setHair_color("none");
        character2.setSkin_color("red");
        character2.setEye_color("yellow");
        character2.setBirth_year("54BBY");
        character2.setGender("male");
        character2.setHair_color("Dathomir");
        character2.setSpecies("Zabrak");
        character2.setHeight(175);
        character2.setMass(80);

        List<CharacterDTO> expected = List.of(character1,character2);

        //Act
        when(characterRepository.findAllByNameContains(queryName)).thenReturn(expected);
        List<CharacterDTO> output = findService.find(queryName);

        //Assert
        Assertions.assertEquals(expected, output);
    }

    @Test
    @DisplayName("Busca el nombre de un personaje que no existe")
    void findAllButIsAnEmptyListCharacter() {
        //Arrange
        String queryName = "CleanCode";

        List<CharacterDTO> expected = List.of();
        Integer expectedSize = 0;

        //Act
        when(characterRepository.findAllByNameContains(queryName)).thenReturn(expected);
        List<CharacterDTO> output = findService.find(queryName);

        //Assert
        Assertions.assertEquals(expected, output);
        Assertions.assertEquals(expectedSize, output.size());
    }
}
