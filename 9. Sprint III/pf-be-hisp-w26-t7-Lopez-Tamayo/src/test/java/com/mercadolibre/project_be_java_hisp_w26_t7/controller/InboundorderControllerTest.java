package com.mercadolibre.project_be_java_hisp_w26_t7.controller;

import com.mercadolibre.project_be_java_hisp_w26_t7.service.InboundorderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InboundorderControllerTest {

    @Mock
    private InboundorderServiceImpl inboundorderService;

    @InjectMocks
    private InboundorderController inboundorderController;

    @BeforeEach
    void setUp() {

    }

    @Test
    void createInboundorderTest() {
        // Arrange
        when(inboundorderService.saveInboundorder(null)).thenReturn(null);
        // Act
        inboundorderController.createInboundorder(null);
        // Assert

    }

    @Test
    void updateInboundorderTest() {
        // Arrange
        when(inboundorderService.updateInboundorder(null)).thenReturn(null);
        // Act
        inboundorderController.updateInboundorder(null);
        // Assert

    }

}