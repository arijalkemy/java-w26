package com.mercadolibre.pf_be_hisp_w26_t6_martinez.controller;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.BatchDto.BatchTransferDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.OutboundOrderDto.OutboundOrderDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.OutboundOrderDto.OutboundOrderRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.TransferService.ITransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OutboundControllerTest {

    @Mock
    private ITransferService transferService;

    @InjectMocks
    private OutboundOrderController outboundOrderController;

    @Test
    @DisplayName("Test initiateTransfer in OutboundOrderController")
    public void testInitiateTransfer() {
        OutboundOrderDto outboundOrderDto = OutboundOrderDto.builder()
                .orderNumber(1L)
                .warehouseOrigin(1)
                .warehouseDestination(2)
                .batches(Collections.singletonList(new BatchTransferDto(1)))
                .build();

        OutboundOrderRequestDto outboundOrderRequestDto = OutboundOrderRequestDto.builder()
                .outboundOrderDto(outboundOrderDto)
                .build();

        outboundOrderController.initiateTransfer(outboundOrderRequestDto);

        verify(transferService).initiateTransfer(any(OutboundOrderDto.class));
    }

    @Test
    @DisplayName("Test updateTransferStatus in OutboundOrderController")
    public void testUpdateTransferStatus() {
        Long orderNumber = 1L;
        String newStatus = "IN_PROGRESS";

        outboundOrderController.updateTransfer(orderNumber, newStatus);

        verify(transferService).updateTransferStatus(orderNumber, newStatus);
    }
}
