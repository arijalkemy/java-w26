package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.controller;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request.ShippingOrderChangeStateRequestDTO;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.service.interfaces.IShippingOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shipping-orders")
public class ShippingOrderController {

    final IShippingOrderService shippingOrderService;

    @PostMapping("/{idPurchaseOrder}")
    public ResponseEntity<?> createShippingOrder(
            @PathVariable Integer idPurchaseOrder
    ) {
        return new ResponseEntity<>(
                shippingOrderService.generateShippingOrder(idPurchaseOrder),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{idShippingOrder}")
    public ResponseEntity<?> getShippingOrder(
            @PathVariable Integer idShippingOrder
    ) {
        return new ResponseEntity<>(
                shippingOrderService.getShippingOrderById(idShippingOrder),
                HttpStatus.OK
        );
    }

    @PostMapping("update-state/{idShippingOrder}")
    public ResponseEntity<?> updateStateShippingOrder(
            @PathVariable Integer idShippingOrder,
            @RequestBody ShippingOrderChangeStateRequestDTO state
    ) {

        return new ResponseEntity<>(
                shippingOrderService.updateStateShippingOrder(idShippingOrder, state),
                HttpStatus.OK
        );
    }

    @GetMapping("/pending")
    public ResponseEntity<?> getShippingOrdersPending() {
        return new ResponseEntity<>(
                shippingOrderService.getShippingOrdersPending(),
                HttpStatus.OK
        );
    }

}
