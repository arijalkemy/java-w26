package repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
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
public class CharacterRepositoryImplTest {
    @Mock
    private CharacterRepository characterRepository;
    @InjectMocks
    private CharacterRepositoryImpl characterRepositoryImpl;
    @Test
    void testFindAllByNameContains() {
        // Arrange
        String query = "Luke";
        CharacterDTO character = new CharacterDTO();
        character.setName("Luke Skywalker");
        List<CharacterDTO> expected = Arrays.asList(character);
        when(characterRepository.findAllByNameContains(query)).thenReturn(expected);

        // Act
        List<CharacterDTO> actual = characterRepository.findAllByNameContains(query);

        // Assert
        assertEquals(expected, actual);
    }
}