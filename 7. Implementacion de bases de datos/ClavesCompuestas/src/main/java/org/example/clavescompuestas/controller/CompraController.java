package org.example.clavescompuestas.controller;


import org.example.clavescompuestas.dto.CompraDTO;
import org.example.clavescompuestas.entity.Compra;
import org.example.clavescompuestas.service.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CompraController {

    @Autowired
    private ICompraService compraService;

    @GetMapping
    public ResponseEntity<?> getAllCompras() {
        return new ResponseEntity<>(compraService.getAllCompras(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCompra(@RequestBody CompraDTO compra) {
        return new ResponseEntity<>(compraService.save(compra), HttpStatus.CREATED);
    }
}
