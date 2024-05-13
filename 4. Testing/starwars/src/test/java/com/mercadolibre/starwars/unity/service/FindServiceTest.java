package com.mercadolibre.starwars.unity.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
 class FindServiceTest {

    @Mock
    CharacterRepositoryImpl characterRepositoryImpl;

    @InjectMocks
    FindService findService;
    
    private CharacterDTO characterDTO;

    @BeforeEach
     void setup() {
        findService = new FindService(characterRepositoryImpl);
        characterDTO = new CharacterDTO("Luke Skywalker", "blond", "fair", "blue",
                "19BBY", "male", "Tatoine", "Human", 172, 77);
    }

    @Test
    @DisplayName("Found All by name contains successful in service")
    void findOkTest() {
        // Arrange
        when(characterRepositoryImpl.findAllByNameContains(characterDTO.getName()))
                .thenReturn(List.of(characterDTO));
        // Act
        List<CharacterDTO> result = findService.find(characterDTO.getName());
        
        // Assert
        assertEquals(1, result.size());
        assertEquals(characterDTO.getName(), result.get(0).getName());
        verify(characterRepositoryImpl, atLeastOnce()).findAllByNameContains(characterDTO.getName());
    }

    @Test
    @DisplayName("Found all by name contains unsuccessful in service")
    void testFoundAllByNameUnsuccessful() {
        // Arrange
        when(characterRepositoryImpl.findAllByNameContains(characterDTO.getName())).thenReturn(List.of());

        // Act
        List<CharacterDTO> result = findService.find(characterDTO.getName());

        // Assert
        assertEquals(0, result.size());
        verify(characterRepositoryImpl, atLeastOnce()).findAllByNameContains(characterDTO.getName());
    }
}
