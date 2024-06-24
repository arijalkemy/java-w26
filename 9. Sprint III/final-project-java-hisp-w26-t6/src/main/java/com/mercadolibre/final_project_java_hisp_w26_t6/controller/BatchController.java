package com.mercadolibre.final_project_java_hisp_w26_t6.controller;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.BatchDto.BatchStockListResponseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.services.batch.IBatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("hasAuthority('SUPERVISOR')")
@RequestMapping("/api/v1/fresh-products/batch")
public class BatchController {

    private final IBatchService batchService;

    public BatchController(IBatchService batchService) {
        this.batchService = batchService;
    }

    @GetMapping("/list/due-date/{cantDays}")
    public ResponseEntity<?> listBatchesExpiringInLessThanDays(@PathVariable Integer cantDays,
                                                               @RequestParam(required = false) String category,
                                                               @RequestParam(required = false) String order) {
        BatchStockListResponseDto batches = batchService.getBatchesInDueDate(cantDays, category, order);
        return new ResponseEntity<>(batches, HttpStatus.OK);
    }
}
