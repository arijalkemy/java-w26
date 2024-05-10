package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {FindService.class})
@ExtendWith(SpringExtension.class)
public class FindServiceTest {

    @MockBean
    private CharacterRepository characterRepository;

    @Autowired
    private FindService findService;

    @Test
    void Find() {
        // Arrange
        ArrayList<CharacterDTO> characterDTOList = new ArrayList<>();
        when(characterRepository.findAllByNameContains(Mockito.<String>any())).thenReturn(characterDTOList);

        // Act
        List<CharacterDTO> actualFindResult = findService.find("Query");

        // Assert
        verify(characterRepository).findAllByNameContains(eq("Query"));
        assertTrue(actualFindResult.isEmpty());
        assertSame(characterDTOList, actualFindResult);
    }
}
