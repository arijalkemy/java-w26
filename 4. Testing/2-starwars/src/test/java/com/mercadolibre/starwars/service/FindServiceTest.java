package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    private CharacterRepositoryImpl characterRepository;

    @InjectMocks
    private FindService findService;

    @Test
    public void findCharacter() {
        // Arrange
        List<CharacterDTO> list = List.of(

                new CharacterDTO(
                        "Biggs Darklighter",
                        "black",
                        "light",
                        "brown",
                        "24BBY",
                        "male",
                        "Tatooine",
                        "Human",
                        183,
                        84
                )
        );

        // Act
        when(characterRepository.findAllByNameContains("Dark")).thenReturn(list);
        List<CharacterDTO> result = findService.find("Dark");

        // Assert
        Assertions.assertEquals(list, result);
    }
}
