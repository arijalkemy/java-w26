package com.mercadolibre.fresh_market.controller;

import com.mercadolibre.fresh_market.dtos.BatchDTO;
import com.mercadolibre.fresh_market.dtos.InboundOrderDTO;
import com.mercadolibre.fresh_market.dtos.InboundOrderReqDTO;
import com.mercadolibre.fresh_market.service.IInboundOrderService;
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
    IInboundOrderService inboundOrderService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPostCreateInboundOrder() {
        // Arrange
        InboundOrderReqDTO inboundOrderReqDTO = new InboundOrderReqDTO();
        InboundOrderDTO inboundOrderDTO = new InboundOrderDTO();
        inboundOrderReqDTO.setInboundOrderDTO(inboundOrderDTO);
        List<BatchDTO> expectedResponse = new ArrayList<>();
        when(inboundOrderService.createInboundOrder(inboundOrderReqDTO)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<List<BatchDTO>> response = inboundOrderController.postCreateInboundOrder(inboundOrderReqDTO);

        // Assert
        assertEquals(expectedResponse, response.getBody());
        verify(inboundOrderService, times(1)).createInboundOrder(inboundOrderReqDTO);
    }

    @Test
    void testPutUpdateInboundOrder() {
        // Arrange
        Long id = 1L;
        InboundOrderReqDTO inboundOrderReqDTO = new InboundOrderReqDTO(new InboundOrderDTO());

        List<BatchDTO> expectedResponse = new ArrayList<>();
        when(inboundOrderService.updateInboundOrder(id, inboundOrderReqDTO)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<List<BatchDTO>> response = inboundOrderController.putUpdateInboundOrder(id, inboundOrderReqDTO);

        // Assert
        assertEquals(expectedResponse, response.getBody());
        verify(inboundOrderService, times(1)).updateInboundOrder(id, inboundOrderReqDTO);
    }
}