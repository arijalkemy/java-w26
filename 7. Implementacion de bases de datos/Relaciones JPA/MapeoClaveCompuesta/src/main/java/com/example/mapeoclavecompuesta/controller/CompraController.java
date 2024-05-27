package com.example.mapeoclavecompuesta.controller;

import com.example.mapeoclavecompuesta.model.Compra;
import com.example.mapeoclavecompuesta.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/compras")
public class CompraController {
    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping(path = "/new")
    public ResponseEntity<?> newCompra(@RequestBody Compra compra) {
        this.compraService.saveCompra(compra);
        return ResponseEntity.ok(null);
    }

    @GetMapping()
    public ResponseEntity<?> getAllCompras() {
        return ResponseEntity.ok(this.compraService.getAllCompras());
    }
}
