package com.mercadolibre.final_project_java_hisp_w26_t6.controller;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.PurchaseOrderDto.PurchaseOrderInsertRequestDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.PurchaseOrderDto.PurchaseOrderProductListResponseDto.PurchaseOrderProductsResponseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.PurchaseOrderDto.PurchasePostResponseDto.PurchaseOrderPostResponseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.services.purchaseOrder.IPurchaseOrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@PreAuthorize("hasAuthority('BUYER')")
@RequestMapping("/api/v1/fresh-products/orders")
@Validated
public class PurchaseOrderController {

    @Autowired
    IPurchaseOrderService purchaseOrderService;

    @PostMapping
    public ResponseEntity<PurchaseOrderPostResponseDto> addProductsToCart(
            @RequestBody @Valid PurchaseOrderInsertRequestDto order){
        return new ResponseEntity<>(purchaseOrderService.addPurchaseOrder(order), HttpStatus.CREATED);
    }

    @GetMapping("/{idOrder}")
    public ResponseEntity<PurchaseOrderProductsResponseDto> getProductsFromCart(
            @PathVariable("idOrder") @Positive(message = "El id debe ser positivo") Long idOrder){
        return new ResponseEntity<>(purchaseOrderService.getPurchaseOrderProducts(idOrder), HttpStatus.OK);
    }

    @PutMapping("/{idOrder}")
    public ResponseEntity<PurchaseOrderPostResponseDto>
    updateProductsFromCart(
            @PathVariable("idOrder") @Positive(message = "El id debe ser positivo") Long idOrder,
            @RequestBody @Valid PurchaseOrderInsertRequestDto order){
        return new ResponseEntity<>(purchaseOrderService.updatePurchaseOrder(order, idOrder), HttpStatus.CREATED);
    }
}
