package controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest{
    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    @DisplayName("Find controller test happy path")
    public void findTest(){
        String query = "Luke";

        List<CharacterDTO> characterDTOList = new ArrayList<>();

        Mockito.when(findService.find(query)).thenReturn(characterDTOList);

        List<CharacterDTO> actualList = findController.find(query);

        Assertions.assertEquals(actualList, characterDTOList);
    }
}
