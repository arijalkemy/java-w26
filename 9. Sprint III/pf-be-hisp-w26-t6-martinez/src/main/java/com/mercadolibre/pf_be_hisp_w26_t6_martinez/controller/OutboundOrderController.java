package com.mercadolibre.pf_be_hisp_w26_t6_martinez.controller;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.OutboundOrderDto.OutboundOrderRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.TransferService.ITransferService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

// REQ 6 INIDIVIDUAL
@RestController
@PreAuthorize("hasAuthority('SUPERVISOR')")
@RequestMapping("/api/v1/fresh-products/outboundorder")
@Validated
public class OutboundOrderController {

    @Autowired
    ITransferService transferService;

    @PreAuthorize("hasAuthority('SUPERVISOR')")
    @PostMapping
    public ResponseEntity<?> initiateTransfer(
            @RequestBody @Valid OutboundOrderRequestDto outboudOrder) {

        transferService.initiateTransfer(outboudOrder.getOutboundOrderDto());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PreAuthorize("hasAuthority('SUPERVISOR')")
    @PutMapping("/{orderNumber}")
    public ResponseEntity<?> updateTransfer(
            @RequestBody @Positive(message = "The order number must be positive") @PathVariable Long orderNumber,
            @RequestParam String status
    ) {

        transferService.updateTransferStatus(orderNumber, status);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
