package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryTest {
    @Mock
    private CharacterRepositoryImpl characterRepository;

    @Test
    @DisplayName("Buscar un nombre existente")
    public void findAllByNameContainsOk() throws Exception {
        String query="luke";

        List<CharacterDTO> characterDTOS = new ArrayList<>();
        characterDTOS.add(new CharacterDTO(
                "Luke Skywalker",
                172,
                77,
                "blond",
                "fair",
                "blue",
                "19BBY",
                "male",
                "Tatooine",
                "Human"
        ));

        when(characterRepository.findAllByNameContains(query)).thenReturn(characterDTOS);

        List<CharacterDTO> obtainsList = characterRepository.findAllByNameContains(query);

        Assertions.assertEquals(characterDTOS, obtainsList);
    }

    @Test
    @DisplayName("Buscamos un nombre no existente")
    public void findAllByNameContainsNotFound() throws Exception {
        String query="pepo";

        when(characterRepository.findAllByNameContains(query)).thenReturn(new ArrayList<>());

        List<CharacterDTO> obtainsList = characterRepository.findAllByNameContains(query);

        Assertions.assertEquals(new ArrayList<>(), obtainsList);
    }


}
