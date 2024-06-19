package com.mercadolibre.final_project_java_hisp_w26_t1.controller;

import com.mercadolibre.final_project_java_hisp_w26_t1.authentication.AuthenticationService;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.BatchStockResponseDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.dtos.InboundOrderRequestDTO;
import com.mercadolibre.final_project_java_hisp_w26_t1.service.interfaces.IInboundOrdenService;
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
