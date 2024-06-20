package com.mercadolibre.fresh_market.controller;

import com.mercadolibre.fresh_market.dtos.BatchDTO;
import com.mercadolibre.fresh_market.dtos.InboundOrderDTO;
import com.mercadolibre.fresh_market.service.IInboundOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class InboundOrderControllerTest {
    @InjectMocks
    InboundOrderController inboundOrderController;

    @Mock
    IInboundOrder inboundOrderService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPostCreateInboundOrder() {
        // Arrange
        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO();
        List<BatchDTO> expectedResponse = new ArrayList<>();
        when(inboundOrderService.createInboundOrder(inboundOrderDTO)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<List<BatchDTO>> response = inboundOrderController.postCreateInboundOrder(inboundOrderDTO);

        // Assert
        assertEquals(expectedResponse, response.getBody());
        verify(inboundOrderService, times(1)).createInboundOrder(inboundOrderDTO);
    }

    @Test
    public void testPutUpdateInboundOrder() {
        // Arrange
        Long id = 1L;
        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO();
        List<BatchDTO> expectedResponse = new ArrayList<>();
        when(inboundOrderService.updateInboundOrder(id, inboundOrderDTO)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<List<BatchDTO>> response = inboundOrderController.putUpdateInboundOrder(id, inboundOrderDTO);

        // Assert
        assertEquals(expectedResponse, response.getBody());
        verify(inboundOrderService, times(1)).updateInboundOrder(id, inboundOrderDTO);
    }
}