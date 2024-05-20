package controller;

import com.mercadolibre.starwars.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

    @Test
    void testFind() {
        // Arrange
        String query = "Luke";
        CharacterDTO character = new CharacterDTO();
        character.setName("Luke Skywalker");
        List<CharacterDTO> expected = Arrays.asList(character);
        when(findService.find(query)).thenReturn(expected);

        // Act
        List<CharacterDTO> actual = findController.find(query);

        // Assert
        assertEquals(expected, actual);
    }

}
