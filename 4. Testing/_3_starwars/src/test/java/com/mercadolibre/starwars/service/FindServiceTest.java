package com.mercadolibre.starwars.service;

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
    public void findOk(){
        String query = "Luke";
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

        //ACT
        Mockito.when(repository.findAllByNameContains(query)).thenReturn(characterDTOS);
        //ASSERT
        Assertions.assertEquals(characterDTOS, repository.findAllByNameContains(query));
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
