package com.mercadolibre.project_be_java_hisp_w26_team5.controller;

import com.mercadolibre.project_be_java_hisp_w26_team5.dto.request.PurchaseOrderRequestDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.service.interfaces.IPurchaseOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/purchase-orders")
@RequiredArgsConstructor
public class PurchaseOrderController {

    final IPurchaseOrderService purchaseOrderService;

    @PostMapping
    public ResponseEntity<?> createPurchaseOrder(@RequestBody @Valid PurchaseOrderRequestDTO purchaseOrderDTO) {
        return new ResponseEntity<>(
                purchaseOrderService.upsertPurchaseOrder(purchaseOrderDTO,null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{idOrder}/products")
    public ResponseEntity<?> getProductsOfPurchaseOrder(
            @PathVariable("idOrder") Integer idOrder
    ) {
        return new ResponseEntity<>(
                purchaseOrderService.getProductsOfPurchaseOrder(idOrder),
                HttpStatus.OK
        );
    }

    @PutMapping("/{idOrder}")
    public ResponseEntity<?> updatePurchaseOrder(
            @PathVariable("idOrder") Integer idOrder,
            @RequestBody @Valid PurchaseOrderRequestDTO purchaseOrderDTO
    ) {
        return new ResponseEntity<>(
                purchaseOrderService.upsertPurchaseOrder(purchaseOrderDTO, idOrder),
                HttpStatus.OK
        );
    }

}
