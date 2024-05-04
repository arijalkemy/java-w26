package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static com.mercadolibre.starwars.util.CreateCharacterUtil.createLuke;
import static org.mockito.Mockito.*;


import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    @DisplayName("Find Controller Test")
    public void findTest(){
        //arrange
        String query = "Luke";
        List<CharacterDTO> listExpected = List.of(createLuke());

        //act
        when(findService.find(query)).thenReturn(listExpected);
        List<CharacterDTO> listObtained = findController.find(query);

        //assert
        Assertions.assertEquals(listExpected, listObtained);
    }


    @Test
    @DisplayName("Find Controller Empty Test")
    public void findNullTest(){
        //arrange
        String query = "Lionel";
        List<CharacterDTO> listExpected = new ArrayList<>();

        //act
        when(findService.find(query)).thenReturn(listExpected);
        List<CharacterDTO> listObtained = findController.find(query);

        //assert
        Assertions.assertEquals(listExpected, listObtained);
    }
}
