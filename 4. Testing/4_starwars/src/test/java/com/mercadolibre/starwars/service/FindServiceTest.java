package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;


    @Test
    void findLuke() {
        List<CharacterDTO> characters = List.of(
            new CharacterDTO(
                    "Luke Skywalker",
                    "blond",
                    "fair",
                    "blue",
                    "19BBY",
                    "male",
                    "Tatooine",
                    "Human",
                    77,
                    172
            )
        );

        Mockito.when(characterRepository.findAllByNameContains("Luke")).thenReturn(characters);

        // act & assert
        Assertions.assertEquals(characters.size(), this.findService.find("Luke").size());
        Assertions.assertEquals(
                characters.get(0).getHomeworld(), this.findService.find("Luke").get(0).getHomeworld()
        );
    }

    @Test
    void findUnknownCharacter() {
        String query = "Empanadas de carne";
        Mockito.when(characterRepository.findAllByNameContains(query)).thenReturn(List.of());

        // act & assert
        Assertions.assertEquals(0, this.findService.find(query).size());
    }
}