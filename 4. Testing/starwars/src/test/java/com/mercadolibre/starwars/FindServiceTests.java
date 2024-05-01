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
public class FindServiceTests {
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    public void findCharacterByValidQuery() {
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
        when(characterRepository.findAllByNameContains(query)).thenReturn(expected);
        List<CharacterDTO> obtained = findService.find(query);

        //Assert
        Assertions.assertEquals(expected, obtained);
    }
}
