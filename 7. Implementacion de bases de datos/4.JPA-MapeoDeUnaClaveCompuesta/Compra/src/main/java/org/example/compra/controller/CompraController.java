package org.example.compra.controller;

import org.example.compra.Dto.CompraRequestDto;
import org.example.compra.services.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/compras")
public class CompraController {
    @Autowired
    ICompraService compraService;

    @PostMapping
    public ResponseEntity<?> postCompra(@RequestBody CompraRequestDto compraRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(compraService.create(compraRequestDto));
    }
}
