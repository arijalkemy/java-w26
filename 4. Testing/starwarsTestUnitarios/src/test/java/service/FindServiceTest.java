package service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    @Test
    void testFind() {
        // Arrange
        String query = "Luke";
        CharacterDTO character = new CharacterDTO();
        character.setName("Luke Skywalker");
        List<CharacterDTO> expected = Arrays.asList(character);
        when(characterRepository.findAllByNameContains(query)).thenReturn(expected);

        // Act
        List<CharacterDTO> actual = findService.find(query);

        // Assert
        assertEquals(expected, actual);
    }
}