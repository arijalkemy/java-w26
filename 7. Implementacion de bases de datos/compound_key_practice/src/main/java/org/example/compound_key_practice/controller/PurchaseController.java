package org.example.compound_key_practice.controller;

import org.example.compound_key_practice.models.dtos.ResponsePurchaseDto;
import org.example.compound_key_practice.service.IPurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PurchaseController {
    private final IPurchaseService service;

    public PurchaseController(IPurchaseService service) {
        this.service = service;
    }

    @GetMapping("/new")
    public ResponseEntity<ResponsePurchaseDto> createPurchase(
            @RequestBody ResponsePurchaseDto purchaseDto
    ) {
        ResponsePurchaseDto responsePurchaseDto = service.createPurchase(purchaseDto);
        return ResponseEntity.ok(responsePurchaseDto);
    }
}
