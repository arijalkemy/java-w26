package com.mercadolibre.starwars;


import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
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
    public void findCharacterByValidQuery() {
        //Arrange
        String query = "Luke";
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke");
        List<CharacterDTO> expected = List.of(characterDTO);

        //Act
        when(characterRepository.findAllByNameContains(query)).thenReturn(expected);
        List<CharacterDTO> obtained = findService.find(query);

        //Assert
        Assertions.assertEquals(expected, obtained);
    }
}