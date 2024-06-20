package com.mercadolibre.project_be_java_hisp_w26_t7.controller;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.batch.BatchStockResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.others.InboundorderRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.InboundorderServiceImpl;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.DataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
        InboundorderRequestDTO request = DataUtils.bodyForIntegrationInboundOrderDto();
        BatchStockResponseDTO expected = DataUtils.responseIntegrationInboundOrder();
        when(inboundorderService.saveInboundorder(request)).thenReturn(expected);

        // Act
        ResponseEntity<BatchStockResponseDTO> actual = inboundorderController.createInboundorder(request);

        // Assert
        assertEquals(HttpStatus.CREATED, actual.getStatusCode());
        assertEquals(expected, actual.getBody());
    }

    @Test
    void updateInboundorderTest() {
        // Arrange
        InboundorderRequestDTO request = DataUtils.bodyForIntegrationInboundOrderDto();
        BatchStockResponseDTO expected = DataUtils.responseIntegrationInboundOrder();
        when(inboundorderService.updateInboundorder(request)).thenReturn(expected);

        // Act
        ResponseEntity<BatchStockResponseDTO> actual = inboundorderController.updateInboundorder(request);

        // Assert
        assertEquals(HttpStatus.CREATED, actual.getStatusCode());
        assertEquals(expected, actual.getBody());
    }

}