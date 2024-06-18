package com.mercadolibre.sprint_3_team_12.controller;

import com.mercadolibre.sprint_3_team_12.dto.request.InboundDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.CartDTO;
import com.mercadolibre.sprint_3_team_12.service.IInboundOrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/fresh-products/")
public class InBoundOrderController {
    /**TO REQ 1
     * As a warehouse administrator
     * I want to enter a batch of products into the warehouse to record the existence of stock
     */
    IInboundOrderService inboundOrderService;

    public InBoundOrderController(IInboundOrderService inboundOrderService) {
        this.inboundOrderService = inboundOrderService;
    }

    /**TO REG 1
     * Create a new inbound order in a warehouse
     * @param inboundDTO DTO with the information of the inbound order
     * @return ResponseEntity with the list of batches created in the inbound order
     */
    @PostMapping("/inboundorder")
    public ResponseEntity<?> newInboundOrder(@Valid @RequestBody InboundDTO inboundDTO) {
        return new ResponseEntity<>(inboundOrderService.registerInboundOrder(inboundDTO,false), HttpStatus.CREATED);
    }

    /**TO REG 1
     * Update an existing inbound order in a warehouse
     * @param inboundDTO DTO with the information of the inbound order
     * @return ResponseEntity with the list of batches updated in the inbound order
     */
    @PutMapping("/inboundorder")
    public ResponseEntity<?> updateInboundOrder(@Valid @RequestBody InboundDTO inboundDTO) {
        return new ResponseEntity<>(inboundOrderService.registerInboundOrder(inboundDTO, true), HttpStatus.CREATED);
    }
  
    /**
     * Endpoints that Register an order with the list of products that make up the PurchaseOrder.
     * Calculate the final price, and return it along with a status code “201 CREATED”.
     * @param cartDTO
     * @return
     */
    @PostMapping("/orders")
    public ResponseEntity<?> createInboundOrder(@RequestBody CartDTO cartDTO){
        return new ResponseEntity<>(inboundOrderService.createInBoundOrder(cartDTO), HttpStatus.CREATED);
    }


}
