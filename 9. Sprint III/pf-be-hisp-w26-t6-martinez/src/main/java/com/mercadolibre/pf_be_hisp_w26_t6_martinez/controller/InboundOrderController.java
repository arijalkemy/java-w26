package com.mercadolibre.pf_be_hisp_w26_t6_martinez.controller;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.BatchDto.BatchInsertionRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.BatchDto.BatchInsertionResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.inboundOrder.IInboundOrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("hasAuthority('SUPERVISOR')")
@RequestMapping("/api/v1/fresh-products/inboundorder")
@Validated
public class InboundOrderController {

    private final IInboundOrderService inboundOrderService;

    public InboundOrderController(IInboundOrderService inboundOrderService) {
        this.inboundOrderService = inboundOrderService;
    }

    @PostMapping
    public ResponseEntity<BatchInsertionResponseDto> insertBatchInFulfillmentWarehouse(
            @RequestBody @Valid BatchInsertionRequestDto batchInsert) {
        return new ResponseEntity<>(inboundOrderService.insertBatchInFulfillmentWarehouse(batchInsert, false),
                HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<BatchInsertionResponseDto> updateBatchInFulfillmentWarehouse(
            @RequestBody @Valid BatchInsertionRequestDto batchInsert) {
        return new ResponseEntity<>(inboundOrderService.insertBatchInFulfillmentWarehouse(batchInsert, true),
                HttpStatus.CREATED);
    }
}
