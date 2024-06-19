package com.mercadolibre.final_project_java_hisp_w26_t1.controller;

import com.mercadolibre.final_project_java_hisp_w26_t1.Enum.CategoryEnum;
import com.mercadolibre.final_project_java_hisp_w26_t1.Enum.OrderTypeEnum;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.BatchStockResponseDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.service.BatchServiceImpl;
import com.mercadolibre.final_project_java_hisp_w26_t1.service.interfaces.IBatchService;
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
