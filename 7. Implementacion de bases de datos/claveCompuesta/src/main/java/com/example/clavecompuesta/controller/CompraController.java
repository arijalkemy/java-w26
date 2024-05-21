package com.example.clavecompuesta.controller;

import com.example.clavecompuesta.entity.Compra;
import com.example.clavecompuesta.service.ICompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
@RequiredArgsConstructor
public class CompraController {

    private final ICompraService compraService;


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Compra compra) {
        return ResponseEntity.status(HttpStatus.CREATED).body(compraService.save(compra));
    }

}
