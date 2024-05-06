package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    FindService controller;

    @InjectMocks
    FindController findController;
    @Test
    public void find() {
        // arrange
        String query = "Luke";

        // act
        findController.find(query);

        // assert
        verify(controller, atLeastOnce()).find(query);
    }
}
