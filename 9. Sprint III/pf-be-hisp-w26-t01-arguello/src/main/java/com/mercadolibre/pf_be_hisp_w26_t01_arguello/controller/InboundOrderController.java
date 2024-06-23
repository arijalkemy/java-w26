package com.mercadolibre.pf_be_hisp_w26_t01_arguello.controller;

import com.mercadolibre.pf_be_hisp_w26_t01_arguello.authentication.AuthenticationService;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.BatchStockResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.InboundOrderRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.InboundOrderResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.interfaces.IInboundOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/inboundorder")
@RequiredArgsConstructor
public class InboundOrderController {

    private final AuthenticationService authenticationService;
    private final IInboundOrderService inboundOrderService;
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

    @GetMapping("/warehouse/{idWarehouse}")
    public ResponseEntity<List<InboundOrderResponseDTO>> getOrdersByIdWarehouse(@PathVariable int idWarehouse){

        String email = authenticationService.getLogMail();

        var response = inboundOrderService.getAllByIdWarehouse(idWarehouse,email);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{idOrder}")
    public ResponseEntity<InboundOrderResponseDTO> getOrderById(@PathVariable int idOrder){

        String email = authenticationService.getLogMail();

        var response = inboundOrderService.getById(idOrder, email);
        return ResponseEntity.ok().body(response);
    }
}
