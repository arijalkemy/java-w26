package com.mercadolibre.pf_be_hisp_w26_t01_arguello.controller;

import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.ProductPurchaseResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.PurchaseOrderDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.PurchaseTotalPriceDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.interfaces.IPurchaseOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/orders")
@RequiredArgsConstructor
public class PurchaseOrderController {

    private final IPurchaseOrderService purchaseOrderService;

    @PostMapping
    public ResponseEntity<PurchaseTotalPriceDTO> calculateOrderFinalPrice(@RequestBody PurchaseOrderDTO purchaseOrderDTO){
        return new ResponseEntity<>(purchaseOrderService.calculatePurchaseTotalPrice(purchaseOrderDTO),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ProductPurchaseResponseDto>> getAllProductsByOrder(@PathVariable("id") Integer orderId){
        return ResponseEntity.ok(purchaseOrderService.searchAllProductsByOrder(orderId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOrder(@PathVariable("id") Integer orderId,@RequestBody PurchaseOrderDTO order){
        purchaseOrderService.modifyOrder(orderId,order);
        return ResponseEntity.ok().build();
    }
}
