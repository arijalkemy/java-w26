package org.meli.ejercicio4_testing_p3_1_starwars.unitTest.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meli.ejercicio4_testing_p3_1_starwars.controller.FindController;
import org.meli.ejercicio4_testing_p3_1_starwars.dto.CharacterDTO;
import org.meli.ejercicio4_testing_p3_1_starwars.service.FindService;
import org.meli.ejercicio4_testing_p3_1_starwars.utils.PersonUtil;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    private FindService findService;
    @InjectMocks
    private FindController findController;

    @Test
    @DisplayName("Test 0003 - Obtención del personaje Luke")
    public void testFindPersonajeLuke() {
        //Arrange
        CharacterDTO characterDTO = PersonUtil.getListPerson().get(0);
        List<CharacterDTO> characterDTOList = new ArrayList<>();
        characterDTOList.add(characterDTO);
        //Act
        Mockito.when(findService.find(characterDTO.getName())).thenReturn(characterDTOList);
        List<CharacterDTO> character_obtained = findController.find(characterDTO.getName());
        //Assert
        Assertions.assertEquals(characterDTOList, character_obtained);
    }
}
