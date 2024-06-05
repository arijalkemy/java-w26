package org.meli.ejercicio4_testing_p3_1_starwars.unitTest.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meli.ejercicio4_testing_p3_1_starwars.dto.CharacterDTO;
import org.meli.ejercicio4_testing_p3_1_starwars.repositories.CharacterRepository;
import org.meli.ejercicio4_testing_p3_1_starwars.service.FindService;
import org.meli.ejercicio4_testing_p3_1_starwars.utils.PersonUtil;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    private CharacterRepository characterRepository;
    @InjectMocks
    private FindService findService;

    @Test
    @DisplayName("Test 0002 - Obtención del personaje Luke")
    public void findCharacter() {
        //Arrange
        CharacterDTO characterDTO = PersonUtil.getListPerson().get(0);

        List<CharacterDTO> expected_character = new ArrayList<>();
        expected_character.add(characterDTO);

        //Act
        Mockito.when(characterRepository.findAllByNameContains(characterDTO.getName())).thenReturn(expected_character);
        List<CharacterDTO> character_obtained = findService.find(characterDTO.getName());

        Assertions.assertEquals(expected_character, character_obtained);

    }
}
