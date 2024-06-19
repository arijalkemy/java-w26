package com.mercadolibre.pf_be_hisp_w26_t01_coro.controller;

import com.mercadolibre.pf_be_hisp_w26_t01_coro.authentication.AuthenticationService;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.BatchStockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos.InboundOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_coro.service.interfaces.IInboundOrdenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products/inboundorder")
@RequiredArgsConstructor
public class InboundOrderController {

    private final AuthenticationService authenticationService;
    private final IInboundOrdenService inboundOrderService;
    @PostMapping
    public ResponseEntity<BatchStockResponseDTO> createInboundOrder(
            @RequestBody InboundOrderRequestDTO inboundOrderRequestDTO ) {
        String email = authenticationService.getLogMail();
        BatchStockResponseDTO response = inboundOrderService.create(inboundOrderRequestDTO.getInboundOrderDto(), email);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PutMapping
    public ResponseEntity<?> updateInboundOrder(@RequestBody InboundOrderRequestDTO inboundOrderRequestDTO){
        String email = authenticationService.getLogMail();
        BatchStockResponseDTO response = inboundOrderService.update(inboundOrderRequestDTO.getInboundOrderDto(), email);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
