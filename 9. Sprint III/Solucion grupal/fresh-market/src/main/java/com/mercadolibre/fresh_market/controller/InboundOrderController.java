package com.mercadolibre.fresh_market.controller;

import com.mercadolibre.fresh_market.dtos.BatchDTO;
import com.mercadolibre.fresh_market.dtos.InboundOrderDTO;
import com.mercadolibre.fresh_market.service.IInboundOrder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/inboundorder")
public class InboundOrderController {

    @Autowired
    private IInboundOrder inboundOrderService;

    @Operation(summary = "Create a inbound order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the Batch list",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = InboundOrderDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Some param is bad or does not exists", content = @Content),
            @ApiResponse(responseCode = "403", description = "User has no permissions to modify the order", content = @Content)
    })
    @PostMapping
    public ResponseEntity<List<BatchDTO>> postCreateInboundOrder(@RequestBody InboundOrderDTO inboundOrderDTO){
        return ResponseEntity.status(HttpStatus.OK).body(inboundOrderService.createInboundOrder(inboundOrderDTO));
    }

    @Operation(summary = "Update a inbound order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the Batch list",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = InboundOrderDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Some param is bad or does not exists", content = @Content),
            @ApiResponse(responseCode = "403", description = "User has no permissions to modify the order", content = @Content)
    })
    @PutMapping
    public ResponseEntity<List<BatchDTO>> putUpdateInboundOrder(@RequestParam Long id, @RequestBody InboundOrderDTO inboundOrderDTO){
        return ResponseEntity.status(HttpStatus.OK).body(inboundOrderService.updateInboundOrder(id, inboundOrderDTO));
    }
}
