package service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    private CharacterRepository characterRepositoryMock;

    @InjectMocks
    private FindService findService;


    @Test
    public void testFind() {
        // Arrange
        String query = "Luke";
        List<CharacterDTO> expectedCharacters = createCharacterList();
        when(characterRepositoryMock.findAllByNameContains(query)).thenReturn(expectedCharacters);

        // Act
        List<CharacterDTO> actualCharacters = findService.find(query);

        // Assert
        assertEquals(expectedCharacters, actualCharacters);
    }


    private List<CharacterDTO> createCharacterList() {
        // Create sample character data for testing
        List<CharacterDTO> characters = new ArrayList<>();
        characters.add(new CharacterDTO("Luke"));
        characters.add(new CharacterDTO("Luke"));
        characters.add(new CharacterDTO("Luke"));
        return characters;
    }

}
