package com.mercadolibre.pf_be_hisp_w26_t01_moises.controller;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.authentication.AuthenticationService;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.ProductPurchaseResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.PurchaseOrderDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.PurchaseOrderResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.dtos.PurchaseTotalPriceDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.enums.PurchaseOrderSortingType;
import com.mercadolibre.pf_be_hisp_w26_t01_moises.service.interfaces.IPurchaseOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/fresh-products/orders")
@RequiredArgsConstructor
public class PurchaseOrderController {

    private final IPurchaseOrderService purchaseOrderService;
    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<PurchaseTotalPriceDTO> calculateOrderFinalPrice(@RequestBody PurchaseOrderDTO purchaseOrderDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(purchaseOrderService.calculatePurchaseTotalPrice(purchaseOrderDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ProductPurchaseResponseDto>> getAllProductsByOrder(@PathVariable("id") Integer orderId) {
        return ResponseEntity.ok(purchaseOrderService.searchAllProductsByOrder(orderId));
    }

    @GetMapping("own")
    public ResponseEntity<List<PurchaseOrderResponseDTO>> getAllOrdersByBuyer(
            @RequestParam(value = "sort", required = false) Optional<PurchaseOrderSortingType> sortingType
    ) {
        String buyerEmail = authenticationService.getLogMail();
        return ResponseEntity.ok(purchaseOrderService.getAllByBuyerEmailSorted(buyerEmail,sortingType));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOrder(@PathVariable("id") Integer orderId, @RequestBody PurchaseOrderDTO order) {
        purchaseOrderService.modifyOrder(orderId, order);
        return ResponseEntity.ok().build();
    }
}
