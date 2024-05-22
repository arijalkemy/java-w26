package org.implementaciondb.ejercicio4_clavecompuesta.controller;

import org.implementaciondb.ejercicio4_clavecompuesta.dto.CompraDto;
import org.implementaciondb.ejercicio4_clavecompuesta.service.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompraController {

    @Autowired
    private ICompraService compraService;

    @PostMapping("/compras")
    public ResponseEntity<?> addCompra(@RequestBody CompraDto compraDto) {
        compraService.saveCompra(compraDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
