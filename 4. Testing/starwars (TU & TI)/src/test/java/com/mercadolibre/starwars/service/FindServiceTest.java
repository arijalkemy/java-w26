package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.util.TestStarWarsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService service;

    @Test
    @DisplayName("Obtencion de la lista de personajes coincidentes con el query")
    public void findCharacter() {
        String query = "Luke";
        List<CharacterDTO> LukeEsperado = TestStarWarsGenerator.characterLuke();

        when(characterRepository.findAllByNameContains(query)).thenReturn(LukeEsperado);
        List<CharacterDTO> LukeObtenido = service.find(query);

        Assertions.assertEquals(LukeEsperado, LukeObtenido);


    }
}
