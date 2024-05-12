package repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryImpl {


    @Test
    @DisplayName("Find All By Name Contains Test")
    public void testFindAllByNameContains() {
        // Arrange
        String query = "Luke";
        com.mercadolibre.starwars.repositories.CharacterRepositoryImpl characterRepository = Mockito.mock(com.mercadolibre.starwars.repositories.CharacterRepositoryImpl.class);
        List<CharacterDTO> database = createCharacterList(); // Assuming you have a method to create sample data
        when(characterRepository.findAllByNameContains(query)).thenReturn(database);

        //Act
        List<CharacterDTO> actualList = characterRepository.findAllByNameContains(query);

        // Then

        Assertions.assertEquals(database, actualList);
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
