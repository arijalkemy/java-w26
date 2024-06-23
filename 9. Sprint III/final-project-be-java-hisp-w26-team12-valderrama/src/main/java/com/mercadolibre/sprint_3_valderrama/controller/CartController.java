package com.mercadolibre.sprint_3_valderrama.controller;

import com.mercadolibre.sprint_3_valderrama.dto.request.CartDTO;
import com.mercadolibre.sprint_3_valderrama.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products/")
public class CartController {
    /** To REQ 2
     *
     */
    @Autowired
    ICartService cartService;

    /**
     * Endpoint to get all products in the cart.
     * Endpoint Number 6.
     * @return List of products in the cart.
     */
    @GetMapping("orders/{idOrder}")
    public ResponseEntity<CartDTO> getCart(@PathVariable Long idOrder) {
        return ResponseEntity.ok(cartService.getCart(idOrder));
    }


}
