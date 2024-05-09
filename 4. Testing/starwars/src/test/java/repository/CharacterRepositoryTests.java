package repository;


import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterRepositoryTests {

    @Test
    public void findAllByNameContains_ReturnsFilteredCharacterList() {
        String query = "Skywalker";
        CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertTrue(result.stream().allMatch(characterDTO -> characterDTO.getName().contains(query)));
    }
}
