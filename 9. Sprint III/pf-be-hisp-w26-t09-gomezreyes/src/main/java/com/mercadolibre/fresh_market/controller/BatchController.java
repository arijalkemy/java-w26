package com.mercadolibre.fresh_market.controller;

import com.mercadolibre.fresh_market.dtos.BatchLocationResponseDTO;
import com.mercadolibre.fresh_market.dtos.ExpiringProductResponseDTO;
import com.mercadolibre.fresh_market.service.IBatchService;
import com.mercadolibre.fresh_market.service.impl.BatchServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class BatchController {
    @Autowired
    IBatchService batchService;

    @Operation(summary = "Get batches expiring soon")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully retrieved the batches",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ExpiringProductResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input parameters", content = @Content),
            @ApiResponse(responseCode = "403", description = "User has no permissions to access the batches",
                    content = @Content), @ApiResponse(responseCode = "500", description = "Internal server error",
            content = @Content)})
    @GetMapping("batch/list/due-date/{cantDays}")
    public ResponseEntity<ExpiringProductResponseDTO> getBatchesExpiringSoon(@PathVariable Integer cantDays, @RequestParam(required = false) String category, @RequestParam(required = false) String order) {

        if (category != null && order != null) {
            ExpiringProductResponseDTO response = batchService.getBatchesExpiringSoonByCategoryAndOrder(cantDays, category, order);
            return ResponseEntity.ok(response);
        }
        ExpiringProductResponseDTO response = batchService.getBatchesExpiringSoon(cantDays);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get batches by product id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully retrieved the batches by product id",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = BatchLocationResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Product is not available", content = @Content),
            @ApiResponse(responseCode = "403", description = "You don't have permissions to access this warehouse",
                    content = @Content), @ApiResponse(responseCode = "500", description = "Internal server error",
            content = @Content)})
    @GetMapping("/{idProduct}/batch/list")
    public ResponseEntity<BatchLocationResponseDTO> getBatchByProductId(@PathVariable Long idProduct, @RequestParam(required = false) String order) {
        if (order != null) {
            return ResponseEntity.ok(batchService.getBatchByProductIdOrdered(idProduct, order));
        } else {
            return ResponseEntity.ok(batchService.getBatchByProductId(idProduct));
        }
    }
}


