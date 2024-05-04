package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    private FindController findController;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void find() {
        // Arrange
        String query = "Luke";
        when(findService.find(anyString())).thenReturn(new ArrayList<>());

        // Act
        findController.find(query);

        // Assert
        verify(findService, atLeastOnce()).find(anyString());
        Assertions.assertEquals(0, findController.find(query).size());
    }
}
