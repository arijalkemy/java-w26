package com.mercadolibre.fresh_market.controller;

import com.mercadolibre.fresh_market.dtos.ProjectionPurchaseOrder;
import com.mercadolibre.fresh_market.dtos.PurchaseOrderDTO;
import com.mercadolibre.fresh_market.dtos.Response;
import com.mercadolibre.fresh_market.dtos.ResponseDTO;
import com.mercadolibre.fresh_market.exceptions.ApiError;
import com.mercadolibre.fresh_market.service.IPurchaseOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/fresh-products")
public class PurchaseOrderController {

    private final IPurchaseOrderService purchaseOrderService;

    public PurchaseOrderController(IPurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }


    /**
     * Modify the existence of a purchase order based on the provided orderId and PurchaseOrderDTO.
     *
     * @param orderId        The ID of the purchase order to modify.
     * @param purchaseOrderDTO The PurchaseOrderDTO containing the updated order information.
     * @return ResponseEntity with ResponseDTO containing the message "Updated successfully" and the total price.
     */
    @Operation(summary = "Modify the existence of a purchase order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated the purchase order",
             content = {
                    @Content(mediaType = "application/json",
                    schema = @Schema(implementation = PurchaseOrderDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Purchase order not found", content = @Content),
            @ApiResponse(responseCode = "403", description = "User has no permissions to modify the order", content = @Content)
    })
    @PutMapping("/orders/{orderId}")
    public ResponseEntity<ResponseDTO> modifyOrderExistence(@PathVariable Long orderId, @RequestBody PurchaseOrderDTO purchaseOrderDTO){
        return ResponseEntity.ok().body(purchaseOrderService.modifyOrderExistence(orderId, purchaseOrderDTO));
    }

    @Operation(summary = "Create a purchase order")
    @PostMapping("/orders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created the purchase order",
             content = {
                    @Content(mediaType = "application/json",
                    schema = @Schema(implementation = PurchaseOrderDTO.class))}),
            @ApiResponse(responseCode = "404", description = "The products with the next list of IDs not exists!", content = @Content),
            @ApiResponse(responseCode = "409", description = "There are not enought stock for the next products: ", content = @Content)
    })
    public ResponseEntity<Response> postPurchaseOrder(@RequestBody PurchaseOrderDTO purchaseOrderDTO, @AuthenticationPrincipal UserDetails userDetails) { 
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseOrderService.createPurcharseOrder(purchaseOrderDTO, userDetails)); 
    }

        @GetMapping("/orders/{idOrder}")
    @Operation(summary = "Get products by purchase order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Getting products succesfully",
             content = {
                    @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProjectionPurchaseOrder.class))}),
            @ApiResponse(responseCode = "404", description = "The purchase order with id  idOrder  was not found.", content = {@Content(mediaType = "application/json",schema =  @Schema(implementation = ApiError.class))}),
    })
    public ResponseEntity<ProjectionPurchaseOrder> getMethodName(@PathVariable(value = "idOrder") Long idOrder) {
        return ResponseEntity.status(HttpStatus.OK).body(purchaseOrderService.getProductsByPurchaseOrder(idOrder));
    }
    
}
