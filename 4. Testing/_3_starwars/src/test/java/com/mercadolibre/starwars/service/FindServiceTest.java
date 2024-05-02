package com.mercadolibre.starwars.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepositoryImpl repository;
    @InjectMocks
    FindService service;

    @Test
    public void findOk() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        String query = "Luke";
        List<CharacterDTO> characterDTOS = new ArrayList<>();
        characterDTOS.add(new CharacterDTO(
                "Luke Skywalker",
                "blond",
                "fair",
                "blue",
                "19BBY",
                "male",
                "Tatooine",
                "Human",
                172,
                77
        ));

        //ACT
        Mockito.when(repository.findAllByNameContains(query)).thenReturn(characterDTOS);

        //BUSCAR EN EL SERVICE REAL (para probar correctamente la funcionalidad)
        List<CharacterDTO> characterDTOSObtains = service.find(query);

        String obtains = mapper.writeValueAsString(characterDTOSObtains);
        String actual = mapper.writeValueAsString(characterDTOS);

        //ASSERT
        Assertions.assertEquals(actual, obtains);
    }

    @Test
    public void findNotFound(){
        //ARRANGE
        String query = "Pedro";
        //ACT
        Mockito.when(repository.findAllByNameContains(query)).thenReturn(new ArrayList<>());
        //ASSERT
        Assertions.assertEquals(new ArrayList<>(), repository.findAllByNameContains(query));
    }
}
