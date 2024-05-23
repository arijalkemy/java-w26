package com.example.Compra.controller;

import com.example.Compra.model.Compra;
import com.example.Compra.service.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
public class CompraController {
    @Autowired
    private ICompraService compraService;

    // Endpoint para crear una nueva compra
    @PostMapping
    public ResponseEntity<Compra> createCompra(@RequestBody Compra compra) {
        Compra savedCompra = compraService.saveCompra(compra);
        return ResponseEntity.ok(savedCompra);
    }

    // Endpoint para obtener todas las compras
    @GetMapping
    public ResponseEntity<List<Compra>> getAllCompras() {
        List<Compra> compras = compraService.getAllCompras();
        return ResponseEntity.ok(compras);
    }
}
