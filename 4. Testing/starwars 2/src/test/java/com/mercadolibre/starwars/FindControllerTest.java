package com.mercadolibre.starwars;


import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(value = MockitoExtension.class)
public class FindControllerTest {

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

    @Test
    public void testGetCharacterById(){
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke");

        List<CharacterDTO> characterDTOList = List.of(new CharacterDTO());

        //Arrange
        when(findController.find("Luke")).thenReturn(characterDTOList);

        //Act
        List<CharacterDTO> characterDTOFind = findController.find("Luke");

        //Assert
        Assertions.assertEquals(characterDTOFind, characterDTOList);
    }
}
