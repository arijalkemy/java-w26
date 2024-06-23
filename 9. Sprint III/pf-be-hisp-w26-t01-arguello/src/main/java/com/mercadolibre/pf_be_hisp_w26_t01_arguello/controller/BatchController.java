package com.mercadolibre.pf_be_hisp_w26_t01_arguello.controller;

import com.mercadolibre.pf_be_hisp_w26_t01_arguello.Enum.CategoryEnum;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.Enum.OrderTypeEnum;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.BatchStockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.BatchServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.interfaces.IBatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products/batch")
@RequiredArgsConstructor
public class BatchController {
    private final IBatchService BatchService;
    @GetMapping("/list/due-date/{cantDays}")
    public ResponseEntity<BatchStockResponseDTO> GetProductCloseToExpiration(@PathVariable Integer cantDays,
                                                                             @RequestParam(required = false) CategoryEnum category,
                                                                             @RequestParam(required = false) OrderTypeEnum order){
        return ResponseEntity.status(HttpStatus.OK).body(BatchService
                .getBatchesCloseToExpiration(cantDays, category,order));
    }
}
