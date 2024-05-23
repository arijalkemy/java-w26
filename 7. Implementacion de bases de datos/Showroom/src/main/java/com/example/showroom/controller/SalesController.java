package com.example.showroom.controller;

import com.example.showroom.service.ISalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sale")
@RequiredArgsConstructor
public class SalesController {

    private final ISalesService salesService;

    @PostMapping()
    public ResponseEntity<?> addSale() {
        return ResponseEntity.status(HttpStatus.CREATED).body("metodo");
    }

    @GetMapping()
    public ResponseEntity<?> getAllSales() {
        return ResponseEntity.status(HttpStatus.OK).body(salesService.getClass());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSalesByNumber(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body("metodo");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSale()

    //Crear una nueva venta.
    //
    //GET
    //
    ///api/sale
    //
    //Devolver todas las ventas
    //
    //GET
    //
    ///api/sale/{number}
    //
    //Devolver una venta en particular
    //
    //PUT
    //
    ///api/sale/{number}
    //
    //Actualizar una venta en particular
    //
    //DELETE
    //
    ///api/sale/{number]
    //
    //Eliminar una venta en particular
    //
    //GET
    //
    ///api/sale?date=22/05/2022
    //
    //Traer todas las prendas de una determinada fecha
    //
    //GET
    //
    ///api/sale/clothes/{number}
    //
    //Traer la lista completa de prendas de una determinada venta.
}
