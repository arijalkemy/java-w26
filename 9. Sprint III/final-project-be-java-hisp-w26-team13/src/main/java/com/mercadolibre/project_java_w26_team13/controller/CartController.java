package com.mercadolibre.project_java_w26_team13.controller;

import com.mercadolibre.project_java_w26_team13.dtos.CartRequestDto;
import com.mercadolibre.project_java_w26_team13.dtos.CartResponseDto;
import com.mercadolibre.project_java_w26_team13.service.ICartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    ICartService cartService;

    CartController(ICartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/api/v1/fresh-products/orders")
    public ResponseEntity<CartResponseDto> createCart(
            @RequestBody CartRequestDto cartRequestDto,
            @RequestHeader("Authorization") String authorizationHeader
    ) {
        return new ResponseEntity<>(cartService.createCart(authorizationHeader, cartRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/api/v1/fresh-products/orders/{idOrder}")
    public ResponseEntity<CartResponseDto> updateOrder(@PathVariable Long idOrder,
                                                       @RequestBody CartRequestDto cart,
                                                       @RequestHeader("Authorization") String authorizationHeader){
        return new ResponseEntity<>(cartService.updateCart(authorizationHeader, idOrder, cart), HttpStatus.CREATED);
    }
    @GetMapping("/api/v1/fresh-products/orders/{idOrder}")
    public ResponseEntity<CartRequestDto> getCart(@PathVariable Long idOrder,
                                                   @RequestHeader("Authorization") String authorizationHeader) {
        return ResponseEntity.ok().body(cartService.searchCart(authorizationHeader, idOrder));
    }
}
