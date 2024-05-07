package com.mercadolibre.starwars.service;


import com.mercadolibre.starwars.Util;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    private CharacterRepository repository;

    @InjectMocks
    private FindService service;

    @Test
    @DisplayName("Encontrar personaje")
    public void findCharacter() {
        //Arrange

        List<CharacterDTO> characterDTOList = List.of(Util.characterTest());
        List<CharacterDTO> reponse;

        Mockito.when(repository.findAllByNameContains(characterDTOList.get(0).getName()))
                .thenReturn(characterDTOList);

        //Act
        reponse = service.find(characterDTOList.get(0).getName());

        //Assert
        Assertions.assertEquals(characterDTOList, reponse);

    }
}
