package org.ggomezr.clavescompuestas.application.controller;

import org.ggomezr.clavescompuestas.application.service.impl.CompraService;
import org.ggomezr.clavescompuestas.domain.dto.CompraDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> crearCompra(@RequestBody CompraDTO compraDTO){
        return new ResponseEntity<>(compraService.crearCompra(compraDTO), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> obtenerTodasLasCompras(){
        return new ResponseEntity<>(compraService.obtenerTodasLasCompras(), HttpStatus.OK);
    }
}
