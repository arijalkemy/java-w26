package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(value = MockitoExtension.class)
public class CharacterRepositoryImplTest {

    @Mock
    private CharacterRepositoryImpl characterRepository;

    @Test
    public void testFindAllByNameContains(){
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke");

        //Arrange
        when(characterRepository.findAllByNameContains("Luke")).thenReturn(List.of(characterDTO));

        //Act
        List<CharacterDTO> characterDTOFind = characterRepository.findAllByNameContains("Luke");

        //Assert
        Assertions.assertEquals(characterDTOFind, List.of(characterDTO));
    }
}
