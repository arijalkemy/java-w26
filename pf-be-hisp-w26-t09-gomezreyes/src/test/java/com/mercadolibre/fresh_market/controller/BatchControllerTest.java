package com.mercadolibre.fresh_market.controller;

import com.mercadolibre.fresh_market.dtos.ExpiringProductResponseDTO;
import com.mercadolibre.fresh_market.service.impl.BatchServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BatchControllerTest {


    @Mock
    private BatchServiceImpl batchService;

    @InjectMocks
    private BatchController batchController;


    @Test
    public void testGetBatchesExpiringSoon() {
        Integer countDays = 10;
        ExpiringProductResponseDTO expiringProductResponseDTO = new ExpiringProductResponseDTO();
        when(batchService.getBatchesExpiringSoon(countDays)).thenReturn(expiringProductResponseDTO);

        ResponseEntity<ExpiringProductResponseDTO> response = batchController.getBatchesExpiringSoon(countDays,
                null, null);
        verify(batchService).getBatchesExpiringSoon(countDays);
        assertEquals(expiringProductResponseDTO, response.getBody());

    }

    @Test
    public void testGetBatchesExpiringSoonByCategoryAndOrder() {
        Integer countDays = 10;
        String category = "FF";
        String order = "date";
        ExpiringProductResponseDTO expiringProductResponseDTO = new ExpiringProductResponseDTO();
        when(batchService.getBatchesExpiringSoonByCategoryAndOrder(countDays, category, order))
                .thenReturn(expiringProductResponseDTO);

        ResponseEntity<ExpiringProductResponseDTO> response = batchController.getBatchesExpiringSoon(countDays,
                category, order);
        verify(batchService).getBatchesExpiringSoonByCategoryAndOrder(countDays, category, order);
        assertEquals(expiringProductResponseDTO, response.getBody());
    }
}
