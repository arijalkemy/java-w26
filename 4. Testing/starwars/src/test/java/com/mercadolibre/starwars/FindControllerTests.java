package com.mercadolibre.starwars;

import com.mercadolibre.starwars.controller.FindController;
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
public class FindControllerTests {
    @Mock
    private CharacterRepository characterRepository;

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

    @Test
    public void findOneCharacterByValidName(){
        //Arrange
        String query = "Luke";
        List<CharacterDTO> expected = List.of(
                new CharacterDTO("Luke Skywalker", 172,
                77,
                "blond",
                "fair",
                "blue",
                "19BBY",
                "male",
                "Tatooine",
                "Human")
        );

        //Act
        when(findService.find(query)).thenReturn(expected);
        List<CharacterDTO> obtained = findController.find(query);

        //Assert
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    public void findMultipleCharacterByValidName(){
        String query = "Lu";
        List<CharacterDTO> expected = List.of(
                new CharacterDTO(
                        "Luminara Unduli",
                        170,
                        56,
                        "black",
                        "yellow",
                        "blue",
                        "58BBY",
                        "female",
                        "Mirial",
                        "Mirialan"),
                new CharacterDTO("Luke Skywalker", 172,
                        77,
                        "blond",
                        "fair",
                        "blue",
                        "19BBY",
                        "male",
                        "Tatooine",
                        "Human")
        );
        when(findService.find(query)).thenReturn(expected);
        List<CharacterDTO> obtained = findController.find(query);
        Assertions.assertEquals(expected, obtained);
    }
}
