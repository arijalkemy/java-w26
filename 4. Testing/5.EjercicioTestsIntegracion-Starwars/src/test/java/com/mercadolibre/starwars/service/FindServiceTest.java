package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    private CharacterDTO characterDTO;

    List<CharacterDTO> characters;

    @BeforeEach
    void setUp() {
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
    void findExistCharacterTest() {
        //Arrange
        when(characterRepository.findAllByNameContains("Leia")).thenReturn(characters);

        //act
        List<CharacterDTO> response =findService.find("Leia");

        //assert
        verify(characterRepository, atLeastOnce()).findAllByNameContains("Leia");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(characters.get(0).getName(), response.get(0).getName());
    }

    @Test
    void findNotExistCharacterTest() {
        //Arrange
        when(characterRepository.findAllByNameContains("Leiaaa")).thenReturn(List.of());

        //act
        List<CharacterDTO> response =findService.find("Leiaaa");

        //assert
        verify(characterRepository, atLeastOnce()).findAllByNameContains("Leiaaa");
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.size(), 0);
    }
}